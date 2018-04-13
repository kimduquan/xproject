package xproject.xscript.impl;

import xproject.xio.XWriter;
import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XFuture;
import xproject.xutil.xlogging.XLogger;

public interface XScriptFactory extends XRemote {

	XContext xContext(XScriptContext scriptContext, XClassLoader classLoader, XLogger logger, XExecutorService executorService) throws Exception;
	XBinding xBinding(XBindings bindings, XFactory factory) throws Exception;
	XBindings xBindings() throws Exception;
	XCachedScript xCachedScript(XScript script) throws Exception;
	XScript xScript(XScanner scanner) throws Exception;
	XLine xLine(long number, XScanner scanner) throws Exception;
	XFutureObject xFutureObject(XFuture future) throws Exception;
	XEvalTask xEvalTask(XEngine engine, XScript script, XBinding binding, XContext context) throws Exception;
	XScriptContext xScriptContext(XBindings e, XBindings g, XWriter writer, XScanner reader, XWriter errorWriter) throws Exception;
	XScriptEngine xScriptEngine(XScriptContext scriptContext, XBindings bindings, XScriptFactory factory) throws Exception;
}
