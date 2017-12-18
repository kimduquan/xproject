package xproject.xlang;

import xproject.xrmi.XRemote;

public interface XPackage extends XRemote {

	String xgetName() throws Exception;
}
