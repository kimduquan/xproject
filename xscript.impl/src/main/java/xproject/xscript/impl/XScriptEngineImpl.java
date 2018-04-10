package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import xproject.xio.XWriter;
import xproject.xlang.XClass;
import xproject.xlang.XException;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.XRunnable;
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
import xproject.xutil.xlogging.XLogger;

public class XScriptEngineImpl implements XScriptEngine, XEngine 
{
	private XContext xdefaultContext;
	private XBinding xdefaultBinding;
	private volatile XClass xclass;
	private volatile XObject xthis;
	
	protected XScriptEngineImpl(XScriptContext scriptContext, XBindings bindings)
	{
		xclass = null;
		xthis = null;
		xdefaultContext = null;
		xdefaultBinding = null;
	}
	
	public XObject xeval(XScript script, XBinding binding, XContext context) throws Exception {
		// TODO Auto-generated method stub
		XLine xreturn = xeval(XConstants.RETURN, script, binding, context);
		if(xreturn != null)
			return xreturn(xreturn.xscanner(), binding.xbindings(), binding.xfactory());
		return null;
	}
	
	protected XObject xeval(String method, XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception
	{
		if(method.equals(XConstants.IMPORT))
		{
			ximport(currentLine.xscanner(), binding, context);
		}
		else if(method.equals(XConstants.NEW))
		{
			return xnew(currentLine.xscanner(), binding);
		}
		else if(method.equals(XConstants.TRY))
		{
			xtry(script, binding, context);
		}
		else if(method.equals(XConstants.IF))
		{
			xif(currentLine, script, binding, context);
		}
		else if(method.equals(XConstants.SUPER))
		{
			return xsuper(currentLine, script, binding, context);
		}
		else if(method.equals(XConstants.DO))
		{
			xdo(script, binding, context);
		}
		else if(method.equals(XConstants.FOR))
		{
			xfor(currentLine, script, binding, context);
		}
		else if(method.equals(XConstants.GOTO))
		{
			xgoto(currentLine, script, binding, context);
		}
		else if(method.equals(XConstants.WHILE))
		{
			xwhile(currentLine, script, binding, context);
		}
		else if(method.equals(XConstants.THROW))
		{
			xthrow(currentLine.xscanner(), binding.xbindings());
		}
		else if(method.equals(XConstants.SYNCHRONIZED))
		{
			xsynchronized(currentLine, script, binding, context);
		}
		else if(method.equals(XConstants.COMMENT_LINE))
		{
		}
		else if(method.equals(XConstants.COMMENT_BLOCK))
		{
			xcomment(script);
		}
		else if(method.equals(XConstants.LAMBDA))
		{
			return xlambda(currentLine.xscanner(), script, binding, context);
		}
		else
			return xinvoke(method, currentLine, binding, context);
		return null;
	}
	
	public static XScriptEngine xnew(XScriptContext scriptContext, XBindings bindings)
	{
		return new XScriptEngineImpl(scriptContext, bindings);
	}

	protected XObject xthis(XScanner currentLine, XBindings bindings) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.THIS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								if(bindings.xcontainsKey(paramValue))
								{
									return xget(paramValue, bindings);
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	protected XClass xclass(XScanner currentLine, XBinding binding) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(binding.xhasClass(paramValue))
								return binding.xgetClass(paramValue);
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
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.RETURN))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								return paramValue;
							}
						}
					}
				}
			}
		}
		return "";
	}
	
	protected XObject[] xparameter(XScanner currentLine, XBindings bindings, XFactory factory) throws Exception
	{
		ArrayList<XObject> paramValues = new ArrayList<XObject>();
		while(currentLine.xhasNext())
		{
			String name = currentLine.xnext();
			if(name.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				name = name.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(currentLine.xhasNextBoolean())
				{
					paramValues.add(factory.xObject(currentLine.xnextBoolean()));
				}
				else if(currentLine.xhasNextByte())
				{
					paramValues.add(factory.xObject(currentLine.xnextByte()));
				}
				else if(currentLine.xhasNextDouble())
				{
					paramValues.add(factory.xObject(currentLine.xnextDouble()));
				}
				else if(currentLine.xhasNextFloat())
				{
					paramValues.add(factory.xObject(currentLine.xnextFloat()));
				}
				else if(currentLine.xhasNextInt())
				{
					paramValues.add(factory.xObject(currentLine.xnextInt()));
				}
				else if(currentLine.xhasNextLong())
				{
					paramValues.add(factory.xObject(currentLine.xnextLong()));
				}
				else if(currentLine.xhasNextShort())
				{
					paramValues.add(factory.xObject(currentLine.xnextShort()));
				}
				else if(currentLine.xhasNext())
				{
					String value = currentLine.xnext();
					if(value.startsWith(XConstants.OBJECT_REF_PREFIX))
					{
						value = value.substring(XConstants.OBJECT_REF_PREFIX.length());
						if(bindings.xcontainsKey(value))
						{
							paramValues.add(xget(value, bindings));
						}
					}
					else
					{
						paramValues.add(factory.xObject(value));
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
	
	protected void ximport(XScanner currentLine, XBinding binding, XContext context) throws Exception 
	{
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(binding.xhasClass(paramValue) == false)
							{
								XClass xclass = context.xclassLoader().xloadClass(paramValue);
								if(xclass != null)
								{
									binding.ximport(xclass.xgetSimpleName(), xclass);
								}
							}
						}
					}
				}
			}
		}
	}
	
	protected XObject xinvoke(String method, XLine currentLine, XBinding binding, XContext context) throws Exception 
	{
		XScanner scanner = currentLine.xscanner();
		XBindings bindings = binding.xbindings();
		XObject xthis = xthis(scanner, bindings);
		XClass xclass = null;
		if(xthis == null) 
		{
			xclass = xclass(scanner, binding);
		}
		else
		{
			xclass = xthis.xgetClass();
		}
		XObject[] xparameters = xparameter(scanner, bindings, binding.xfactory());
		XMethod xmethod = xmethod(method, xparameters, xthis, xclass, scanner, binding);
		if(xmethod != null)
		{
			XObject xreturn = xmethod.xinvoke(xthis, xparameters);
			return xreturn(xreturn, scanner, bindings);
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
	
	protected XMethod xmethod(String method, XObject[] xparameters, XObject xthis, XClass xclass, XScanner currentLine, XBinding binding) throws Exception
	{
		ArrayList<XClass> xclasses = new ArrayList<XClass>();
		if(xclass != null)
		{
			xclasses.add(xclass);
		}
		else
		{
			for(XClass c : binding.xgetClasses())
			{
				xclasses.add(c);
			}
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
	
	protected XObject xinvoke(String method, XObject xthis, XClass xclass, XScanner currentLine, XBinding binding, XContext context) throws Exception
	{
		XBindings bindings = binding.xbindings();
		XObject[] xparameters = xparameter(currentLine, bindings, binding.xfactory());
		XMethod xmethod = xmethod(method, xparameters, xthis, xclass, currentLine, binding);
		if(xmethod != null)
		{
			XLogger logger = context.xlogger();
			logger.xentering(xclass.xgetSimpleName(), xmethod.xgetName(), xparameters);
			XObject xreturn = xmethod.xinvoke(xthis, xparameters);
			logger.xexiting(xclass.xgetSimpleName(), xmethod.xgetName(), xreturn);
			return xreturn(xreturn, currentLine, bindings);
		}
		return null;
	}

	protected XObject xnew(XScanner currentLine, XBinding binding) throws Exception {
		// TODO Auto-generated method stub
		XClass xclass = xclass(currentLine, binding);
		if(xclass != null)
		{
			XBindings bindings = binding.xbindings();
			XObject[] xparameters = xparameter(currentLine, bindings, binding.xfactory());
			XConstructor xconstructor = xconstructor(xclass, xparameters);
			if(xconstructor != null)
			{
				XObject xreturn = xconstructor.xnewInstance(xparameters);
				return xreturn(xreturn, currentLine, bindings);
			}
		}
		return null;
	}

	protected XLine xgoto(String line, XScript script) throws Exception
	{
		for(XLine currentLine = null; script.xhasNextLine(); currentLine = script.xnextLine())
		{
			XScanner scanner = currentLine.xscanner();
			if(scanner.xhasNext())
			{
				String methodName = xmethod(scanner);
				if(methodName.isEmpty() == false)
				{
					if(line.isEmpty() == false && methodName.equals(line))
					{
						return currentLine;
					}
					else if(methodName.equals(XConstants.FINAL))
					{
						currentLine.xclose();
						return null;
					}
					if(xisBlock(methodName))
					{
						xgoto("", script);
					}
				}
			}
			currentLine.xclose();
		}
		return null;
	}
	
	protected void xtry(XScript script, XBinding bindings, XContext context) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval(script, bindings, context);
		}
		catch(Exception ex)
		{
			xcatch(ex, script, bindings, context);
		}
		finally
		{
			xfinally(script, bindings, context);
		}
	}

	protected XObject xcatch(Exception exception, XLine catchLine, XBinding binding) throws Exception {
		// TODO Auto-generated method stub
		XClass xclass = xclass(catchLine.xscanner(), binding);
		XFactory factory = binding.xfactory();
		if(xclass != null)
		{
			XException xexception = factory.xException(exception);
			if(xclass.xisAssignableFrom(xexception.xgetClass()))
			{
				return xreturn(xexception, catchLine.xscanner(), binding.xbindings());
			}
			factory.xfinalize(xexception);
		}
		else
		{
			return xreturn(factory.xException(exception), catchLine.xscanner(), binding.xbindings());
		}
		return null;
	}
	
	protected void xcatch(Exception exception, XScript script, XBinding binding, XContext context) throws Exception {
		// TODO Auto-generated method stub
		XObject xexception = null;
		XLine xcatch = null;
		do
		{
			xcatch = xgoto(XConstants.CATCH, script);
			if(xexception == null)
			{
				xexception = xcatch(exception, xcatch, binding);
			}
		}
		while(xcatch != null);
		if(xexception == null)
		{
			throw exception;
		}
	}
	
	protected boolean xif(XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception 
	{
		XBindings bindings = binding.xbindings();
		if(xif(currentLine.xscanner(), bindings))
		{
			XLine xelse = xeval(XConstants.ELSE, script, binding, context);
			if(xelse != null)
			{
				do
				{
					xelse.xclose();
					xelse = xgoto(XConstants.ELSE, script);
				}
				while(xelse != null);
			}
			return true;
		}
		else
		{
			XLine xelse = xgoto(XConstants.ELSE, script);
			if(xelse != null)
			{
				xelse = xeval(XConstants.ELSE, script, binding, context);
				do
				{
					xelse.xclose();
					xelse = xgoto(XConstants.ELSE, script);
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
	
	protected void xdo(XScript script, XBinding binding, XContext context) throws Exception 
	{
		XBindings bindings = binding.xbindings();
		XCachedScript cachedScript = XCachedScriptImpl.xnew(script);
		boolean bool = true;
		do
		{
			bool = cachedScript.xhasNextLine();
			if(bool)
			{
				XLine currentLine = cachedScript.xnextLine();
				String methodName = xmethod(currentLine.xscanner());
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(XConstants.BREAK))
					{
						currentLine.xclose();
						break;
					}
					else if(methodName.equals(XConstants.CONTINUE))
					{
						currentLine.xclose();
						cachedScript.xrefresh();
						continue;
					}
					else if(methodName.equals(XConstants.WHILE))
					{
						bool = xif(currentLine.xscanner(), bindings);
						if(bool)
						{
							cachedScript.xrefresh();
						}
					}
					else if(methodName.equals(XConstants.RETURN))
					{
						currentLine.xclose();
						cachedScript.xclose();
						return;
					}
					else
						xeval(methodName, currentLine, script, binding, context);
				}
				currentLine.xclose();
			}
		}
		while(bool);
		cachedScript.xclose();
	}
	
	protected void xfor(XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception {
		// TODO Auto-generated method stub
		XBindings bindings = binding.xbindings();
		XObject xthis = xthis(currentLine.xscanner(), bindings);
		if(xthis != null)
		{
			String xreturn = xreturn(currentLine.xscanner());
			if(xthis.xgetClass().xisArray())
			{
				XArray xarray = (XArray) xthis;
				xfor(xarray, xreturn, script, binding, context);
			}
		}
	}
	
	protected void xfor(XArray xarray, String xreturn, XScript script, XBinding binding, XContext context) throws Exception
	{
		XBindings bindings = binding.xbindings();
		XCachedScript cachedScript = XCachedScriptImpl.xnew(script);
		for(int length = xarray.xgetLength(), index = 0;index < length && cachedScript.xhasNextLine();)
		{
			XLine currentLine = cachedScript.xnextLine();
			XScanner scanner = currentLine.xscanner();
			if(scanner.xhasNext())
			{
				String methodName = xmethod(scanner);
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(XConstants.FINAL))
					{
						cachedScript.xstopCaching();
						index++;
						if(index < length)
						{
							cachedScript.xrefresh();
							if(!xreturn.isEmpty())
							{
								bindings.xput(xreturn, xarray.xget(index));
							}
						}
					}
					else if(methodName.equals(XConstants.RETURN))
					{
						xreturn(scanner, bindings, binding.xfactory());
						cachedScript.xclose();
						return;
					}
					else if(methodName.equals(XConstants.BREAK))
					{
						currentLine.xclose();
						break;
					}
					else if(methodName.equals(XConstants.CONTINUE))
					{
						index++;
						if(index < length)
						{
							cachedScript.xrefresh();
							if(!xreturn.isEmpty())
							{
								bindings.xput(xreturn, xarray.xget(index));
							}
						}
						continue;
					}
					else
						xeval(methodName, currentLine, script, binding, context);
				}
			}
			currentLine.xclose();
		}
		cachedScript.xclose();
	}

	protected XObject xreturn(XScanner currentLine, XBindings bindings, XFactory factory) throws Exception {
		// TODO Auto-generated method stub
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.THIS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								if(bindings.xcontainsKey(paramValue))
								{
									return xget(paramValue, bindings);
								}
							}
							else if(paramValue.equals(XConstants.NULL))
							{
								return factory.xObject(null);
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	protected XObject xsuper(XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception
	{
		XScanner scanner = currentLine.xscanner();
		if(scanner.xhasNext())
		{
			String methodName = scanner.xnext();
			if(methodName.isEmpty() == false)
			{
				XBindings bindings = binding.xbindings();
				if(methodName.equals(XConstants.EXECUTOR))
				{
					return xexecutor(currentLine, script, binding, context);
				}
				else if(methodName.equals(XConstants.EVAL))
				{
					return xeval(script, binding, context);
				}
				else if(methodName.equals(XConstants.DEBUG))
				{
					xsuper_debug(script, binding, context);
				}
				else if(methodName.equals(XConstants.HELP))
				{
					xsuper_help(currentLine.xscanner(), binding, context);
				}
				else if(methodName.equals(XConstants.LOG))
				{
					xsuper_log(currentLine.xscanner(), binding, context);
				}
				else if(methodName.startsWith(XConstants.X_METHOD_NAME_PREFIX) == false)
				{
					XFactory factory = binding.xfactory();
					XField xfield = xclass(factory).xgetField(methodName);
					if(xfield != null)
					{
						return xextension(methodName, xfield, currentLine.xscanner(), bindings, factory);
					}
					return xinvoke(methodName, xthis(factory), xclass(factory), currentLine.xscanner(), binding, context);
				}
			}
		}
		return null;
	}

	public void xfinalize() throws Throwable 
	{
		if(xclass != null)
		{
			xclass.xfinalize();
			xclass = null;
		}
		if(xthis != null)
		{
			xthis = null;
		}
		finalize();
	}

	public XObject xeval(XScanner xscanner) throws Exception {
		// TODO Auto-generated method stub
		XScript script = null;
		XBinding binding = null;
		XContext context = null;
		return xeval(script, binding, context);
	}


	public XBindings xcreateBindings() throws Exception {
		// TODO Auto-generated method stub
		return XBindingsImpl.xnew();
	}

	public XObject xeval(XScanner xscanner, XScriptContext xcontext) throws Exception {
		// TODO Auto-generated method stub
		return xeval(xscanner, xcontext.xgetBindings(XScriptContext.XGLOBAL_SCOPE));
	}

	public XObject xeval(String script, XBindings bindings) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObject xeval(String script, XScriptContext xcontext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObject xeval(String script) throws Exception 
	{
		XScript xscript = null;
		return xeval(xscript, xdefaultBinding, xdefaultContext);
	}
	
	protected XObject xexecutor(XLine currentLine, XScript script, XBinding bindings, XContext context) throws Exception
	{
		XScanner scanner = currentLine.xscanner();
		if(scanner.xhasNext())
		{
			String methodName = scanner.xnext();
			if(methodName.isEmpty() == false)
			{
				return xexecutor(methodName, currentLine, script, bindings, context);
			}
		}
		return null;
	}
	
	protected XObject xexecutor(String methodName, XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception
	{
		if(methodName.equals(XConstants.AWAIT_TERMINATION))
		{
			return xexecutor_xawaitTermination(currentLine.xscanner(), binding.xbindings(), context.xexecutorService(), binding.xfactory());
		}
		else if(methodName.equals(XConstants.SHUTDOWN))
		{
			context.xexecutorService().xshutdown();
		}
		else if(methodName.equals(XConstants.SUBMIT))
		{
			xexecutor_xsubmit(currentLine, script, binding, context);
		}
		else if(methodName.equals(XConstants.IS_TERMINATED))
		{
			return xexecutor_xisTerminated(currentLine.xscanner(), binding, context);
		}
		else if(methodName.equals(XConstants.EXECUTE))
		{
			xexecutor_xexecute(currentLine, script, binding, context);
		}
		else if(methodName.equals(XConstants.SHUTDOWN_NOW))
		{
			context.xexecutorService().xshutdownNow();
		}
		else if(methodName.equals(XConstants.INVOKE_ALL))
		{
			xexecutor_xinvokeAll(script, binding, context);
		}
		else if(methodName.equals(XConstants.INVOKE_ANY))
		{
			return xexecutor_xinvokeAny(currentLine, script, binding, context);
		}
		return null;
	}
	
	protected XObject xexecutor_xawaitTermination(XScanner currentLine, XBindings bindings, XExecutorService service, XFactory factory) throws Exception
	{
		if(currentLine.xhasNextLong())
		{
			long timeOut = currentLine.xnextLong();
			if(currentLine.xhasNext())
			{
				String timeUnit = currentLine.xnext();
				boolean b = service.xawaitTermination(timeOut, TimeUnit.valueOf(timeUnit));
				XObject xobject = factory.xObject(b);
				return xreturn(xobject, currentLine, bindings);
			}
		}
		return null;
	}
	
	protected XObject xexecutor_xsubmit(XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception
	{
		XEvalTask task = xevalTask(script, binding, context);
		context.xexecutorService().xsubmit((XRunnable)task);
		return null;
	}
	
	protected XObject xexecutor_xisTerminated(XScanner currentLine, XBinding binding, XContext context) throws Exception
	{
		boolean b = context.xexecutorService().xisTerminated();
		XObject xobject = binding.xfactory().xObject(b);
		return xreturn(xobject, currentLine, binding.xbindings());
	}
	
	protected void xexecutor_xexecute(XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception
	{
		XEvalTask task = xevalTask(script, binding, context);
		context.xexecutorService().xexecute(task);
	}

	protected List<XEvalTask> xevalTasks(XScript script, XBinding binding, XContext context) throws Exception
	{
		ArrayList<XEvalTask> tasks = new ArrayList<XEvalTask>();
		XCachedScript cachedScript = XCachedScriptImpl.xnew(script);
		for(XLine currentLine = null; cachedScript.xhasNextLine(); currentLine = cachedScript.xnextLine())
		{
			XScanner scanner = currentLine.xscanner();
			if(scanner.xhasNext())
			{
				String methodName = xmethod(scanner);
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(XConstants.FINAL))
					{
						currentLine.xclose();
						break;
					}
					if(xisBlock(methodName))
					{
						xgoto("", cachedScript);
					}
					cachedScript.xstopCaching();
					cachedScript.xrefresh();
					tasks.add(XEvalTaskImpl.xnew(this, cachedScript, binding, context));
					cachedScript = XCachedScriptImpl.xnew(script);
				}
			}
			currentLine.xclose();
		}
		return tasks;
	}
	
	protected void xexecutor_xinvokeAll(XScript script, XBinding binding, XContext context) throws Exception
	{
		List<XEvalTask> tasks = xevalTasks(script, binding, context);
		XCallable[] calls = new XCallable[tasks.size()];
		int i = 0;
		for(XEvalTask task : tasks)
		{
			calls[i] = task;
			i++;
		}
		context.xexecutorService().xinvokeAll(calls);
		for(XEvalTask task : tasks)
		{
			try 
			{
				task.xfinalize();
			} 
			catch (Throwable e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected XObject xexecutor_xinvokeAny(XLine current, XScript script, XBinding binding, XContext context) throws Exception
	{
		List<XEvalTask> tasks = xevalTasks(script, binding, context);
		XCallable[] calls = new XCallable[tasks.size()];
		int i = 0;
		for(XEvalTask task : tasks)
		{
			calls[i] = task;
			i++;
		}
		XObject xobject = context.xexecutorService().xinvokeAny(calls);
		for(XEvalTask task : tasks)
		{
			try 
			{
				task.xfinalize();
			} 
			catch (Throwable e) 
			{
				e.printStackTrace();
			}
		}
		return xobject;
	}
	
	protected XObject xextension(String fieldName, XField xfield, XScanner currentLine, XBindings bindings, XFactory factory) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String method = currentLine.xnext();
			if(method.isEmpty() == false)
			{
				XClass xtype = xfield.xgetType();
				XObject[] xparameters = xparameter(currentLine, bindings, factory);
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
							xobject = xfield.xget(xthis(factory));
						}
						return xmethod.xinvoke(xobject, xparameters);
					}
				}
			}
		}
		return null;
	}

	protected XClass xclass(XFactory factory) throws Exception
	{
		if(xclass == null)
			xclass = factory.xClass(this.getClass());
		return xclass;
	}
	
	protected XObject xthis(XFactory factory) throws Exception
	{
		if(xthis == null)
			xthis = factory.xObject(this);
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
	
	protected XLine xgoto(XLine currentLine, XScript script, XBinding bindings, XContext context) throws Exception
	{
		XScanner scanner = currentLine.xscanner();
		if(scanner.xhasNext())
		{
			String line = scanner.xnext();
			if(line.isEmpty() == false)
			{
				XLine xgoto = xgoto(line, script);
				if(xgoto != null)
				{
					xeval(line, xgoto, script, bindings, context);
					xgoto.xclose();
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
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(parameter))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								return paramValue;
							}
						}
					}
				}
			}
		}
		return "";
	}

	protected XLine xeval(String endLine, XScript script, XBinding binding, XContext context) throws Exception 
	{
		// TODO Auto-generated method stub
		for(XLine currentLine = null; script.xhasNextLine(); currentLine = script.xnextLine())
		{
			XScanner scanner = currentLine.xscanner();
			if(scanner.xhasNext())
			{
				String methodName = xmethod(scanner);
				if(methodName.isEmpty() == false)
				{
					if(endLine.isEmpty() == false && methodName.equals(endLine))
					{
						return currentLine;
					}
					else if(methodName.equals(XConstants.FINAL))
					{
						currentLine.xclose();
						break;
					}
					else if(methodName.equals(XConstants.RETURN))
					{
						xreturn(scanner, binding.xbindings(), binding.xfactory());
						return null;
					}
					xeval(methodName, currentLine, script, binding, context);
				}
			}
			currentLine.xclose();
		}
		return null;
	}
	
	protected void xfinally(XScript script, XBinding bindings, XContext context) throws Exception
	{
		XLine xfinally = xgoto(XConstants.FINALLY, script);
		if(xfinally != null)
		{
			xfinally.xclose();
			xeval(script, bindings, context);
		}
	}
	
	protected void xelse(XScript script, XBinding bindings, XContext context) throws Exception
	{
		XLine xelse = xgoto(XConstants.ELSE, script);
		if(xelse != null)
		{
			xelse.xclose();
			xeval(script, bindings, context);
		}
	}
	
	protected void xwhile(XLine xline, XScript script, XBinding binding, XContext context) throws Exception
	{
		XBindings bindings = binding.xbindings();
		XCachedScript cachedScript = XCachedScriptImpl.xnew(script);
		XLine xwhile = xline.xclone();
		boolean bool = xif(xwhile.xscanner(), bindings);
		xwhile.xclose();
		while(bool && cachedScript.xhasNextLine())
		{
			XLine currentLine = cachedScript.xnextLine();
			XScanner scanner = currentLine.xscanner();
			if(scanner.xhasNext())
			{
				String methodName = xmethod(scanner);
				if(methodName.isEmpty() == false)
				{
					if(methodName.equals(XConstants.FINAL))
					{
						cachedScript.xstopCaching();
						xwhile = xline.xclone();
						bool = xif(xwhile.xscanner(), bindings);
						xwhile.xclose();
						if(bool)
							cachedScript.xrefresh();
					}
					else if(methodName.equals(XConstants.RETURN))
					{
						xreturn(scanner, bindings, binding.xfactory());
						cachedScript.xclose();
						return;
					}
					else if(methodName.equals(XConstants.BREAK))
					{
						currentLine.xclose();
						break;
					}
					else if(methodName.equals(XConstants.CONTINUE))
					{
						xwhile = xline.xclone();
						bool = xif(xwhile.xscanner(), bindings);
						xwhile.xclose();
						if(bool)
							cachedScript.xrefresh();
						continue;
					}
					else
						xeval(methodName, currentLine, script, binding, context);
				}
			}
			currentLine.xclose();
		}
		cachedScript.xclose();
	}
	
	protected void xthrow(XScanner currentLine, XBindings bindings) throws Exception
	{
		XObject xthis = xthis(currentLine, bindings);
		if(xthis != null)
		{
			throw (Exception) xthis.x();
		}
	}

	public XObject xeval(XScanner xscanner, XBindings xbindings) throws Exception {
		// TODO Auto-generated method stub
		XScript script = null;
		XContext context = null;
		XBinding binding = null;
		return xeval(script, binding, context);
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
				if(name.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					name = name.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(name.isEmpty() == false)
					{
						if(name.equals(XConstants.TRUE))
							return xtrue(currentLine, bindings);
						else if(name.equals(XConstants.FALSE))
							return xfalse(currentLine, bindings);
						else if(name.equals(XConstants.AND))
							return xand(currentLine, bindings);
						else if(name.equals(XConstants.OR))
							return xor(currentLine, bindings);
						else if(name.equals(XConstants.NOT))
							return xnot(currentLine, bindings);
					}
				}
				else if(name.startsWith(XConstants.OBJECT_REF_PREFIX))
				{
					name = name.substring(XConstants.OBJECT_REF_PREFIX.length());
					if(!name.isEmpty())
					{
						if(bindings.xcontainsKey(name))
						{
							XObject xobject = xget(name, bindings);
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
		case XConstants.CATCH:
		case XConstants.DO:
		case XConstants.ELSE:
		case XConstants.EVAL:
		case XConstants.FINALLY:
		case XConstants.FOR:
		case XConstants.IF:
		case XConstants.INVOKE_ALL:
		case XConstants.INVOKE_ANY:
		case XConstants.LAMBDA:
		case XConstants.SUPER:
		case XConstants.SYNCHRONIZED:
		case XConstants.TRY:
		case XConstants.WHILE:
			return true;
		}
		return false;
	}
	
	protected void xsynchronized(XLine currentLine, XScript script, XBinding binding, XContext context) throws Exception
	{
		XObject xobject = xthis(currentLine.xscanner(), binding.xbindings());
		synchronized(xobject)
		{
			xeval(script, binding, context);
		}
	}
	
	protected void xcomment(XScript script) throws Exception
	{
		XLine end = xgoto(XConstants.COMMENT_BLOCK_END, script);
		if(end != null)
			end.xclose();
	}
	
	protected void xsuper_debug(XScript script, XBinding bindings, XContext context) throws Exception
	{
		// TODO Auto-generated method stub
	}
	
	protected void xsuper_help(XScanner currentLine, XBinding binding, XContext context) throws Exception
	{
		XClass xcls = null;
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(binding.xhasClass(paramValue))
							{
								xcls = binding.xgetClass(paramValue);
							}
						}
					}
				}
				else if(paramName.equals(XConstants.THIS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								XBindings bindings = binding.xbindings();
								if(bindings.xcontainsKey(paramValue))
								{
									xcls = xget(paramValue, bindings).xgetClass();
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
				if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(paramName.equals(XConstants.HELP_METHOD))
					{
						if(currentLine.xhasNext())
						{
							method = currentLine.xnext();
						}
					}
				}
			}
			XWriter writer = context.xscriptContext().xgetWriter();
			xsuper_xhelp(xcls, method, writer);
		}
		else
		{
			XWriter writer = context.xscriptContext().xgetWriter();
			for(XClass cls : binding.xgetClasses())
			{
				xsuper_xhelp(cls, "", writer);
			}
		}
	}

	protected void xsuper_xhelp(XClass xcls, String method, XWriter writer) throws Exception
	{
		if(method.isEmpty())
		{
			writer.xwrite(XConstants.CLASS + XConstants.PARAMETER_SEPARATOR + xcls.xgetSimpleName());
			for(XMethod xmethod : xcls.xgetMethods())
			{
				xexecutor_xhelp(xmethod, xcls);
			}
			writer.xwrite(XConstants.FINAL);
		}
		else
		{
			writer.xwrite(XConstants.CLASS + XConstants.PARAMETER_SEPARATOR + xcls.xgetSimpleName());
			for(XMethod xmethod : xcls.xgetMethods())
			{
				if(xmethod.xgetName().equals(method))
					xexecutor_xhelp(xmethod, xcls);
			}
			writer.xwrite(XConstants.FINAL);
		}
	}
	
	protected void xexecutor_xhelp(XMethod xmethod, XClass xcls) throws Exception
	{
		StringBuilder text = new StringBuilder();
		text.append(xmethod.xgetName());
		if(xmethod.xgetModifiers().xisStatic())
		{
			text.append(XConstants.PARAMETER_SEPARATOR);
			text.append(XConstants.PARAMETER_NAME_PREFIX);
			text.append(XConstants.CLASS);
			text.append(XConstants.PARAMETER_SEPARATOR);
			text.append(XConstants.CLASS_REF_PREFIX);
			text.append(xcls.xgetSimpleName());
		}
		else
		{
			text.append(XConstants.PARAMETER_SEPARATOR);
			text.append(XConstants.PARAMETER_NAME_PREFIX);
			text.append(XConstants.THIS);
			text.append(XConstants.PARAMETER_SEPARATOR);
			text.append(XConstants.OBJECT_REF_PREFIX);
			text.append(xcls.xgetSimpleName().toLowerCase());
		}
		
		for(XParameter xparameter : xmethod.xgetParameters())
		{
			text.append(XConstants.PARAMETER_SEPARATOR);
			text.append(XConstants.PARAMETER_NAME_PREFIX);
			text.append(xparameter.xgetName());
			text.append(XConstants.PARAMETER_SEPARATOR);
			text.append(XConstants.CLASS_REF_PREFIX);
			text.append(xparameter.xgetType());
		}
	}
	
	protected void xsuper_log(XScanner currentLine, XBinding bindings, XContext context) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String method = currentLine.xnext();
			if(method.isEmpty() == false)
			{
				xexecutor_xlog(method, currentLine, bindings, context);
			}
		}
	}
	
	protected void xexecutor_xlog(String method, XScanner currentLine, XBinding bindings, XContext context) throws Exception
	{
		XLogger logger = context.xlogger();
		if(method.equals(XConstants.LOG_CONFIG))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						logger.xconfig(msg);
					}
				}
			}
		}
		else if(method.equals(XConstants.LOG_FINE))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						logger.xfine(msg);
					}
				}
			}
		}
		else if(method.equals(XConstants.LOG_FINER))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						logger.xfiner(msg);
					}
				}
			}
		}
		else if(method.equals(XConstants.LOG_FINEST))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						logger.xfinest(msg);
					}
				}
			}
		}
		else if(method.equals(XConstants.LOG_INFO))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						logger.xinfo(msg);
					}
				}
			}
		}
		else if(method.equals(XConstants.LOG_SEVERE))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						logger.xsevere(msg);
					}
				}
			}
		}
		else if(method.equals(XConstants.LOG_WARNING))
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.isEmpty() == false)
				{
					if(currentLine.xhasNext())
					{
						String msg = currentLine.xnext();
						logger.xwarning(msg);
					}
				}
			}
		}
	}
	
	protected XObject xlambda(XScanner scanner, XScript script, XBinding binding, XContext context) throws Exception
	{
		if(scanner.xhasNext())
		{
			String paramName = scanner.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.THIS))
				{
					if(scanner.xhasNext())
					{
						String paramValue = scanner.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								if(!paramValue.isEmpty())
								{
									XEvalTask task = xevalTask(script, binding, context);
									XObject object = binding.xfactory().xObject(new Eval(task));
									binding.xbindings().xput(paramValue, object);
									return object;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	protected XEvalTask xevalTask(XScript script, XBinding binding, XContext context) throws Exception
	{
		XCachedScript cachedScript = XCachedScriptImpl.xnew(script);
		xgoto("", cachedScript);
		cachedScript.xstopCaching();
		cachedScript.xrefresh();
		XEvalTask task = XEvalTaskImpl.xnew(this, cachedScript, binding, context);
		return task;
	}
	
	protected XObject xget(String name, XBindings bindings) throws Exception
	{
		XObject xobject = bindings.xget(name);
		if(xobject != null)
		{
			if(xobject instanceof XFutureObject)
			{
				xobject = ((XFutureObject)xobject).xfuture().xget();
			}
		}
		return xobject;
	}
}
