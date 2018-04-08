package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;

public interface XEngine extends XRemote {

	XObject xeval(XScript script, XBindings bindings, XContext context) throws Exception;
}
