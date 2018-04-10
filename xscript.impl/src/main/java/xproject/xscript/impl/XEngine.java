package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XEngine extends XRemote {

	XObject xeval(XScript script, XBinding binding, XContext context) throws Exception;
}
