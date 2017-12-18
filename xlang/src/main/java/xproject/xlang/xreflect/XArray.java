package xproject.xlang.xreflect;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XArray extends XRemote, XObject {

	XObject xget(int index) throws Exception;
	void xset(int index, XObject object) throws Exception;
	int xgetLength() throws Exception;
}
