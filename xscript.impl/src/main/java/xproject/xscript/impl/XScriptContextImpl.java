package xproject.xscript.impl;

import xproject.xio.XWriter;
import xproject.xlang.XObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xutil.XScanner;

public class XScriptContextImpl implements XScriptContext 
{
	private XBindings engine;
	private XBindings global;
	private XWriter xwriter;
	private XScanner xreader;
	private XWriter xerrorWriter;
	
	protected XScriptContextImpl(XBindings e, XBindings g, XWriter writer, XScanner reader, XWriter errorWriter)
	{
		engine = e;
		global = g;
		xwriter = writer;
		xreader = reader;
		xerrorWriter = errorWriter;
	}
	
	public XObject xgetAttribute(String name) throws Exception {
		// TODO Auto-generated method stub
		return XObject.xnull;
	}

	public XBindings xgetBindings(int scope) throws Exception {
		// TODO Auto-generated method stub
		if(scope == XScriptContext.XENGINE_SCOPE)
			return engine;
		if(scope == XScriptContext.XGLOBAL_SCOPE)
			return global;
		
		return null;
	}
	
	public static XScriptContext xnew(XBindings e, XBindings g, XWriter writer, XScanner reader, XWriter errorWriter)
	{
		return new XScriptContextImpl(e, g, writer, reader, errorWriter);
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		engine = null;
		global = null;
		finalize();
	}

	public XWriter xgetWriter() throws Exception {
		// TODO Auto-generated method stub
		return xwriter;
	}

	public XScanner xgetReader() throws Exception {
		// TODO Auto-generated method stub
		return xreader;
	}

	@Override
	public XWriter xgetErrorWriter() throws Exception {
		// TODO Auto-generated method stub
		return xerrorWriter;
	}
}
