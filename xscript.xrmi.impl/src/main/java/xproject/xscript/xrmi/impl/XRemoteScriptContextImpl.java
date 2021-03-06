package xproject.xscript.xrmi.impl;

import xproject.xio.XWriter;
import xproject.xlang.XObject;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xutil.XScanner;

public class XRemoteScriptContextImpl extends XUnicastRemoteObject<XScriptContext> implements XScriptContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XRemoteScriptContextImpl(XScriptContext ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public XObject xgetAttribute(String name) throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetAttribute(name);
	}

	public XBindings xgetBindings(int scope) throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetBindings(scope);
	}

	public static XScriptContext xnew(XScriptContext ref) throws Exception
	{
		return new XRemoteScriptContextImpl(ref);
	}

	public XWriter xgetWriter() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetWriter();
	}

	public XScanner xgetReader() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetReader();
	}

	@Override
	public XWriter xgetErrorWriter() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetErrorWriter();
	}
}
