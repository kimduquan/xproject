package xproject.xap.xui;

import xproject.xap.xui.XUIElement;
import xproject.xrmi.XRemote;

public interface XElementContainer<T extends XUIElement> extends XUIElement, XRemote {

	void xadd(T element) throws Exception;
	XElementContainer<T> xgetChildren() throws Exception;
}
