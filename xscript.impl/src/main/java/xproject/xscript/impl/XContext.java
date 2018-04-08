package xproject.xscript.impl;

import xproject.xio.XWriter;
import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xrmi.XRemote;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xlogging.XLogger;

public interface XContext extends XRemote {

	XClassLoader xclassLoader() throws Exception;
	XFactory xfactory() throws Exception;
	XWriter xwriter() throws Exception;
	XLogger xlogger() throws Exception;
	XExecutorService xexecutorService() throws Exception;
	
	void ximport(String key, XClass xclass) throws Exception;
	XClass xgetClass(String key) throws Exception;
	XClass[] xgetClasses() throws Exception;
	boolean xhasClass(String key) throws Exception;
}
