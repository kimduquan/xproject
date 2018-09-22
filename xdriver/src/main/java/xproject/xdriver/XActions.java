package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XActions extends XRemote {

	XActions xbuild() throws Exception;
	XActions xclick() throws Exception;
	XActions xclick(XElement target) throws Exception;
	XActions xclickAndHold() throws Exception;
	XActions xclickAndHold(XElement target) throws Exception;
	XActions xcontextClick() throws Exception;
	XActions xcontextClick(XElement target) throws Exception;
	XActions xdoubleClick() throws Exception;
	XActions xdoubleClick(XElement target) throws Exception;
	XActions xdragAndDrop(XElement source, XElement target) throws Exception;
	XActions xdragAndDropBy(XElement source, int xOffset, int yOffset) throws Exception;
	XActions xkeyDown(CharSequence key) throws Exception;
	XActions xkeyDown(XElement target, CharSequence key) throws Exception;
	XActions xkeyUp(CharSequence key) throws Exception;
	XActions xkeyUp(XElement target, CharSequence key) throws Exception;
	XActions xmoveByOffset(int xOffset, int yOffset) throws Exception;
	XActions xmoveToElement(XElement target) throws Exception;
	XActions xmoveToElement(XElement target, int xOffset, int yOffset) throws Exception;
	XActions xpause(long duration) throws Exception;
	void xperform() throws Exception;
	XActions xrelease() throws Exception;
	XActions xrelease(XElement target) throws Exception;
	XActions xsendKeys(CharSequence... keys) throws Exception;
	XActions xsendKeys(XElement target, CharSequence... keys) throws Exception;
}
