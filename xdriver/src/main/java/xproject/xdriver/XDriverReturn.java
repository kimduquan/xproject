package xproject.xdriver;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XDriverReturn extends XRemote {

	XClass xclass() throws Exception;
	XObject xobject() throws Exception;
}
