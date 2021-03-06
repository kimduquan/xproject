package xproject.xscript;

import java.util.Set;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XBindings extends XRemote {

	XObject xget(String key) throws Exception;
	XObject xput(String name, XObject object) throws Exception;
	boolean xcontainsKey(String key) throws Exception;
	void xremove(String key) throws Exception;
	Set<String> xkeySet() throws Exception;
}
