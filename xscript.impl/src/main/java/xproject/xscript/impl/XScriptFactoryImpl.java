package xproject.xscript.impl;

import xproject.xio.XWriter;
import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xutil.XScanner;
import xproject.xutil.xconcurrent.XExecutorService;
import xproject.xutil.xconcurrent.XFuture;
import xproject.xutil.xlogging.XLogger;

public class XScriptFactoryImpl implements XScriptFactory {

	protected XScriptFactoryImpl()
	{
		
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}

	@Override
	public XBinding xBinding(XBindings bindings, XFactory factory) throws Exception {
		// TODO Auto-generated method stub
		return XBindingImpl.xnew(bindings, factory);
	}

	@Override
	public XBindings xBindings() throws Exception {
		// TODO Auto-generated method stub
		return XBindingsImpl.xnew();
	}

	@Override
	public XCachedScript xCachedScript(XScript script) throws Exception {
		// TODO Auto-generated method stub
		return XCachedScriptImpl.xnew(script);
	}

	@Override
	public XScript xScript(XScanner scanner) throws Exception {
		// TODO Auto-generated method stub
		return XScriptImpl.xnew(scanner, this);
	}

	@Override
	public XLine xLine(long number, XScanner scanner) throws Exception {
		// TODO Auto-generated method stub
		return XLineImpl.xnew(number, scanner);
	}

	@Override
	public XFutureObject xFutureObject(XFuture future) throws Exception {
		// TODO Auto-generated method stub
		return XFutureObjectImpl.xnew(future);
	}

	@Override
	public XContext xContext(XScriptContext scriptContext, XClassLoader classLoader, XLogger logger,
			XExecutorService executorService) throws Exception {
		// TODO Auto-generated method stub
		return XContextImpl.xnew(scriptContext, classLoader, logger, executorService);
	}

	@Override
	public XEvalTask xEvalTask(XEngine engine, XScript script, XBinding binding, XContext context) throws Exception {
		// TODO Auto-generated method stub
		return XEvalTaskImpl.xnew(engine, script, binding, context);
	}

	@Override
	public XScriptContext xScriptContext(XBindings e, XBindings g, XWriter writer, XScanner reader, XWriter errorWriter)
			throws Exception {
		// TODO Auto-generated method stub
		return XScriptContextImpl.xnew(e, g, writer, reader, errorWriter);
	}

	public static XScriptFactory xnew()
	{
		return new XScriptFactoryImpl();
	}

	@Override
	public XScriptEngine xScriptEngine(XScriptContext scriptContext, XBindings bindings, XScriptFactory factory)
			throws Exception {
		// TODO Auto-generated method stub
		return XScriptEngineImpl.xnew(scriptContext, bindings, factory);
	}
}
