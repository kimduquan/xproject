package org.kdq.xlang;

public interface XObject {

	String xtoString();
	XObject xclone();
	void xfinalize();
	boolean xequals(XObject obj);
	XClass xgetClass();
	int xhashCode();
	void xnotify();
	void xnotifyAll();
	void xwait();
	void xwait(long timeout);
	void xwait(long timeout, int nanos);
}
