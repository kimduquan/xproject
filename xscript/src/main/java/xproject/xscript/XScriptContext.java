package xproject.xscript;

import xproject.xio.XWriter;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xutil.XScanner;

public interface XScriptContext extends XRemote {

	XObject xgetAttribute(String name) throws Exception;
	XBindings xgetBindings(int scope) throws Exception;
	XWriter xgetWriter() throws Exception;
	XScanner xgetReader() throws Exception;
	
	public static final int XENGINE_SCOPE = 100;
	public static final int XGLOBAL_SCOPE = 200;
}
