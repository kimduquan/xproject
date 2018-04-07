package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import xproject.xio.XWriter;
import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xlang.XException;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XParameter;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;
import xproject.xutil.xconcurrent.XCallable;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XFuture;
import xproject.xutil.xconcurrent.xscript.XEval;
import xproject.xutil.xconcurrent.xscript.impl.XEvalImpl;
import xproject.xutil.xconcurrent.xscript.impl.XFutureObjectImpl;
import xproject.xutil.xlogging.XLogger;
import xproject.xutil.xscript.impl.XScannerImpl;

public class XScriptEngineImpl implements XScriptEngine {

	private static final String THIS = "this";
	private static final String NULL = "null";
	private static final String CLASS = "class";
	private static final String RETURN = "return";
	private static final String PARAMETER_NAME_PREFIX = "-";
	private static final String OBJECT_REF_PREFIX = "#";
	private static final String X_METHOD_NAME_PREFIX = "x";
	private static final String PARAMETER_SEPARATOR = "\t";
	private static final String CLASS_REF_PREFIX = "@";
	
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
	private static final String SYNCHRONIZED = "synchronized";
	private static final String COMMENT_LINE = "//";
	private static final String COMMENT_BLOCK = "/*";
	private static final String COMMENT_BLOCK_END = "*/";
	
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
	private static final String HELP = "help";
	
	private static final String AND = "and";
	private static final String OR = "or";
	private static final String NOT = "not";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	
	private static final String DEBUG = "debug";
	//private static final String DEBUG_RUN = "run";
	//private static final String DEBUG_CONT = "cont";
	//private static final String DEBUG_PRINT = "print";
	//private static final String DEBUG_DUMP = "dump";
	//private static final String DEBUG_STOP = "stop";
	//private static final String DEBUG_CLEAR = "clear";
	//private static final String DEBUG_STEPP = "step";
	//private static final String DEBUG_NEXT = "next";
	//private static final String DEBUG_CATCH = "catch";
	//private static final String DEBUG_IGNORE = "ignore";
	
	private static final String HELP_METHOD = "method";
	
	private static final String LOG = "log";
	private static final String LOG_CONFIG = "config";
	private static final String LOG_FINE = "fine";
	private static final String LOG_FINER = "finer";
	private static final String LOG_FINEST = "finest";
	private static final String LOG_INFO = "info";
	private static final String LOG_SEVERE = "severe";
	private static final String LOG_WARNING = "warning";
	
	private ConcurrentHashMap<String, XClass> xclasses;
	
	private XFactory xfactory;
	private XClassLoader xclassLoader;
	private XScriptContext xdefaultContext;
	private XExecutorService xexecutorService;
	private volatile XClass xclass;
	private volatile XObject xthis;
	private volatile XWriter xwriter;
	private XLogger xlogger;
	
	protected XScriptEngineImpl(XFactory factory, XClassLoader classLoader, XScriptContext defaultContext, XExecutorService executorService, XLogger logger)
	{
		xclasses = new ConcurrentHashMap<String, XClass>();
		xfactory = factory;
		xclassLoader = classLoader;
		xdefaultContext = defaultContext;
		xexecutorService = executorService;
		xclass = null;
		xthis = null;
		xwriter = null;
		xlogger = logger;
	}
	
