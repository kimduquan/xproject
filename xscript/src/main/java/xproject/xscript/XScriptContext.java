package xproject.xscript;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XScriptContext extends XRemote {

	XObject xgetAttribute(String name) throws Exception;
	XBindings xgetBindings(int scope) throws Exception;
	
	public static final int XENGINE_SCOPE = 100;
	public static final int XGLOBAL_SCOPE = 200;
}
