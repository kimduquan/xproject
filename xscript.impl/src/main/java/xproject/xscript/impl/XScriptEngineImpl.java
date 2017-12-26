package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xproject.util.XScanner;
import xproject.util.impl.XScannerImpl;
import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.impl.XClassImpl;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.impl.XObjectImpl;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XMethod;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xscript.XScriptEngineEx;

public class XScriptEngineImpl implements XScriptEngine, XScriptEngineEx {

	private static final String THIS = "this";
	private static final String CLASS = "class";
	private static final String PACKAGE = "package";
	private static final String PARAMETER_NAME_PREFIX = "-";
	private static final String OBJECT_REF_PREFIX = "#";
	private static final String PARAMETER_SEPARATOR = "\t";
	
	private XObject xthis;
	private HashMap<String, XClass> importedClasses;
	
	private boolean isReturned;
	private XObject returnedObj;
	
	protected XScriptEngineImpl()
	{
		xthis = XObject.NULL;
		importedClasses = new HashMap<String, XClass>();
		
		isReturned = false;
		returnedObj = null;
	}
	
	protected String xgetParam(String param, XScanner scanner, String defVal) throws Exception
	{
		if(scanner.xhasNext())
		{
			String name = scanner.xnext();
			if(name.startsWith(PARAMETER_NAME_PREFIX))
			{
				name = name.substring(PARAMETER_NAME_PREFIX.length());
				if(name.equals(param))
				{
					if(scanner.xhasNext())
					{
						return scanner.xnext();
					}
				}
			}
		}
		return defVal;
	}
	
	protected XObject xgetObjectParam(String param, XScanner scanner, XScriptContext context, XObject defObj) throws Exception
	{
		String value = xgetParam(param, scanner, "");
		if(value.isEmpty() == false)
		{
			if(value.startsWith(OBJECT_REF_PREFIX))
			{
				value = value.substring(OBJECT_REF_PREFIX.length());
				XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
				if(bindings.xcontainsKey(value))
				{
					return bindings.xget(value);
				}
			}
		}
		return defObj;
	}
	
	protected XClass xgetClassParam(String param, XScanner scanner, XScriptContext context, XClass defCls) throws Exception
	{
		String clsName = xgetParam(CLASS, scanner, "");
		if(clsName.isEmpty() == false)
		{
			if(importedClasses.containsKey(clsName))
			{
				return importedClasses.get(clsName);
			}
		}
		return defCls;
	}
	
	public XObject xeval(XScanner scanner, XScanner inLineScanner, XScriptContext context) throws Exception
	{
		String methodName = "";
		while(inLineScanner.xhasNext() && methodName.isEmpty())
		{
			methodName = inLineScanner.xnext();
		}
		
		if(methodName.isEmpty() == false)
		{
			xeval(methodName, inLineScanner, context);
		}
		return XObject.NULL;
	}
	
	public XObject xeval(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		xthis = XFactoryImpl.get().xObject(this);
		context.xgetBindings(XScriptContext.XENGINE_SCOPE).xput(THIS, xthis);
		
		XScanner inLineScanner = null;
		
		for(
				isReturned = false, 
				returnedObj = null;
				
				isReturned == false && scanner.xhasNextLine();)
		{
			inLineScanner = XScannerImpl.xnew(scanner, PARAMETER_SEPARATOR);
			
			xeval(scanner, inLineScanner, context);
			
			inLineScanner.xclose();
			inLineScanner = null;
		}
		
		return xthis;
	}
	
	public XObject xeval(String method, XScanner inLineScanner, XScriptContext context) throws Exception
	{
		if(method.equals(RETURN))
		{
			return xreturn(inLineScanner, context);
		}
		else if(method.equals(IMPORT))
		{
			ximport(inLineScanner, context);
		}
		else if(method.equals(NEW))
		{
			return xnew(inLineScanner, context);
		}
		else if(method.equals(TRY))
		{
			
		}
			
		return xinvoke(method, inLineScanner, context);
	}
	
	public static XScriptEngine xnew()
	{
		return new XScriptEngineImpl();
	}

	public void ximport(XScanner scanner, XScriptContext context) throws Exception {

		String name = xgetParam(CLASS, scanner, "");
		if(name.isEmpty() == false)
		{
			XClass xclass = XClassImpl.xforName(name);
			ximport(xclass);
		}
	}
	
	public void ximport(XClass xclass) throws Exception
	{
		importedClasses.put(xclass.xgetName(), xclass);
	}
	
	public XObject xreturn(XObject obj) throws Exception
	{
		returnedObj = obj;
		isReturned = true;
		return obj;
	}
	
	public XObject xinvoke(String method, XScanner scanner, XScriptContext context) throws Exception 
	{
		ArrayList<XClass> xclasses = new ArrayList<XClass>();
		xclasses.addAll(this.importedClasses.values());
		
		XObject xobject = xgetObjectParam(THIS, scanner, context, XObject.NULL);
		
		if(xobject == XObject.NULL) 
		{
			XClass xclass = xgetClassParam(CLASS, scanner, context, null);
			if(xclass != null)
			{
				xclasses.clear();
				xclasses.add(xclass);
			}
		}
		else
		{
			xclasses.clear();
			xclasses.add(xobject.xgetClass());
		}
		
		boolean isStatic = xobject == XObject.NULL;
		ArrayList<XMethod> xmethods = new ArrayList<XMethod>();
		
		for(XClass xclass : xclasses)
		{
			for(XMethod xmethod : xclass.xgetMethods())
			{
				if(xmethod.xgetName().equals(method) && xmethod.xgetModifiers().xisStatic() == isStatic)
				{
					xmethods.add(xmethod);
				}
			}
		}
		
		
		
		ArrayList<XObject> paramValues = new ArrayList<XObject>();
		for(int index = 0; scanner.xhasNext(); index++)
		{
			String name = scanner.xnext();
			if(name.startsWith(PARAMETER_NAME_PREFIX))
			{
				name = name.substring(0, PARAMETER_NAME_PREFIX.length());
				XClass paramType = null;
				Class<?> primitiveType = null;
				
				if(scanner.xhasNextBoolean())
				{
					primitiveType = Boolean.class;
				}
				else if(scanner.xhasNextByte())
				{
					primitiveType = Byte.class;
				}
				else if(scanner.xhasNextDouble())
				{
					primitiveType = Double.class;
				}
				else if(scanner.xhasNextFloat())
				{
					primitiveType = Float.class;
				}
				else if(scanner.xhasNextInt())
				{
					primitiveType = Integer.class;
				}
				else if(scanner.xhasNextLong())
				{
					primitiveType = Long.class;
				}
				else if(scanner.xhasNextShort())
				{
					primitiveType = Short.class;
				}
				else if(scanner.xhasNext())
				{
					
				}
				

				ArrayList<XMethod> xmethods2 = new ArrayList<XMethod>();
				for(XMethod xmethod : xmethods)
				{
					if(name.isEmpty() || xmethod.xgetName().equals(name))
					{
						XClass[] paramTypes = xmethod.xgetParameterTypes();
						if(paramTypes.length > index)
						{
							
						}
					}
				}
			}
		}
		
		return xthis;
	}

	

	public XObject xnew(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObject xnew(XClass xclass, XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xtry(XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public XObject xcatch(XClass exceptionType, XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObject xcatch(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean xif(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xelse(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public void xwhile(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void xbreak(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void xfor(XArray array, XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public XObject xreturn(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
