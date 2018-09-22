package xproject.xscript.impl;

import xproject.xrmi.XRemote;

public interface XBlockFactory extends XRemote {

	XTry xtry(XScript script, XContext context, XBinding binding) throws Exception;
}
