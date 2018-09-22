package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XMouse extends XRemote {

	void xclick(XCoordinates where) throws Exception;
	void xcontextClick(XCoordinates where) throws Exception;
	void xdoubleClick(XCoordinates where) throws Exception;
	void xmouseDown(XCoordinates where) throws Exception;
	void xmouseMove(XCoordinates where) throws Exception;
	void xmouseMove(XCoordinates where, long xOffset, long yOffset);
	void xmouseUp(XCoordinates where) throws Exception;
}
