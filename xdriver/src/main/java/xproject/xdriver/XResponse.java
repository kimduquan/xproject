package xproject.xdriver;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XResponse extends XRemote {

	XSession xgetSession() throws Exception;
	String xgetState() throws Exception;
	int xgetStatus() throws Exception;
	XObject xgetValue() throws Exception;
}
