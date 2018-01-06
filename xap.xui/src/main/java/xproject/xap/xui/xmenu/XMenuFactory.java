package xproject.xap.xui.xmenu;

import xproject.xrmi.XRemote;

public interface XMenuFactory extends XRemote {

	XDirectMenuItem xcreateDirectMenuItem() throws Exception;
	XMenu xcreateMenu() throws Exception;
}
