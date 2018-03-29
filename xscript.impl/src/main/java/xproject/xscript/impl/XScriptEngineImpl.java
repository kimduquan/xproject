package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xlang.XException;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;
import xproject.xutil.xconcurrent.XConcurrentFactory;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XFuture;
import xproject.xutil.xconcurrent.XRunnable;

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
	private static final String THROW = "throw";
	private static final String IF = "if";
	private static final String ELSE = "else";
	private static final String SUPER = "super";
	private static final String DO = "do";
	private static final String WHILE = "while";
	private static final String BREAK = "break";
	private static final String FOR = "for";
	private static final String GOTO = "goto";
	private static final String CONTINUE = "continue";
	private static final String FINAL = "final";
	private static final String FINALLY = "finally";
	
	private static final String EXECUTOR = "executor";
	private static final String AWAIT_TERMINATION = "awaitTermination";
	private static final String SHUTDOWN = "shutdown";
	private static final String SUBMIT = "submit";
	private static final String IS_TERMINATED = "isTerminated";
	private static final String EXECUTE = "execute";
	private static final String SHUTDOWN_NOW = "shutdownNow";
	private static final String INVOKE_ALL = "invokeAll";
	private static final String INVOKE_ANY = "invokeAny";
	private static final String EVAL = "eval";
	
	private static final String AND = "and";
	private static final String OR = "or";
	private static final String NOT = "not";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	
	private HashMap<String, XClass> importedClasses;
	
	private XFactory xfactory;
	private XClassLoader xclassLoader;
	private XScriptContext xdefaultContext;
	private XExecutorService xexecutorService;
	private XConcurrentFactory xconcurrentFactory;
	private XClass xclass;
	private XObject xthis;
	
	protected XScriptEngineImpl(XFactory factory, XClassLoader classLoader, XScriptContext defaultContext)
	{
		importedClasses = new HashMap<String, XClass>();
		xfactory = factory;
		xclassLoader = classLoader;
		xdefaultContext = defaultContext;
		xclass = null;
		xthis = null;
	}
	
	public XObject xeval(XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		XObject xobject= null;
		for(XScanner temp = null; scanner.xhasNext(); temp = scanner.xnextLine())
		{
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(FINAL))
					{
						xfinal(currentLine);
						break;
					}
					else if(methodName.equals(RETURN))
					{
						return xreturn(currentLine, scanner, bindings);
					}
					
					xobject = xeval(methodName, currentLine, scanner, bindings);
				}
			}
			xclose(currentLine);
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
			return xsuper(currentLine, scanner, bindings);
		}
		else if(method.equals(DO))
		{
			xdo(scanner, bindings);
		}
		else if(method.equals(FOR))
		{
			xfor(currentLine, scanner, bindings);
		}
		else if(method.equals(GOTO))
		{
			xgoto(currentLine, scanner, bindings);
		}
		else if(method.equals(WHILE))
		{
			xwhile(currentLine, scanner, bindings);
		}
		
		return xinvoke(method, currentLine, bindings);
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
		String name = xreturn(currentLine);
		
		if(name.isEmpty() == false)
		{
			return bindings.xput(name, xreturn);
		}
		
		return null;
	}
	
	protected String xreturn(XScanner currentLine) throws Exception
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
								
								return paramValue;
							}
						}
					}
				}
			}
		}
		
		return "";
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
		
		XClass xclass = null;
		
		if(xthis == null) 
		{
			xclass = xclass(currentLine);
		}
		else
		{
			xclass = xthis.xgetClass();
		}
		
		XObject[] xparameters = xparameter(currentLine, bindings);
		
		XMethod xmethod = xmethod(method, xparameters, xthis, xclass, currentLine, bindings);
		
		if(xmethod != null)
		{
			XObject xreturn = xmethod.xinvoke(xthis, xparameters);
			
			return xreturn(xreturn, currentLine, bindings);
		}
		
		return null;
	}
	
	protected XClass[] xparameterTypes(XObject[] xparameters) throws Exception
	{
		XClass[] xparameterTypes = new XClass[xparameters.length];
		for(int i = 0; i < xparameterTypes.length; i++)
		{
			xparameterTypes[i] = xparameters[i].xgetClass();
		}
		return xparameterTypes;
	}
	
	protected XMethod xmethod(String method, XObject[] xparameters, XObject xthis, XClass xclass, XScanner currentLine, XBindings bindings) throws Exception
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
		
		XClass[] xparameterTypes = xparameterTypes(xparameters);
		
		XMethod xmethod = null;
		for(XClass xcls : xclasses)
		{
			xmethod = xcls.xgetMethod(method, xparameterTypes);
			
			if(xmethod != null)
			{
				break;
			}
		}
		
		return xmethod;
	}
	
	protected XObject xinvoke(String method, XObject xthis, XClass xclass, XScanner currentLine, XBindings bindings) throws Exception
	{
		XObject[] xparameters = xparameter(currentLine, bindings);
		
		XMethod xmethod = xmethod(method, xparameters, xthis, xclass, currentLine, bindings);
		
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
			
			XConstructor xconstructor = xconstructor(xclass, xparameters);
			
			if(xconstructor != null)
			{
				XObject xreturn = xconstructor.xnewInstance(xparameters);
				
				return xreturn(xreturn, currentLine, bindings);
			}
		}
		
		return null;
	}

	protected XScanner xgoto(String line, XScanner scanner) throws Exception
	{
		for(XScanner temp = null; scanner.xhasNext(); temp = scanner.xnextLine())
		{
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(line))
					{
						return currentLine;
					}
					
					switch(methodName)
					{
					case FINAL:
						xclose(currentLine);
						return null;
					
					case CATCH:
					case DO:
					case ELSE:
					case EVAL:
					case FINALLY:
					case FOR:
					case IF:
					case SUPER:
					case TRY:
					case WHILE:
							
					case INVOKE_ALL:
					case INVOKE_ANY:
						XScanner xline = xgoto(FINAL, scanner);
						if(xline != null)
							xclose(xline);
						break;
					}
				}
			}
			xclose(currentLine);
		}
		return null;
	}
	
	protected void xtry(XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval(scanner, bindings);
		}
		catch(Exception ex)
		{
			xcatch(ex, scanner, bindings);
		}
		finally
		{
			xfinally(scanner, bindings);
		}
	}

	protected XObject xcatch(Exception exception, XScanner catchLine, XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		XClass xclass = xclass(catchLine);
		
		if(xclass != null)
		{
			XException xexception = xfactory.xException(exception);
			if(xclass.xisAssignableFrom(xexception.xgetClass()))
			{
				return xreturn(xexception, catchLine, bindings);
			}
			xfactory.xfinalize(xexception);
		}
		else
		{
			return xreturn(xfactory.xException(exception), catchLine, bindings);
		}
		
		return null;
	}
	
	protected void xcatch(Exception exception, XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		XObject xexception = null;
		XScanner xcatch = null;
		do
		{
			xcatch = xgoto(CATCH, scanner);
			
			if(xexception == null)
			{
				xexception = xcatch(exception, xcatch, scanner, bindings);
			}
		}
		while(xcatch != null);
		
		if(xexception == null)
			throw exception;
	}
	
	protected boolean xif(XScanner currentLine, XBindings bindings) throws Exception
	{
		boolean value = true;
		
		while(currentLine.xhasNext())
		{
			String name = currentLine.xnext();
			
			if(name.isEmpty() == false)
			{
				if(name.startsWith(PARAMETER_NAME_PREFIX))
				{
					name = name.substring(PARAMETER_NAME_PREFIX.length());
					
					if(currentLine.xhasNextBoolean())
					{
						value = currentLine.xhasNextBoolean();
						
						if(name.equals(TRUE))
						{
							value = value == true;
						}
						else if(name.equals(FALSE))
						{
							value = value == false;
						}
					}
				}
			}
		}
		
		return value;
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
			xelse(scanner, bindings);
		}
		
		return false;
	}

	protected void xdo(XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		XScanner xwhile = null;
		ArrayList<XScanner> lines = new ArrayList<XScanner>();
		
		do
		{
			
		}
		while(xif(xwhile, bindings) &&  scanner.xhasNext());
	}
	
	protected void xfor(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception {
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
	
	protected XObject xsuper(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				if(methodName.equals(EXECUTOR))
				{
					return xexecutor(currentLine, scanner, bindings);
				}
				else if(methodName.equals(EVAL))
				{
					return xeval(scanner, bindings);
				}
				else if(methodName.startsWith(X_METHOD_NAME_PREFIX) == false)
				{
					XField xfield = xclass().xgetField(methodName);
					if(xfield != null)
					{
						return xextension(methodName, xfield, currentLine, scanner, bindings);
					}
					
					return xinvoke(methodName, xthis(), xclass(), currentLine, bindings);
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
		xclassLoader = null;
		if(xclass != null)
		{
			xclass.xfinalize();
			xclass = null;
		}
		if(xthis != null)
		{
			xthis.xfinalize();
			xthis = null;
		}
		xconcurrentFactory = null;
		xdefaultContext = null;
		xexecutorService = null;
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
	
	protected XObject xexecutor(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				return xexecutor(methodName, currentLine, scanner, bindings);
			}
		}
		
		return null;
	}
	
	protected XObject xexecutor(String methodName, XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(methodName.equals(AWAIT_TERMINATION))
		{
			return xawaitTermination(currentLine, bindings);
		}
		else if(methodName.equals(SHUTDOWN))
		{
			xexecutorService.xshutdown();
		}
		else if(methodName.equals(SUBMIT))
		{
			return xsubmit(currentLine, scanner, bindings);
		}
		else if(methodName.equals(IS_TERMINATED))
		{
			return xisTerminated(currentLine, bindings);
		}
		else if(methodName.equals(EXECUTE))
		{
			return xexecute(currentLine, bindings);
		}
		else if(methodName.equals(SHUTDOWN_NOW))
		{
			return xshutdownNow(currentLine, scanner, bindings);
		}
		else if(methodName.equals(INVOKE_ALL))
		{
			xinvokeAll(scanner, bindings);
		}
		else if(methodName.equals(INVOKE_ANY))
		{
			return xinvokeAny(currentLine, scanner, bindings);
		}
		return null;
	}
	
	protected XObject xawaitTermination(XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNextLong())
		{
			long timeOut = currentLine.xnextLong();
			
			if(currentLine.xhasNext())
			{
				String timeUnit = currentLine.xnext();
				boolean b = xexecutorService.xawaitTermination(timeOut, TimeUnit.valueOf(timeUnit));
				XObject xobject = xfactory.xObject(b);
				return xreturn(xobject, currentLine, bindings);
			}
		}
		return null;
	}
	
	protected XObject xsubmit(String method, XScanner currentLine, XBindings bindings) throws Exception 
	{
		XObject xthis = xthis(currentLine, bindings);
		
		XClass xclass = null;
		
		if(xthis == null) 
		{
			xclass = xclass(currentLine);
		}
		else
		{
			xclass = xthis.xgetClass();
		}
		
		XObject[] xparameters = xparameter(currentLine, bindings);
		
		String xreturn = xreturn(currentLine);
		
		XMethod xmethod = xmethod(method, xparameters, xthis, xclass, currentLine, bindings);
		
		if(xmethod != null)
		{
			XInvokeCallable task = XInvokeMethodCallable.xnew(xmethod, xthis, xparameters, xreturn);
			
			XFuture xfuture = xexecutorService.xsubmit(task);
			
			if(xreturn.isEmpty() == false)
			{
				XObject xobject = xconcurrentFactory.xobject(xfuture);
				
				return bindings.xput(xreturn, xobject);
			}
		}
		
		return null;
	}
	
	protected XObject xsubmit(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				return xsubmit(methodName, currentLine, bindings);
			}
		}
		return null;
	}
	
	protected XObject xisTerminated(XScanner currentLine, XBindings bindings) throws Exception
	{
		boolean b = xexecutorService.xisTerminated();
		XObject xobject = xfactory.xObject(b);
		return xreturn(xobject, currentLine, bindings);
	}
	
	protected XObject xexecute(XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				return xexecute(methodName, currentLine, bindings);
			}
		}
		return null;
	}
	
	protected XObject xexecute(String method, XScanner currentLine, XBindings bindings) throws Exception
	{
		XObject xthis = xthis(currentLine, bindings);
		
		XClass xclass = null;
		
		if(xthis == null) 
		{
			xclass = xclass(currentLine);
		}
		else
		{
			xclass = xthis.xgetClass();
		}
		
		XObject[] xparameters = xparameter(currentLine, bindings);
		
		XMethod xmethod = xmethod(method, xparameters, xthis, xclass, currentLine, bindings);
		
		if(xmethod != null)
		{
			XRunnable task = XInvokeMethodRunnable.xnew(xmethod, xthis, xparameters);
			
			xexecutorService.xexecute(task);
		}
		
		return null;
	}
	
	protected XObject xshutdownNow(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		xexecutorService.xshutdownNow();
		return null;
	}

	protected XInvokeCallable xcallable(String method, XScanner currentLine, XBindings bindings) throws Exception
	{	
		XObject xthis = xthis(currentLine, bindings);
		
		XClass xclass = null;
		
		if(xthis == null) 
		{
			xclass = xclass(currentLine);
		}
		else
		{
			xclass = xthis.xgetClass();
		}
		
		XObject[] xparameters = xparameter(currentLine, bindings);
		
		String xreturn = xreturn(currentLine);
		
		XMethod xmethod = xmethod(method, xparameters, xthis, xclass, currentLine, bindings);
		
		if(xmethod != null)
		{
			return XInvokeMethodCallable.xnew(xmethod, xthis, xparameters, xreturn);
		}
		
		return null;
	}
	
	protected void xinvokeAll(XScanner scanner, XBindings bindings) throws Exception
	{
		ArrayList<XInvokeCallable> tasks = new ArrayList<XInvokeCallable>();
		for(XScanner temp = null; scanner.xhasNext(); temp = scanner.xnextLine())
		{
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(FINAL))
					{
						xclose(currentLine);
						break;
					}
					
					XInvokeCallable task = xcallable(methodName, currentLine, bindings);
					
					if(task != null)
						tasks.add(task);
					
				}
			}
			xclose(currentLine);
		}
		
		xinvokeAll(tasks, bindings);
	}
	
	protected void xinvokeAll(List<XInvokeCallable> tasks, XBindings bindings) throws Exception
	{
		if(tasks.isEmpty() == false)
		{
			XInvokeCallable[] calls = new XInvokeCallable[tasks.size()];
			calls = tasks.toArray(calls);
			String[] returns = new String[calls.length];
			for(int i = 0; i < returns.length; i++)
			{
				returns[i] = calls[i].xreturn();
			}
			
			XFuture[] xfutures = xexecutorService.xinvokeAll(calls);
			
			for(int i = 0; i < xfutures.length; i++)
			{
				if(returns[i].isEmpty() == false)
				{
					XObject xobject = xconcurrentFactory.xobject(xfutures[i]);
					
					bindings.xput(returns[i], xobject);
				}
			}
		}
	}
	
	protected XObject xinvokeAny(List<XInvokeCallable> tasks, String xreturn, XBindings bindings) throws Exception
	{
		if(tasks.isEmpty() == false)
		{
			XInvokeCallable[] calls = new XInvokeCallable[tasks.size()];
			calls = tasks.toArray(calls);
			XObject xobject = xexecutorService.xinvokeAny(calls);
			
			if(xreturn.isEmpty() == false)
				xobject = bindings.xput(xreturn, xobject);
			
			return xobject;
		}
		
		return null;
	}
	
	protected XObject xinvokeAny(XScanner current, XScanner scanner, XBindings bindings) throws Exception
	{
		String xreturn = xreturn(current);
		ArrayList<XInvokeCallable> tasks = new ArrayList<XInvokeCallable>();
		
		return xinvokeAny(tasks, xreturn, bindings);
	}
	
	protected XObject xextension(String fieldName, XField xfield, XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String method = currentLine.xnext();
			if(method.isEmpty() == false)
			{
				XClass xtype = xfield.xgetType();
				XObject[] xparameters = xparameter(currentLine, bindings);
				XMethod xmethod = xmethod(method, xtype, xparameters);
				
				if(xmethod != null)
				{
					if(xmethod.xgetModifiers().xisStatic())
					{
						return xmethod.xinvoke(XObject.xnull, xparameters);
					}
					else
					{
						XObject xobject = null;
						if(xfield.xgetModifiers().xisStatic())
						{
							xobject = xfield.xget(XObject.xnull);
						}
						else
						{
							xobject = xfield.xget(xthis());
						}
						
						return xmethod.xinvoke(xobject, xparameters);
					}
				}
			}
		}
		return null;
	}
	
	public static Logger logger = Logger.getLogger(XScriptEngineImpl.class.getName());

	protected XClass xclass() throws Exception
	{
		if(xclass == null)
			xclass = xfactory.xClass(this.getClass());
		return xclass;
	}
	
	protected XObject xthis() throws Exception
	{
		if(xthis == null)
			xthis = xfactory.xObject(this);
		return xthis;
	}
	
	protected XMethod xmethod(String method, XClass xtype, XObject[] xparameters) throws Exception
	{
		XClass[] xparameterTypes = xparameterTypes(xparameters);
		return xtype.xgetMethod(method, xparameterTypes);
	}
	
	protected XConstructor xconstructor(XClass xtype, XObject[] xparameters) throws Exception
	{
		XClass[] xparameterTypes = xparameterTypes(xparameters);
		return xtype.xgetConstructor(xparameterTypes);
	}
	
	protected XScanner xgoto(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String line = currentLine.xnext();
			if(line.isEmpty() == false)
			{
				XScanner xgoto = xgoto(line, scanner);
				if(xgoto != null)
				{
					xeval(line, xgoto, scanner, bindings);
					xclose(xgoto);
				}
			}
		}
		
		return null;
	}
	
	protected String xobject(String parameter, XScanner currentLine) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(parameter))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
								return paramValue;
							}
						}
					}
				}
			}
		}
		
		return "";
	}
	
	protected void xclose(XScanner line) throws Exception
	{
		line.xclose();
		xfactory.xfinalize(line);
	}
	
	protected XScanner xeval(String endLine, XScanner scanner, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		for(XScanner temp = null; scanner.xhasNext(); temp = scanner.xnextLine())
		{
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(FINAL))
					{
						xfinal(currentLine);
						break;
					}
					else if(methodName.equals(endLine))
					{
						return currentLine;
					}
					else if(methodName.equals(RETURN))
					{
						xreturn(currentLine, scanner, bindings);
						return null;
					}
					
					xeval(methodName, currentLine, scanner, bindings);
				}
			}
			xclose(currentLine);
		}
		return null;
	}
	
	protected void xfinal(XScanner currentLine) throws Exception
	{
		xclose(currentLine);
	}
	
	protected void xfinally(XScanner scanner, XBindings bindings) throws Exception
	{
		XScanner xfinally = xgoto(FINALLY, scanner);
		if(xfinally != null)
		{
			xclose(xfinally);
			xeval(scanner, bindings);
		}
	}
	
	protected void xelse(XScanner scanner, XBindings bindings) throws Exception
	{
		XScanner xelse = xgoto(ELSE, scanner);
		if(xelse != null)
		{
			xclose(xelse);
			xeval(scanner, bindings);
		}
	}
	
	protected void xwhile(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		
	}
	
	protected XScanner xcallable(String line, XScanner scanner) throws Exception
	{
		for(XScanner temp = null; scanner.xhasNext(); temp = scanner.xnextLine())
		{
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(line))
					{
						return currentLine;
					}
					
					switch(methodName)
					{
					case FINAL:
						xclose(currentLine);
						return null;
					
					case CATCH:
					case DO:
					case ELSE:
					case EVAL:
					case FINALLY:
					case FOR:
					case IF:
					case SUPER:
					case TRY:
					case WHILE:
							
					case INVOKE_ALL:
					case INVOKE_ANY:
						XScanner xline = xgoto(FINAL, scanner);
						if(xline != null)
							xclose(xline);
						break;
					}
				}
			}
			xclose(currentLine);
		}
		return null;
	}
}
