package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xlang.XException;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XMethod;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;

public class XScriptEngineImpl implements XScriptEngine {

	private static final String THIS = "this";
	private static final String NULL = "null";
	private static final String CLASS = "class";
	private static final String RETURN = "return";
	private static final String PARAMETER_NAME_PREFIX = "-";
	private static final String OBJECT_REF_PREFIX = "#";
	private static final String X_METHOD_NAME_PREFIX = "x";
	private static final String PARAMETER_SEPARATOR = "\t";
	
	private static final String IMPORT = "import";
	private static final String NEW = "new";
	private static final String TRY = "try";
	private static final String CATCH = "catch";
	private static final String IF = "if";
	private static final String ELSE = "else";
	private static final String SUPER = "super";
	private static final String DO = "do";
	private static final String WHILE = "while";
	private static final String BREAK = "break";
	//private static final String FOR = "for";
	//private static final String GOTO = "goto";
	
	private HashMap<String, XClass> importedClasses;
	
	private XFactory xfactory;
	private XClassLoader xclassLoader;
	private XScriptContext xdefaultContext;
	
	protected XScriptEngineImpl(XFactory factory, XClassLoader classLoader, XScriptContext defaultContext)
	{
		importedClasses = new HashMap<String, XClass>();
		xfactory = factory;
		xclassLoader = classLoader;
		xdefaultContext = defaultContext;
	}
	
	public XObject xeval(XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		XObject xobject = null;
		boolean isBreak = false;
		
		while(scanner.xhasNextLine() && isBreak == false)
		{
			XScanner temp = scanner.xnextLine();
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					xobject = xeval(methodName, currentLine, scanner, bindings);
					
					if(methodName.equals(RETURN))
					{
						isBreak = true;
					}
				}
			}

			currentLine.xclose();
			xfactory.xfinalize(currentLine);
			
