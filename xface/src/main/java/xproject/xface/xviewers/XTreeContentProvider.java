package xproject.xface.xviewers;

import xproject.xlang.XObject;

public interface XTreeContentProvider extends XContentProvider {
	void xinputChanged(XViewer viewer, XObject oldInput, XObject newInput) throws Exception;
	void xdispose() throws Exception;
	XObject[] xgetElements(XObject parent) throws Exception;
	XObject[] xgetChildren(XObject parentElement) throws Exception;
	XObject xgetParent(XObject element) throws Exception;
	boolean xhasChildren(XObject element) throws Exception;
}
