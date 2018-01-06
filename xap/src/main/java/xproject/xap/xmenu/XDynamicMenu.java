package xproject.xap.xmenu;

import java.util.List;

import xproject.xap.xui.xmenu.XMenuElement;
import xproject.xrmi.XRemote;

public interface XDynamicMenu extends XRemote {

	void xaboutToShow(List<XMenuElement> items) throws Exception;
	void xaboutToHide(List<XMenuElement> items) throws Exception;
}
