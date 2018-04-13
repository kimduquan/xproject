package xproject.xscript.impl;

import xproject.xlang.XClassLoader;
import xproject.xscript.XScriptContext;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xlogging.XLogger;

public class XContextImpl implements XContext {

	private XScriptContext xscriptContext;
	private XClassLoader xclassLoader;
	private XLogger xlogger;
	private XExecutorService xexecutorService;
	
	protected XContextImpl(XScriptContext scriptContext, XClassLoader classLoader, XLogger logger, XExecutorService executorService)
	{
		xclassLoader = classLoader;
		xexecutorService = executorService;
		xlogger = logger;
		xscriptContext = scriptContext;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xscriptContext = null;
		xclassLoader = null;
		xlogger = null;
		xexecutorService = null;
		finalize();
	}

	@Override
	public XScriptContext xscriptContext() throws Exception {
		// TODO Auto-generated method stub
		return xscriptContext;
	}

	@Override
	public XClassLoader xclassLoader() throws Exception {
		// TODO Auto-generated method stub
		return xclassLoader;
	}

	@Override
	public XLogger xlogger() throws Exception {
		// TODO Auto-generated method stub
		return xlogger;
	}

	@Override
	public XExecutorService xexecutorService() throws Exception {
		// TODO Auto-generated method stub
		return xexecutorService;
	}

	public static XContext xnew(XScriptContext scriptContext, XClassLoader classLoader, XLogger logger, XExecutorService executorService)
	{
		return new XContextImpl(scriptContext, classLoader, logger, executorService);
	}
}
