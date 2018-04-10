package xproject.xscript.impl;

import xproject.xlang.XClassLoader;
import xproject.xrmi.XRemote;
import xproject.xscript.XScriptContext;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xlogging.XLogger;

public interface XContext extends XRemote 
{
	XScriptContext xscriptContext() throws Exception;
	XClassLoader xclassLoader() throws Exception;
	XLogger xlogger() throws Exception;
	XExecutorService xexecutorService() throws Exception;
}
