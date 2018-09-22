package xproject.xaccessibility;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XAccessibleKeyBinding extends XRemote {
	XObject xgetAccessibleKeyBinding(int i) throws Exception;
	int xgetAccessibleKeyBindingCount() throws Exception;
}
