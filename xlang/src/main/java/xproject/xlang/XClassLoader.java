package xproject.xlang;

import xproject.xrmi.XRemote;

public interface XClassLoader extends XRemote {

	XClass xloadClass(String name) throws Exception;
}
