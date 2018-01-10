package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.HashMap;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XMethod;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xscript.XScriptEngineEx;
import xproject.xutil.XScanner;

public class XScriptEngineImpl implements XScriptEngine, XScriptEngineEx {

	private static final String THIS = "this";
	private static final String NULL = "null";
	private static final String CLASS = "class";
	private static final String RETURN = "return";
	private static final String PARAMETER_NAME_PREFIX = "-";
	private static final String OBJECT_REF_PREFIX = "#";
	private static final String PARAMETER_SEPARATOR = "\t";
	
	private HashMap<String, XClass> importedClasses;
	
	private XFactory xfactory;
	private XRegistry xregistry;
	
	protected XScriptEngineImpl(XFactory factory, XRegistry registry)
	{
		importedClasses = new HashMap<String, XClass>();
		xfactory = factory;
		xregistry = registry;
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
	
	protected void xsetObjectParam(String param, XScanner scanner, XScriptContext context, XObject defObj) throws Exception
	{
		String value = xgetParam(param, scanner, "");
		if(value.isEmpty() == false)
		{
			if(value.startsWith(OBJECT_REF_PREFIX))
			{
				value = value.substring(OBJECT_REF_PREFIX.length());
				XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
				bindings.xput(value, defObj);
			}
		}
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
	
	protected String xgetMethodName(XScanner inLineScanner) throws Exception
	{
		String methodName = "";
		while(inLineScanner.xhasNext() && methodName.isEmpty())
		{
			methodName = inLineScanner.xnext();
		}
		return methodName;
	}
	
	public XObject xeval(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		context.xgetBindings(XScriptContext.XENGINE_SCOPE).xput(NULL, xfactory.xObject(null));
		
		XScanner inLineScanner = null;
		XObject xobject = XObject.xnull;
		boolean isBreak = false;
		
		for(;scanner.xhasNextLine() && isBreak == false;)
		{
			inLineScanner = scanner.xnextLine();
			inLineScanner = inLineScanner.xuseDelimiter(PARAMETER_SEPARATOR);
			
			String methodName = xgetMethodName(inLineScanner);
			
			if(methodName.isEmpty() == false)
			{
				xobject = xeval(methodName, scanner, inLineScanner, context);
			}
			
			if(methodName.equals(RETURN))
			{
				isBreak = true;
			}
			
			inLineScanner.xclose();
			inLineScanner = null;
		}
		
		return xobject;
	}
	
	public XObject xeval(String method, XScanner scanner, XScanner inLineScanner, XScriptContext context) throws Exception
	{
		if(method.equals(IMPORT))
		{
			ximport(inLineScanner, context);
		}
		else if(method.equals(NEW))
		{
			return xnew(inLineScanner, context);
		}
		else if(method.equals(RETURN))
		{
			return xreturn(inLineScanner, context);
		}
		else if(method.equals(TRY))
		{
			xtry(scanner, inLineScanner, context);
		}
		else if(method.equals(IF))
		{
			xif(scanner, inLineScanner, context);
		}
		else if(method.equals(DO))
		{
			xif(scanner, inLineScanner, context);
		}
			
		return xinvoke(method, inLineScanner, context);
	}
	
	public static XScriptEngine xnew(XFactory xfactory, XRegistry registry)
	{
		return new XScriptEngineImpl(xfactory, registry);
	}

	public void ximport(XScanner scanner, XScriptContext context) throws Exception {

		String name = xgetParam(CLASS, scanner, "");
		if(name.isEmpty() == false)
		{
			XClass xclass = (XClass) xregistry.xlookup(name);
			if(xclass != null)
				ximport(xclass);
		}
	}
	
	public void ximport(XClass xclass) throws Exception
	{
		importedClasses.put(xclass.xgetSimpleName(), xclass);
	}
	
	public XObject xinvoke(String method, XScanner scanner, XScriptContext context) throws Exception 
	{
		ArrayList<XClass> xclasses = new ArrayList<XClass>();
		xclasses.addAll(importedClasses.values());
		
		XObject xobject = xgetObjectParam(THIS, scanner, context, XObject.xnull);
		
		if(xobject == XObject.xnull) 
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
		
		
		ArrayList<XObject> paramValues = new ArrayList<XObject>();
		
		for(; scanner.xhasNext();)
		{
			String name = scanner.xnext();
			if(name.startsWith(PARAMETER_NAME_PREFIX))
			{
				name = name.substring(0, PARAMETER_NAME_PREFIX.length());
				
				if(scanner.xhasNextBoolean())
				{
					paramValues.add(xfactory.xObject(scanner.xnextBoolean()));
				}
				else if(scanner.xhasNextByte())
				{
					paramValues.add(xfactory.xObject(scanner.xnextByte()));
				}
				else if(scanner.xhasNextDouble())
				{
					paramValues.add(xfactory.xObject(scanner.xnextDouble()));
				}
				else if(scanner.xhasNextFloat())
				{
					paramValues.add(xfactory.xObject(scanner.xnextFloat()));
				}
				else if(scanner.xhasNextInt())
				{
					paramValues.add(xfactory.xObject(scanner.xnextInt()));
				}
				else if(scanner.xhasNextLong())
				{
					paramValues.add(xfactory.xObject(scanner.xnextLong()));
				}
				else if(scanner.xhasNextShort())
				{
					paramValues.add(xfactory.xObject(scanner.xnextShort()));
				}
				else if(scanner.xhasNext())
				{
					String value = scanner.xnext();
					
					if(value.startsWith(OBJECT_REF_PREFIX))
					{
						value = value.substring(OBJECT_REF_PREFIX.length());
						XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
						if(bindings.xcontainsKey(value))
						{
							paramValues.add(bindings.xget(value));
						}
					}
					else
					{
						paramValues.add(xfactory.xObject(value));
					}
				}
			}
		}
		
		XClass[] xparameterTypes = new XClass[paramValues.size()];
		for(int i = 0; i < xparameterTypes.length; i++)
		{
			xparameterTypes[i] = paramValues.get(i).xgetClass();
		}
		
		XMethod xmethod = null;
		for(XClass xclass : xclasses)
		{
			xmethod = xclass.xgetMethod(method, xparameterTypes);
			if(xmethod != null)
			{
				break;
			}
		}
		
		if(xmethod != null)
		{
			XObject[] xparameters = new XObject[paramValues.size()];
			xparameters = paramValues.toArray(xparameters);
			XObject xreturn = xmethod.xinvoke(xobject, xparameters);
			xsetObjectParam(RETURN, scanner, context, xreturn);
			return xreturn;
		}
		
		return XObject.xnull;
	}

	

	public XObject xnew(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<XClass> xclasses = new ArrayList<XClass>();
		xclasses.addAll(importedClasses.values());
		
		XObject xobject = xgetObjectParam(THIS, scanner, context, XObject.xnull);
		
		if(xobject == XObject.xnull) 
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
		
		
		ArrayList<XObject> paramValues = new ArrayList<XObject>();
		
		for(; scanner.xhasNext();)
		{
			String name = scanner.xnext();
			if(name.startsWith(PARAMETER_NAME_PREFIX))
			{
				name = name.substring(0, PARAMETER_NAME_PREFIX.length());
				
				if(scanner.xhasNextBoolean())
				{
					paramValues.add(xfactory.xObject(scanner.xnextBoolean()));
				}
				else if(scanner.xhasNextByte())
				{
					paramValues.add(xfactory.xObject(scanner.xnextByte()));
				}
				else if(scanner.xhasNextDouble())
				{
					paramValues.add(xfactory.xObject(scanner.xnextDouble()));
				}
				else if(scanner.xhasNextFloat())
				{
					paramValues.add(xfactory.xObject(scanner.xnextFloat()));
				}
				else if(scanner.xhasNextInt())
				{
					paramValues.add(xfactory.xObject(scanner.xnextInt()));
				}
				else if(scanner.xhasNextLong())
				{
					paramValues.add(xfactory.xObject(scanner.xnextLong()));
				}
				else if(scanner.xhasNextShort())
				{
					paramValues.add(xfactory.xObject(scanner.xnextShort()));
				}
				else if(scanner.xhasNext())
				{
					String value = scanner.xnext();
					
					if(value.startsWith(OBJECT_REF_PREFIX))
					{
						value = value.substring(OBJECT_REF_PREFIX.length());
						XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
						if(bindings.xcontainsKey(value))
						{
							paramValues.add(bindings.xget(value));
						}
					}
					else
					{
						paramValues.add(xfactory.xObject(value));
					}
				}
			}
		}
		
		XClass[] xparameterTypes = new XClass[paramValues.size()];
		for(int i = 0; i < xparameterTypes.length; i++)
		{
			xparameterTypes[i] = paramValues.get(i).xgetClass();
		}
		
		XConstructor xconstructor = null;
		for(XClass xclass : xclasses)
		{
			xconstructor = xclass.xgetConstructor(xparameterTypes);
			if(xconstructor != null)
			{
				break;
			}
		}
		
		if(xconstructor != null)
		{
			XObject[] xparameters = new XObject[paramValues.size()];
			xparameters = paramValues.toArray(xparameters);
			XObject xreturn = xconstructor.xnewInstance(xparameters);
			xsetObjectParam(RETURN, scanner, context, xreturn);
			return xreturn;
		}
		
		return XObject.xnull;
	}

	public XScanner xgoto(String line, XScanner scanner, XScriptContext context) throws Exception
	{
		XScanner inLineScanner = null;
		boolean isBreak = false;
		
		for(;scanner.xhasNextLine() && isBreak == false;)
		{
			inLineScanner = scanner.xnextLine();
			inLineScanner = inLineScanner.xuseDelimiter(PARAMETER_SEPARATOR);
			
			if(inLineScanner.xhasNext())
			{
				String methodName = xgetMethodName(scanner);
				
				if(methodName.equals(line))
				{
					isBreak = true;
				}
			}
			
			inLineScanner.xclose();
			inLineScanner = null;
		}
		return inLineScanner;
	}
	
	public void xtry(XScanner scanner, XScanner inLineScanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval(scanner, context);
		}
		catch(Exception ex)
		{
			XScanner catchLine = xgoto(CATCH, scanner, context);

			if(catchLine != null)
			{
				xcatch(xfactory.xObject(ex), scanner, catchLine, context);
			}
		}
	}

	public XObject xcatch(XObject exception, XScanner scanner, XScanner inLineScanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		xsetObjectParam(RETURN, inLineScanner, context, exception);
		return exception;
	}

	public boolean xif(XScanner scanner, XScanner inLineScanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xelse(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public void xwhile(XScanner scanner, XScanner inLineScanner, XScanner[] lines, XScriptContext context) throws Exception {
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
	
	public XObject xdo(XScanner scanner, XScriptContext context) throws Exception
	{
		XScanner inLineScanner = null;
		XObject xobject = XObject.xnull;
		ArrayList<XScanner> cloneLines = new ArrayList<XScanner>();
		XScanner cloneLine = null;
		boolean isBreak = false;
		
		for(;scanner.xhasNextLine() && isBreak == false;)
		{
			inLineScanner = scanner.xnextLine();
			cloneLine = inLineScanner.xclone();
			
			inLineScanner = inLineScanner.xuseDelimiter(PARAMETER_SEPARATOR);
			cloneLine = cloneLine.xuseDelimiter(PARAMETER_SEPARATOR);
			

			cloneLines.add(cloneLine);
			
			String methodName = xgetMethodName(inLineScanner);
			
			if(methodName.equals(WHILE))
			{
				XScanner[] lines = new XScanner[cloneLines.size()];
				lines = cloneLines.toArray(lines);
				xwhile(scanner, inLineScanner, lines, context);
				isBreak = true;
			}
			else if(methodName.equals(BREAK))
			{
				isBreak = true;
			}
			else
			{
				xobject = xeval(methodName, scanner, inLineScanner, context);
			}
			

			if(methodName.equals(RETURN))
			{
				isBreak = true;
			}
			
			inLineScanner.xclose();
			inLineScanner = null;
		}
		
		for(XScanner line : cloneLines)
		{
			line.xclose();
		}
		cloneLines.clear();
		
		return xobject;
	}

}