	protected XObject xeval(XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception {
		// TODO Auto-generated method stub
		XScanner xreturn = xeval(RETURN, scanner, bindings, lines, lineNumber);
		if(xreturn != null)
			return xreturn(xreturn, bindings);
		return null;
	}
	
	protected XObject xeval(String method, XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
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
			xtry(scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(IF))
		{
			xif(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(SUPER))
		{
			return xsuper(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(DO))
		{
			xdo(scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(FOR))
		{
			xfor(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(GOTO))
		{
			xgoto(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(WHILE))
		{
			xwhile(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(THROW))
		{
			xthrow(currentLine, bindings);
		}
		else if(method.equals(SYNCHRONIZED))
		{
			xsynchronized(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(COMMENT_LINE))
		{
			
		}
		else if(method.equals(COMMENT_BLOCK))
		{
			xcomment(scanner, bindings, lineNumber);
		}
		else if(method.equals(DEBUG))
		{
			xdebug(scanner, bindings, lines, lineNumber);
		}
		else if(method.equals(HELP))
		{
			xhelp(currentLine, bindings);
		}
		else if(method.equals(LOG))
		{
			xlog(currentLine, bindings);
		}
		
		return xinvoke(method, currentLine, bindings);
	}
	
	public static XScriptEngine xnew(XFactory xfactory, XClassLoader xclassLoader, XScriptContext xdefaultContext, XExecutorService executorService, XLogger logger)
	{
		return new XScriptEngineImpl(xfactory, xclassLoader, xdefaultContext, executorService, logger);
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
							if(xclasses.containsKey(paramValue))
							{
								return xclasses.get(paramValue);
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
	
	protected boolean xtrue(XScanner currentLine, XBindings bindings) throws Exception
	{
		return xboolean(currentLine, bindings, false);
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
							if(xclasses.containsKey(paramValue) == false)
							{
								XClass xclass = xclassLoader.xloadClass(paramValue);
								
								if(xclass != null)
								{
									xclasses.put(xclass.xgetSimpleName(), xclass);
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
			xclasses.addAll(this.xclasses.values());
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
			xlogger.xentering(xclass.xgetSimpleName(), xmethod.xgetName(), xparameters);
			
			XObject xreturn = xmethod.xinvoke(xthis, xparameters);
			
			xlogger.xexiting(xclass.xgetSimpleName(), xmethod.xgetName(), xreturn);
			
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

	protected XScanner xgoto(String line, XScanner scanner, List<XScanner> lines, long lineNumber) throws Exception
	{
		for(XScanner currentLine = null; scanner.xhasNextLine(); currentLine = xnextLine(scanner, lines))
		{
			lineNumber++;
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(line.isEmpty() == false && methodName.equals(line))
					{
						return currentLine;
					}
					else if(methodName.equals(FINAL))
					{
						xclose(currentLine);
						return null;
					}
					
					if(xisBlock(methodName))
					{
						xgoto("", scanner, lines, lineNumber);
					}
				}
			}
			
			xclose(currentLine);
		}
		return null;
	}
	
	protected void xtry(XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval(scanner, bindings);
		}
		catch(Exception ex)
		{
			xcatch(ex, scanner, bindings, lines, lineNumber);
		}
		finally
		{
			xfinally(scanner, bindings, lines, lineNumber);
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
	
	protected void xcatch(Exception exception, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception {
		// TODO Auto-generated method stub
		XObject xexception = null;
		XScanner xcatch = null;
		do
		{
			xcatch = xgoto(CATCH, scanner, lines, lineNumber);
			
			if(xexception == null)
			{
				xexception = xcatch(exception, xcatch, scanner, bindings);
			}
		}
		while(xcatch != null);
		
		if(xexception == null)
		{
			throw exception;
		}
	}
	
	protected boolean xif(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception {
		// TODO Auto-generated method stub
		if(xif(currentLine, bindings))
		{
			XScanner xelse = xeval(ELSE, scanner, bindings, lines, lineNumber);
			if(xelse != null)
			{
				do
				{
					xclose(xelse);
					xelse = xgoto(ELSE, scanner, lines, lineNumber);
				}
				while(xelse != null);
			}
			return true;
		}
		else
		{
			XScanner xelse = xgoto(ELSE, scanner, lines, lineNumber);
			if(xelse != null)
			{
				xelse = xeval(ELSE, scanner, bindings, lines, lineNumber);
				do
				{
					xclose(xelse);
					xelse = xgoto(ELSE, scanner, lines, lineNumber);
				}
				while(xelse != null);
			}
		}
		
		return false;
	}

	protected boolean xif(XScanner currentLine, XBindings bindings) throws Exception
	{
		return xboolean(currentLine, bindings, false);
	}
	
	protected void xdo(XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception {
		// TODO Auto-generated method stub
		Iterator<XScanner> iterator = null;
		List<XScanner> recent =  new ArrayList<XScanner>();
		boolean bool = true;
		long tempLineNumber = lineNumber;
		do
		{
			XScanner currentLine = null;
			
			if(iterator != null)
			{
				currentLine = xnextLine(iterator);
				tempLineNumber++;
			}
			
			if(currentLine == null)
			{
				if(scanner.xhasNextLine())
				{
					currentLine = xnextLine(scanner, recent);
					tempLineNumber++;
				}
			}
			
			if(currentLine == null)
			{
				break;
			}
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(BREAK))
					{
						xclose(currentLine);
						break;
					}
					else if(methodName.equals(CONTINUE))
					{
						iterator = lines.iterator();
						tempLineNumber = lineNumber;
						xclose(currentLine);
						continue;
					}
					else if(methodName.equals(WHILE))
					{
						bool = xif(currentLine, bindings);
						if(bool)
						{
							iterator = lines.iterator();
							tempLineNumber = lineNumber;
						}
					}
					else if(methodName.equals(RETURN))
					{
						if(lines != null)
						{
							lines.addAll(recent);
						}
						else
						{
							xclose(recent);
						}
						xclose(currentLine);
						xreturn(currentLine, bindings);
						return;
					}
					else
						xeval(methodName, currentLine, scanner, bindings, recent, tempLineNumber);
				}
			}
			xclose(currentLine);
		}
		while(bool);
		
		if(lines != null)
		{
			lines.addAll(recent);
		}
		else
		{
			xclose(recent);
		}
	}
	
	protected void xfor(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception {
		// TODO Auto-generated method stub
		XObject xthis = xthis(currentLine, bindings);
		
		if(xthis != null)
		{
			String xreturn = xreturn(currentLine);
			
			if(xthis.xgetClass().xisArray())
			{
				XArray xarray = (XArray) xthis;
				
				xfor(xarray, xreturn, scanner, bindings, lines, lineNumber);
			}
		}
	}
	
	protected void xfor(XArray xarray, String xreturn, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		Iterator<XScanner> iterator = null;
		List<XScanner> recent =  new ArrayList<XScanner>();
		int length = xarray.xgetLength();
		int index = 0;
		long tempLineNumber = lineNumber;
		while(index < length)
		{
			XScanner currentLine = null;
			
			if(iterator != null)
			{
				if(iterator.hasNext())
				{
					currentLine = xnextLine(iterator);
					tempLineNumber++;
				}
			}
			
			if(currentLine == null)
			{
				if(scanner.xhasNextLine())
				{
					currentLine = xnextLine(scanner, recent);
					tempLineNumber++;
				}
			}
			
			if(currentLine == null)
			{
				break;
			}
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(BREAK))
					{
						xclose(currentLine);
						break;
					}
					else if(methodName.equals(CONTINUE))
					{
						iterator = lines.iterator();
						tempLineNumber = lineNumber;
						xclose(currentLine);
						continue;
					}
					else if(methodName.equals(FINAL))
					{
						if(!xreturn.isEmpty())
						{
							bindings.xput(xreturn, xarray.xget(index));
						}
						iterator = lines.iterator();
						tempLineNumber = lineNumber;
					}
					else if(methodName.equals(RETURN))
					{
						if(lines != null)
						{
							lines.addAll(recent);
						}
						else
						{
							xclose(recent);
						}
						xclose(currentLine);
						xreturn(currentLine, bindings);
						return;
					}
					else
						xeval(methodName, currentLine, scanner, bindings, recent, tempLineNumber);
				}
			}
			xclose(currentLine);
		}
		
		if(lines != null)
		{
			lines.addAll(recent);
		}
		else
		{
			xclose(recent);
		}
	}

	protected XObject xreturn(XScanner currentLine, XBindings bindings) throws Exception {
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
	
	protected XObject xsuper(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				if(methodName.equals(EXECUTOR))
				{
					return xexecutor(currentLine, scanner, bindings, lines, lineNumber);
				}
				else if(methodName.equals(EVAL))
				{
					return xeval(scanner, bindings, lines, lineNumber);
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
		xclasses.clear();
		xclasses = null;
		xfactory = null;
		xclassLoader = null;
		if(xclass != null)
		{
			xclass.xfinalize();
			xclass = null;
		}
		if(xthis != null)
		{
			xthis = null;
		}
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
		xwriter = xcontext.xgetWriter();
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
	
	protected XObject xexecutor(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				return xexecutor(methodName, currentLine, scanner, bindings, lines, lineNumber);
			}
		}
		
		return null;
	}
	
	protected XObject xexecutor(String methodName, XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
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
			xsubmit(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(methodName.equals(IS_TERMINATED))
		{
			return xisTerminated(currentLine, bindings);
		}
		else if(methodName.equals(EXECUTE))
		{
			xexecute(currentLine, scanner, bindings, lines, lineNumber);
		}
		else if(methodName.equals(SHUTDOWN_NOW))
		{
			xshutdownNow(currentLine, scanner, bindings);
		}
		else if(methodName.equals(INVOKE_ALL))
		{
			xinvokeAll(scanner, bindings, lines, lineNumber);
		}
		else if(methodName.equals(INVOKE_ANY))
		{
			return xinvokeAny(currentLine, scanner, bindings, lines, lineNumber);
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
	
	protected XObject xsubmit(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		XEval task = xevalTask(currentLine, scanner, bindings, lines, lineNumber);
		
		String xreturn = task.xreturn();
		XFuture xfuture = xexecutorService.xsubmit((XCallable)task);
		
		if(xreturn.isEmpty() == false)
		{
			XObject xobject = XFutureObjectImpl.xnew(xfuture);
			bindings.xput(xreturn, xobject);
			return xobject;
		}
		return null;
	}
	
	protected XObject xisTerminated(XScanner currentLine, XBindings bindings) throws Exception
	{
		boolean b = xexecutorService.xisTerminated();
		XObject xobject = xfactory.xObject(b);
		return xreturn(xobject, currentLine, bindings);
	}
	
	protected void xexecute(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		XEval task = xevalTask(currentLine, scanner, bindings, lines, lineNumber);
		xexecutorService.xexecute(task);
	}
	
	protected void xshutdownNow(XScanner currentLine, XScanner scanner, XBindings bindings) throws Exception
	{
		xexecutorService.xshutdownNow();
	}

	protected List<XEval> xevalTask(String line, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		List<XEval> tasks = new ArrayList<XEval>();
		List<XScanner> current = new ArrayList<XScanner>();
		for(XScanner currentLine = null; scanner.xhasNextLine(); currentLine = xnextLine(scanner, current))
		{
			lineNumber++;
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(line.isEmpty() == false && methodName.equals(line))
					{
						xclose(currentLine);
						break;
					}
					else if(methodName.equals(FINAL))
					{
						xclose(currentLine);
						break;
					}
					else if(xisBlock(methodName))
					{
						List<XScanner> recent = new ArrayList<XScanner>();
						xgoto("", scanner, recent, lineNumber);
						XScanner cachedLines = XScannerImpl.xnew(recent);
						XEval task = XEvalImpl.xnew(this, cachedLines, bindings, "");
						tasks.add(task);
						
						if(lines != null)
						{
							lines.addAll(current);
							current = new ArrayList<XScanner>();
							lines.addAll(recent);
						}
						else
						{
							xclose(recent);
							xclose(current);
						}
					}
					else
					{
						String xreturn = xreturn(currentLine);
						XScanner cachedLines = XScannerImpl.xnew(current);
						XEval task = XEvalImpl.xnew(this, cachedLines, bindings, xreturn);
						tasks.add(task);
						
						if(lines != null)
						{
							lines.addAll(current);
							current = new ArrayList<XScanner>();
						}
						else
						{
							xclose(current);
						}
					}
				}
			}
			
			xclose(currentLine);
		}
		return tasks;
	}
	
	protected void xinvokeAll(XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		List<XEval> tasks = xevalTask("", scanner, bindings, lines, lineNumber);
		
		xinvokeAll(tasks, bindings);
		
		for(XEval task : tasks)
		{
			task.xscanner().xclose();
		}
		
		tasks.clear();
	}
	
	protected void xinvokeAll(List<XEval> tasks, XBindings bindings) throws Exception
	{
		if(tasks.isEmpty() == false)
		{
			XEval[] calls = new XEval[tasks.size()];
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
					XObject xobject = XFutureObjectImpl.xnew(xfutures[i]);
					
					bindings.xput(returns[i], xobject);
				}
			}
		}
	}
	
	protected XObject xinvokeAny(List<XEval> tasks, String xreturn, XBindings bindings) throws Exception
	{
		if(tasks.isEmpty() == false)
		{
			XEval[] calls = new XEval[tasks.size()];
			calls = tasks.toArray(calls);
			XObject xobject = xexecutorService.xinvokeAny(calls);
			
			if(xreturn.isEmpty() == false)
				xobject = bindings.xput(xreturn, xobject);
			
			return xobject;
		}
		
		return null;
	}
	
	protected XObject xinvokeAny(XScanner current, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		String xreturn = xreturn(current);
		List<XEval> tasks = xevalTask("", scanner, bindings, lines, lineNumber);
		
		XObject xobject = xinvokeAny(tasks, xreturn, bindings);
		
		for(XEval task : tasks)
		{
			task.xscanner().xclose();
		}
		
		tasks.clear();
		
		return xobject;
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
	
	protected XScanner xgoto(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String line = currentLine.xnext();
			if(line.isEmpty() == false)
			{
				XScanner xgoto = xgoto(line, scanner, lines, lineNumber);
				if(xgoto != null)
				{
					xeval(line, xgoto, scanner, bindings, lines, lineNumber);
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
	
	protected void xclose(List<XScanner> lines) throws Exception
	{
		for(XScanner scanner : lines)
		{
			xclose(scanner);
		}
		lines.clear();
	}
	
	protected XScanner xeval(String endLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception {
		// TODO Auto-generated method stub
		for(XScanner currentLine = null; scanner.xhasNextLine(); currentLine = xnextLine(scanner, lines))
		{
			lineNumber++;
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(endLine.isEmpty() == false && methodName.equals(endLine))
					{
						return currentLine;
					}
					else if(methodName.equals(FINAL))
					{
						xfinal(currentLine);
						break;
					}
					else if(methodName.equals(RETURN))
					{
						xreturn(currentLine, bindings);
						return null;
					}
					
					xeval(methodName, currentLine, scanner, bindings, lines, lineNumber);
					
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
	
	protected void xfinally(XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		XScanner xfinally = xgoto(FINALLY, scanner, lines, lineNumber);
		if(xfinally != null)
		{
			xclose(xfinally);
			xeval(scanner, bindings);
		}
	}
	
	protected void xelse(XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		XScanner xelse = xgoto(ELSE, scanner, lines, lineNumber);
		if(xelse != null)
		{
			xclose(xelse);
			xeval(scanner, bindings);
		}
	}
	
	protected void xwhile(XScanner xline, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		Iterator<XScanner> iterator = null;
		List<XScanner> recent =  new ArrayList<XScanner>();
		boolean bool = true;
		XScanner xwhile = xline.xclone(); 
		long tempLineNumber = lineNumber;
		do
		{
			XScanner currentLine = null;
			
			if(iterator != null)
			{
				if(iterator.hasNext())
				{
					currentLine = xnextLine(iterator);
					tempLineNumber++;
				}
			}
			
			if(currentLine == null)
			{
				if(scanner.xhasNextLine())
				{
					currentLine = xnextLine(scanner, recent);
					tempLineNumber++;
				}
			}
			
			if(currentLine == null)
			{
				break;
			}
			
			if(currentLine.xhasNext())
			{
				String methodName = xmethod(currentLine);
				
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(BREAK))
					{
						xclose(currentLine);
						break;
					}
					else if(methodName.equals(CONTINUE))
					{
						iterator = lines.iterator();
						tempLineNumber = lineNumber;
						xclose(currentLine);
						continue;
					}
					else if(methodName.equals(FINAL))
					{
						bool = xif(xline, bindings);
						if(bool)
						{
							iterator = lines.iterator();
							tempLineNumber = lineNumber;
							xline = xwhile.xclone();
						}
					}
					else if(methodName.equals(RETURN))
					{
						if(lines != null)
						{
							lines.addAll(recent);
						}
						else
						{
							xclose(recent);
						}
						xclose(currentLine);
						xreturn(currentLine, bindings);
						return;
					}
					else
						xeval(methodName, currentLine, scanner, bindings, recent, tempLineNumber);
				}
			}
			xclose(currentLine);
		}
		while(bool);
		
		if(lines != null)
		{
			lines.addAll(recent);
		}
		else
		{
			xclose(recent);
		}
	}
	
	protected void xthrow(XScanner currentLine, XBindings bindings) throws Exception
	{
		XObject xthis = xthis(currentLine, bindings);
		if(xthis != null)
		{
			throw (Exception) xthis.x();
		}
	}
	
	protected XScanner xnextLine(XScanner xscanner, List<XScanner> lines) throws Exception
	{
		XScanner temp = xscanner.xnextLine();
		
		if(lines != null)
			lines.add(temp.xclone());
		
		XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
		
		xclose(temp);
		
		return currentLine;
	}
	
	protected XScanner xnextLine(Iterator<XScanner> iterator) throws Exception
	{
		if(iterator.hasNext())
		{
			XScanner temp = iterator.next().xclone();
			
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			
			xclose(temp);
			
			return currentLine;
		}
		return null;
	}

	public XObject xeval(XScanner xscanner, XBindings xbindings) throws Exception {
		// TODO Auto-generated method stub
		return xeval(xscanner, xbindings, null, 0);
	}
	
	protected boolean xfalse(XScanner currentLine, XBindings bindings) throws Exception
	{
		return !xboolean(currentLine, bindings, true);
	}
	
	protected boolean xand(XScanner currentLine, XBindings bindings) throws Exception
	{
		boolean value1 = xboolean(currentLine, bindings, false);
		boolean value2 = xboolean(currentLine, bindings, false);
		
		return value1 && value2;
	}
	
	protected boolean xor(XScanner currentLine, XBindings bindings) throws Exception
	{
		boolean value1 = xboolean(currentLine, bindings, false);
		boolean value2 = xboolean(currentLine, bindings, false);
		
		return value1 || value2;
	}
	
	protected boolean xnot(XScanner currentLine, XBindings bindings) throws Exception
	{
		return !xboolean(currentLine, bindings, true);
	}
	
	protected boolean xboolean(XScanner currentLine, XBindings bindings, boolean defaultValue) throws Exception
	{
		if(currentLine.xhasNextBoolean())
		{
			return currentLine.xnextBoolean();
		}
		else if(currentLine.xhasNext())
		{
			String name = currentLine.xnext();
			
			if(!name.isEmpty())
			{
				if(name.startsWith(PARAMETER_NAME_PREFIX))
				{
					name = name.substring(PARAMETER_NAME_PREFIX.length());
					
					if(name.isEmpty() == false)
					{
						if(name.equals(TRUE))
							return xtrue(currentLine, bindings);
						else if(name.equals(FALSE))
							return xfalse(currentLine, bindings);
						else if(name.equals(AND))
							return xand(currentLine, bindings);
						else if(name.equals(OR))
							return xor(currentLine, bindings);
						else if(name.equals(NOT))
							return xnot(currentLine, bindings);
					}
				}
				else if(name.startsWith(OBJECT_REF_PREFIX))
				{
					name = name.substring(OBJECT_REF_PREFIX.length());
					
					if(!name.isEmpty())
					{
						if(bindings.xcontainsKey(name))
						{
							XObject xobject = bindings.xget(name);
							
							if(xobject.xequals(XObject.xnull) == false)
							{
								if(xobject.xgetClass().xgetName().equals("java.lang.Boolean"))
								{
									Boolean value = (Boolean) xobject.x();
									
									return value;
								}
							}
						}
					}
				}
			}
		}
		
		return defaultValue;
	}
	
	protected boolean xisBlock(String method) throws Exception
	{
		switch(method)
		{
		case CATCH:
		case DO:
		case ELSE:
		case EVAL:
		case FINALLY:
		case FOR:
		case IF:
		case INVOKE_ALL:
		case INVOKE_ANY:
		case SUPER:
		case SYNCHRONIZED:
		case TRY:
		case WHILE:
			return true;
		}
		
		return false;
	}
	
	protected XEval xevalTask(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		XEval task = null;
		List<XScanner> current = new ArrayList<XScanner>();
		current.add(currentLine.xclone());
		if(currentLine.xhasNext())
		{
			String methodName = xmethod(currentLine);
			
			if(methodName.isEmpty() == false)
			{
				if(xisBlock(methodName))
				{
					List<XScanner> recent = new ArrayList<XScanner>();
					xgoto("", scanner, recent, lineNumber);
					XScanner cachedLines = XScannerImpl.xnew(recent);
					task = XEvalImpl.xnew(this, cachedLines, bindings, "");
					
					if(lines != null)
					{
						lines.addAll(current);
						current = new ArrayList<XScanner>();
						lines.addAll(recent);
					}
					else
					{
						xclose(recent);
						xclose(current);
					}
				}
				else
				{
					String xreturn = xreturn(currentLine);
					XScanner cachedLines = XScannerImpl.xnew(current);
					task = XEvalImpl.xnew(this, cachedLines, bindings, xreturn);
					
					if(lines != null)
					{
						lines.addAll(current);
						current = new ArrayList<XScanner>();
					}
					else
					{
						xclose(current);
					}
				}
			}
		}
		return task;
	}
	
	protected void xsynchronized(XScanner currentLine, XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		XObject xobject = xthis(currentLine, bindings);
		synchronized(xobject)
		{
			xeval("", scanner, bindings, lines, lineNumber);
		}
	}
	
	protected void xcomment(XScanner scanner, XBindings bindings, long lineNumber) throws Exception
	{
		XScanner end = xgoto(COMMENT_BLOCK_END, scanner, null, lineNumber);
		if(end != null)
			xclose(end);
	}
	
	protected void xdebug(XScanner scanner, XBindings bindings, List<XScanner> lines, long lineNumber) throws Exception
	{
		// TODO Auto-generated method stub
	}
	
	protected void xhelp(XScanner currentLine, XBindings bindings) throws Exception
	{
		XClass xcls = null;
		
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
							if(xclasses.containsKey(paramValue))
							{
								xcls = xclasses.get(paramValue);
							}
						}
					}
				}
				else if(paramName.equals(THIS))
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
									xcls = bindings.xget(paramValue).xgetClass();
								}
							}
						}
					}
				}
				
			}
		}
		
		if(xcls != null)
		{
			String method = "";
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.startsWith(PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
					
					if(paramName.equals(HELP_METHOD))
					{
						if(currentLine.xhasNext())
						{
							method = currentLine.xnext();
						}
					}
				}
			}

			xhelp(xcls, method);
		}
		else
		{
			for(XClass cls : xclasses.values())
			{
				xhelp(cls, "");
			}
		}
	}

	protected void xhelp(XClass xcls, String method) throws Exception
	{
		if(method.isEmpty())
		{
			xwriter.xwrite(CLASS + PARAMETER_SEPARATOR + xcls.xgetSimpleName());
			for(XMethod xmethod : xcls.xgetMethods())
			{
				xhelp(xmethod, xcls);
			}
			xwriter.xwrite(FINAL);
		}
		else
		{
			xwriter.xwrite(CLASS + PARAMETER_SEPARATOR + xcls.xgetSimpleName());
			for(XMethod xmethod : xcls.xgetMethods())
			{
				if(xmethod.xgetName().equals(method))
					xhelp(xmethod, xcls);
			}
			xwriter.xwrite(FINAL);
		}
	}
	
	protected void xhelp(XMethod xmethod, XClass xcls) throws Exception
	{
		StringBuilder text = new StringBuilder();
		
		text.append(xmethod.xgetName());
		
		if(xmethod.xgetModifiers().xisStatic())
		{
			text.append(PARAMETER_SEPARATOR);
			text.append(PARAMETER_NAME_PREFIX);
			text.append(CLASS);
			text.append(PARAMETER_SEPARATOR);
			text.append(CLASS_REF_PREFIX);
			text.append(xcls.xgetSimpleName());
		}
		else
		{
			text.append(PARAMETER_SEPARATOR);
			text.append(PARAMETER_NAME_PREFIX);
			text.append(THIS);
			text.append(PARAMETER_SEPARATOR);
			text.append(OBJECT_REF_PREFIX);
			text.append(xcls.xgetSimpleName().toLowerCase());
		}
		
		for(XParameter xparameter : xmethod.xgetParameters())
		{
			text.append(PARAMETER_SEPARATOR);
			text.append(PARAMETER_NAME_PREFIX);
			text.append(xparameter.xgetName());
			text.append(PARAMETER_SEPARATOR);
			text.append(CLASS_REF_PREFIX);
			text.append(xparameter.xgetType());
		}
	}
	
	protected void xlog(XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String method = currentLine.xnext();
			
			if(method.isEmpty() == false)
			{
				xlog(method, currentLine, bindings);
			}
		}
	}
	
	protected void xlog(String method, XScanner currentLine, XBindings bindings) throws Exception
	{
		if(method.equals(LOG_CONFIG))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						
						xlogger.xconfig(msg);
					}
				}
			}
		}
		else if(method.equals(LOG_FINE))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						
						xlogger.xfine(msg);
					}
				}
			}
		}
		else if(method.equals(LOG_FINER))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						
						xlogger.xfiner(msg);
					}
				}
			}
		}
		else if(method.equals(LOG_FINEST))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						
						xlogger.xfinest(msg);
					}
				}
			}
		}
		else if(method.equals(LOG_INFO))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						
						xlogger.xinfo(msg);
					}
				}
			}
		}
		else if(method.equals(LOG_SEVERE))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						
						xlogger.xsevere(msg);
					}
				}
			}
		}
		else if(method.equals(LOG_WARNING))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						
						xlogger.xwarning(msg);
					}
				}
			}
		}
	}
}
