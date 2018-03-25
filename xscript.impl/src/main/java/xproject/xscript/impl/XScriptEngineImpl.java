package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	private static final String IF = "if";
	private static final String ELSE = "else";
	private static final String SUPER = "super";
	private static final String DO = "do";
	private static final String WHILE = "while";
	private static final String BREAK = "break";
	//private static final String FOR = "for";
	//private static final String GOTO = "goto";
	
	private static final String EXECUTOR = "executor";
	private static final String AWAIT_TERMINATION = "awaitTermination";
	private static final String SHUTDOWN = "shutdown";
	private static final String SUBMIT = "submit";
	private static final String IS_TERMINATED = "isTerminated";
	private static final String EXECUTE = "execute";
	private static final String SHUTDOWN_NOW = "shutdownNow";
	private static final String INVOKE_ALL = "invokeAll";
	private static final String INVOKE_ANY = "invokeAny";
	
	private HashMap<String, XClass> importedClasses;
	
	private XFactory xfactory;
	private XClassLoader xclassLoader;
	private XScriptContext xdefaultContext;
	private XExecutorService xexecutorService;
	private XConcurrentFactory xconcurrentFactory;
	
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
			return xsuper(currentLine, scanner, bindings);
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
	
	protected XObject xsuper(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				return xsuper(methodName, currentLine, scanner, bindings);
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
	
	protected XObject xsuper(String methodName, XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		if(methodName.equals(EXECUTOR))
		{
			return xexecutor(currentLine, scanner, bindings);
		}
		else if(methodName.startsWith(X_METHOD_NAME_PREFIX) == false)
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
	
	protected boolean xisCallable(String method)
	{
		switch(method)
		{
			case IMPORT:
			case NEW:
			case RETURN:
			case TRY:
			case IF:
			case SUPER:
			case DO:
				return false;
			default:
				break;
		}
		return true;
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
		boolean isBreak = false;
		XScanner endLine = null;
		String endLineMethod = "";
		
		while(scanner.xhasNextLine())
		{
			XScanner temp = scanner.xnextLine();
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(xisCallable(methodName))
					{
						XInvokeCallable task = xcallable(methodName, currentLine, bindings);
						
						if(task != null)
							tasks.add(task);
						else
						{
							isBreak = true;
						}
					}
					else
					{
						endLine = currentLine;
						endLineMethod = methodName;
						break;
					}
				}
			}

			currentLine.xclose();
			xfactory.xfinalize(currentLine);
			
			if(isBreak)
				break;
		}
		
		xinvokeAll(tasks, bindings);
		
		if(endLine != null)
		{
			xeval(endLineMethod, endLine, scanner, bindings);
			
			endLine.xclose();
			xfactory.xfinalize(endLine);
		}
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
	
	protected XObject xinvokeAny(XScanner current, XScanner scanner, XBindings bindings) throws Exception
	{
		String xreturn = xreturn(current);
		ArrayList<XInvokeCallable> tasks = new ArrayList<XInvokeCallable>();
		boolean isBreak = false;
		XScanner endLine = null;
		String endLineMethod = "";
		
		while(scanner.xhasNextLine())
		{
			XScanner temp = scanner.xnextLine();
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(xisCallable(methodName))
					{
						XInvokeCallable task = xcallable(methodName, currentLine, bindings);
						
						if(task != null)
							tasks.add(task);
						else
						{
							isBreak = true;
						}
					}
					else
					{
						endLine = currentLine;
						endLineMethod = methodName;
						break;
					}
				}
			}

			currentLine.xclose();
			xfactory.xfinalize(currentLine);
			
			if(isBreak)
				break;
		}
		
		
		
		XObject xobject = null;
		
		if(tasks.isEmpty() == false)
		{
			XInvokeCallable[] calls = new XInvokeCallable[tasks.size()];
			calls = tasks.toArray(calls);
			xobject = xexecutorService.xinvokeAny(calls);
			
			if(xreturn.isEmpty() == false)
				xobject = bindings.xput(xreturn, xobject);
		}
		
		if(endLine != null)
		{
			xeval(endLineMethod, endLine, scanner, bindings);
			
			endLine.xclose();
			xfactory.xfinalize(endLine);
		}
		
		return xobject;
	}
}
