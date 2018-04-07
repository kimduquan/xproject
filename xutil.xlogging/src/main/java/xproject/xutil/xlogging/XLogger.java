package xproject.xutil.xlogging;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XLogger extends XRemote 
{
	void xconfig(String msg) throws Exception;
	void xentering(String sourceClass, String sourceMethod);
	void xentering(String sourceClass, String sourceMethod, XObject[] params);
	void xexiting(String sourceClass, String sourceMethod);
	void xexiting(String sourceClass, String sourceMethod, XObject result);
	void xfine(String msg);
	void xfiner(String msg);
	void xfinest(String msg);
	String xgetName();
	XLogger xgetParent();
	void xinfo(String msg);
	void xsevere(String msg);
	void xwarning(String msg);
}
