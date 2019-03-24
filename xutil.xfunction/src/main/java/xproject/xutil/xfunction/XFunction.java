package xproject.xutil.xfunction;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XFunction extends XRemote 
{
	XObject xapply(XObject t) throws Exception;
}
