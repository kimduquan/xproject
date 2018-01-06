package xproject.xap.xui.xmenu;

import xproject.xap.xui.XUIElement;
import xproject.xrmi.XRemote;

public interface XMenuElement extends XRemote, XUIElement {

	String xgetLabel() throws Exception;
	void xsetLabel(String label) throws Exception;
}
