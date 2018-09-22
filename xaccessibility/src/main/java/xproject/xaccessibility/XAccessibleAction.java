package xproject.xaccessibility;

import xproject.xrmi.XRemote;

public interface XAccessibleAction extends XRemote {
	boolean xdoAccessibleAction(int i) throws Exception;
	int xgetAccessibleActionCount() throws Exception;
	String xgetAccessibleActionDescription(int i) throws Exception;
}
