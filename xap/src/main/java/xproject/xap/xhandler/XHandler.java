package xproject.xap.xhandler;

import xproject.xrmi.XRemote;

public interface XHandler extends XRemote {

	boolean xcanExecute() throws Exception;
	void xexecute() throws Exception;
}
