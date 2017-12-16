package xproject.xlang.xreflect;

import xproject.xlang.XObject;

public interface XArray {

	XObject xget(int index);
	void xset(int index, XObject object);
	int xgetLength();
}
