package xproject.xdriver;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XDriverParameter extends XRemote {
	XClass[] xtypes() throws Exception;
	XObject[] values() throws Exception;
}
