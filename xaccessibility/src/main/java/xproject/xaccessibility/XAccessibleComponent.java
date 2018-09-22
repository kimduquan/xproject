package xproject.xaccessibility;

import xproject.xrmi.XRemote;
import xproject.xwt.XColor;
import xproject.xwt.XCursor;
import xproject.xwt.XDimension;
import xproject.xwt.XFont;
import xproject.xwt.XFontMetrics;
import xproject.xwt.XPoint;
import xproject.xwt.XRectangle;

public interface XAccessibleComponent extends XRemote 
{
	void xaddFocusListener(XFocusListener l) throws Exception;
	boolean xcontains(XPoint p) throws Exception;
	XAccessible xgetAccessibleAt(XPoint p) throws Exception;
	XColor xgetBackground() throws Exception;
	XRectangle xgetBounds() throws Exception;
	XCursor xgetCursor() throws Exception;
	XFont xgetFont() throws Exception;
	XFontMetrics xgetFontMetrics(XFont f) throws Exception;
	XColor xgetForeground() throws Exception;
	XPoint xgetLocation() throws Exception;
	XPoint xgetLocationOnScreen() throws Exception;
	XDimension xgetSize() throws Exception;
	boolean xisEnabled() throws Exception;
	boolean xisFocusTraversable() throws Exception;
	boolean xisShowing() throws Exception;
	boolean xisVisible() throws Exception;
	void xremoveFocusListener(XFocusListener l) throws Exception;
	void xrequestFocus() throws Exception;
	void xsetBackground(XColor c) throws Exception;
	void xsetBounds(XRectangle r) throws Exception;
	void xsetCursor(XCursor cursor) throws Exception;
	void xsetEnabled(boolean b) throws Exception;
	void xsetFont(XFont f) throws Exception;
	void xsetForeground(XColor c) throws Exception;
	void xsetLocation(XPoint p) throws Exception;
	void xsetSize(XDimension d) throws Exception;
	void xsetVisible(boolean b) throws Exception;
}