			if(isBreak)
			{
				break;
			}
		}
		
		return xobject;
	}
	
	protected XObject xeval(String method, XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(method.equals(IMPORT))
		{
			ximport(currentLine);
		}
		else if(method.equals(NEW))
		{
			return xnew(currentLine, bindings);
		}
		else if(method.equals(RETURN))
		{
			return xreturn(currentLine, scanner, bindings);
		}
		else if(method.equals(TRY))
		{
			xtry(scanner, bindings);
		}
		else if(method.equals(IF))
		{
			xif(currentLine, scanner, bindings);
		}
		else if(method.equals(SUPER))
		{
			return xsuper(currentLine, bindings);
		}
		else if(method.equals(DO))
		{
			xdo(scanner, bindings);
		}
		else
		{
			return xinvoke(method, currentLine, bindings);
		}
		
		return null;
	}
	
	public static XScriptEngine xnew(XFactory xfactory, XClassLoader xclassLoader, XScriptContext xdefaultContext)
	{
		return new XScriptEngineImpl(xfactory, xclassLoader, xdefaultContext);
	}

	protected XObject xthis(XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(THIS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
								if(bindings.xcontainsKey(paramValue))
								{
									return bindings.xget(paramValue);
								}
							}
						}
					}
				}
			}
		}
		
		return null;
	}
	
	protected XClass xclass(XScanner currentLine) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(importedClasses.containsKey(paramValue))
							{
								return importedClasses.get(paramValue);
							}
						}
					}
				}
			}
		}
		
		return null;
	}
	
	protected XObject xreturn(XObject xreturn, XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(RETURN))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
								
								bindings.xput(paramValue, xreturn);
								
								return xreturn;
							}
						}
					}
				}
			}
		}
		
		return null;
	}
	
	protected XObject[] xparameter(XScanner currentLine, XBindings bindings) throws Exception
	{
		ArrayList<XObject> paramValues = new ArrayList<XObject>();
		
		while(currentLine.xhasNext())
		{
			String name = currentLine.xnext();
			
			if(name.startsWith(PARAMETER_NAME_PREFIX))
			{
				name = name.substring(PARAMETER_NAME_PREFIX.length());
				
				if(currentLine.xhasNextBoolean())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextBoolean()));
				}
				else if(currentLine.xhasNextByte())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextByte()));
				}
				else if(currentLine.xhasNextDouble())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextDouble()));
				}
				else if(currentLine.xhasNextFloat())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextFloat()));
				}
				else if(currentLine.xhasNextInt())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextInt()));
				}
				else if(currentLine.xhasNextLong())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextLong()));
				}
				else if(currentLine.xhasNextShort())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextShort()));
				}
				else if(currentLine.xhasNext())
				{
					String value = currentLine.xnext();
					
					if(value.startsWith(OBJECT_REF_PREFIX))
					{
						value = value.substring(OBJECT_REF_PREFIX.length());
						
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
		
		XObject[] xparameters = new XObject[paramValues.size()];
		xparameters = paramValues.toArray(xparameters);
		
		return xparameters;
	}
	
	protected boolean xtrue(XObject xobject) throws Exception
	{
		if(xobject != null)
		{
			if(xobject.xequals(XObject.xnull) == false)
			{
				if(xobject.xgetClass().xgetName().equals("java.lang.Boolean"))
				{
					Boolean b = (Boolean) xobject.x();
					
					return b;
				}
			}
		}
		
		return false;
	}
	
	protected String xmethod(XScanner currentLine) throws Exception
	{
		String methodName = currentLine.xnext();
		
		for(; methodName.isEmpty() && currentLine.xhasNext(); methodName = currentLine.xnext())
		{
		}
		
		return methodName;
	}
	
	protected void ximport(XScanner currentLine) throws Exception {

		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(importedClasses.containsKey(paramValue) == false)
							{
								XClass xclass = xclassLoader.xloadClass(paramValue);
								
								if(xclass != null)
								{
									importedClasses.put(xclass.xgetSimpleName(), xclass);
								}
							}
						}
					}
				}
			}
		}
	}
	
	protected XObject xinvoke(String method, XScanner currentLine, XBindings bindings) throws Exception 
	{
		XObject xthis = xthis(currentLine, bindings);
		
		return xinvoke(method, xthis, currentLine, bindings);
	}

	protected XObject xinvoke(String method, XObject xthis, XScanner currentLine, XBindings bindings) throws Exception
	{
		XClass xclass = null;
		
		if(xthis == null) 
		{
			xclass = xclass(currentLine);
		}
		else
		{
			xclass = xthis.xgetClass();
		}
		
		return xinvoke(method, xthis, xclass, currentLine, bindings);
	}
	
	protected XObject xinvoke(String method, XObject xthis, XClass xclass, XScanner currentLine, XBindings bindings) throws Exception
	{
		ArrayList<XClass> xclasses = new ArrayList<XClass>();
		if(xclass != null)
		{
			xclasses.add(xclass);
		}
		else
		{
			xclasses.addAll(importedClasses.values());
		}
		
		
		XObject[] xparameters = xparameter(currentLine, bindings);
		
		XClass[] xparameterTypes = new XClass[xparameters.length];
		for(int i = 0; i < xparameterTypes.length; i++)
		{
			xparameterTypes[i] = xparameters[i].xgetClass();
		}
		
		XMethod xmethod = null;
		for(XClass xcls : xclasses)
		{
			xmethod = xcls.xgetMethod(method, xparameterTypes);
			
			if(xmethod != null)
			{
				break;
			}
		}
		
		
		if(xmethod != null)
		{
			XObject xreturn = xmethod.xinvoke(xthis, xparameters);
			
			return xreturn(xreturn, currentLine, bindings);
		}
		
		return null;
	}

	protected XObject xnew(XScanner currentLine, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		
		XClass xclass = xclass(currentLine);

		if(xclass != null)
		{
			XObject[] xparameters = xparameter(currentLine, bindings);
			
			XClass[] xparameterTypes = new XClass[xparameters.length];
			for(int i = 0; i < xparameterTypes.length; i++)
			{
				xparameterTypes[i] = xparameters[i].xgetClass();
			}
			
			XConstructor xconstructor = xclass.xgetConstructor(xparameterTypes);
			
			if(xconstructor != null)
			{
				XObject xreturn = xconstructor.xnewInstance(xparameters);
				
				return xreturn(xreturn, currentLine, bindings);
			}
		}
		
		return null;
	}

	protected XScanner xgoto(String end, String line, XScanner scanner) throws Exception
	{
		XScanner foundLine = null;
		boolean isBreak = false;
		
		while(scanner.xhasNextLine())
		{
			XScanner temp = scanner.xnextLine();
			XScanner current = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(current.xhasNext())
			{
				String methodName = xmethod(current);

				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(end))
					{
						isBreak = true;
					}
					else if(methodName.equals(line))
					{
						foundLine = current;
						break;
					}
					else if(methodName.equals(IF))
					{
						foundLine = xgoto(ELSE, line, scanner);
					}
					else if(methodName.equals(TRY))
					{
						foundLine = xgoto(CATCH, line, scanner);
					}
					else if(methodName.equals(DO))
					{
						foundLine = xgoto(WHILE, line, scanner);
					}
				}
			}
			
			if(isBreak == false)
			{
				current.xclose();
				xfactory.xfinalize(current);
			}
			else
			{
				break;
			}
		}
		return foundLine;
	}
	
	protected void xtry(XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval(scanner, bindings);
		}
		catch(Exception ex)
		{
			XException xexception = xfactory.xException(ex);
			
			XObject xobject = xcatch(xexception, scanner, bindings);
			
			if(xobject == null)
			{
				xfactory.xfinalize(xexception);
				throw ex;
			}
			else
			{
				xeval(scanner, bindings);
			}
		}
	}
	
	protected XObject xcatch(XException exception, XScanner scanner, XBindings bindings) throws Exception
	{
		XScanner catchLine = null;
		XObject xobject = null;
		
		do
		{
			catchLine = xgoto("", CATCH, scanner);
			
			if(catchLine != null)
			{
				xobject = xcatch( exception, catchLine, scanner, bindings);
				catchLine.xclose();
				xfactory.xfinalize(catchLine);
				if(xobject != null)
					break;
			}
			else
			{
				break;
			}
		}
		while(true);
		
		return xobject;
	}

	protected XObject xcatch(XException exception, XScanner catchLine, XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		XClass xclass = xclass(catchLine);
		
		if(xclass != null)
		{
			if(xclass.xisAssignableFrom(exception.xgetClass()))
			{
				return xreturn(exception, catchLine, bindings);
			}
		}
		else
		{
			return xreturn(exception, catchLine, bindings);
		}
		
		return null;
	}
	
	protected boolean xif(XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				XObject xobject = null;
				
				if(methodName.startsWith(OBJECT_REF_PREFIX))
				{
					methodName = methodName.substring(OBJECT_REF_PREFIX.length());
					
					if(bindings.xcontainsKey(methodName))
					{
						xobject = bindings.xget(methodName);
					}
				}
				else
				{
					xobject = xinvoke(methodName, currentLine, bindings);
				}
				
				return xtrue(xobject);
			}
		}
		return false;
	}
	
	protected boolean xif(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		if(xif(currentLine, bindings))
		{
			xeval(scanner, bindings);
			return true;
		}
		else
		{
			XScanner elseLine = xgoto("", ELSE, scanner);
			
			if(elseLine != null)
			{
				elseLine.xclose();
				xfactory.xfinalize(elseLine);
				xeval(scanner, bindings);
			}
		}
		
		return false;
	}

	protected void xdo(XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		boolean isContinue = true;
		ArrayList<XScanner> tempLines = new ArrayList<XScanner>();
		Iterator<XScanner> iterator = null;
		
		do
		{
			XScanner temp = null;
			if(iterator == null)
			{
				temp = scanner.xnextLine();
				tempLines.add(temp);
			}
			else
			{
				temp = iterator.next();
			}
			
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);

				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(WHILE))
					{
						iterator = tempLines.iterator();
						isContinue = xif(currentLine, bindings);
					}
					else if(methodName.equals(BREAK))
					{
						isContinue = false;
					}
					else
					{
						xeval(methodName, currentLine, scanner, bindings);
						
						if(methodName.equals(RETURN))
						{
							isContinue = false;
						}
						
					}
				}
			}

			currentLine.xclose();
			xfactory.xfinalize(currentLine);
		}
		while((iterator != null || scanner.xhasNextLine()) && isContinue);
		
		for(XScanner s : tempLines)
		{
			xfactory.xfinalize(s);
		}
		
		tempLines.clear();
	}
	
	protected void xfor(XArray array, XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		
	}

	protected XObject xreturn(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(THIS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
								if(bindings.xcontainsKey(paramValue))
								{
									return bindings.xget(paramValue);
								}
							}
							else if(paramValue.equals(NULL))
							{
								return xfactory.xObject(null);
							}
						}
					}
				}
			}
		}
		
		return null;
	}
	
	protected XObject xsuper(XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				if(methodName.startsWith(X_METHOD_NAME_PREFIX) == false)
				{
					XObject xthis = xfactory.xObject(this);
					XClass xclass = xfactory.xClass(this.getClass());
					try
					{
						return xinvoke(methodName, xthis, xclass, currentLine, bindings);
					}
					finally
					{
						xfactory.xfinalize(xthis);
						xfactory.xfinalize(xclass);
					}
				}
			}
		}
		
		return null;
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		importedClasses.clear();
		importedClasses = null;
		xfactory = null;
		finalize();
	}

	public XObject xeval(XScanner xscanner) throws Exception {
		// TODO Auto-generated method stub
		return xeval(xscanner, xdefaultContext);
	}


	public XBindings xcreateBindings() throws Exception {
		// TODO Auto-generated method stub
		return XBindingsImpl.xnew();
	}

	public XObject xeval(XScanner xscanner, XScriptContext xcontext) throws Exception {
		// TODO Auto-generated method stub
		return xeval(xscanner, xcontext.xgetBindings(XScriptContext.XGLOBAL_SCOPE));
	}

	public XObject xeval(String script, XBindings xbindings) throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

	public XObject xeval(String script, XScriptContext xcontext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObject xeval(String script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
