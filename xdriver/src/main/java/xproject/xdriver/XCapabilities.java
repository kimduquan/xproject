package xproject.xdriver;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XCapabilities extends XRemote {

	XObject xgetCapability(String capabilityName) throws Exception;
}
