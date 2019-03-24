package xproject.xscript.impl;

import xproject.xrmi.XRemote;

public interface XFunctionFactory extends XRemote {

	XFunctionImpl xnew(XArguments args, XFunctionImpl parent) throws Exception;
}
