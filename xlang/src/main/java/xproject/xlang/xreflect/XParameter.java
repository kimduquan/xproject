package xproject.xlang.xreflect;

import xproject.xlang.XClass;
import xproject.xrmi.XRemote;

public interface XParameter extends XRemote {

	String xgetName() throws Exception;
	XClass xgetType() throws Exception;
}
