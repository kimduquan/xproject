package xproject.xscript.impl;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XDebugger extends XRemote {

	void xrun() throws Exception;
	void xcont() throws Exception;
	void xprint(XObject object) throws Exception;
	void xdump(XObject object) throws Exception;
	void xstop(long at) throws Exception;
	void xstep() throws Exception;
	void xclear(long at) throws Exception;
	void xnext() throws Exception;
	void xstop() throws Exception;
	void xclear() throws Exception;
	void xcatch() throws Exception;
	void xignore() throws Exception;
}
