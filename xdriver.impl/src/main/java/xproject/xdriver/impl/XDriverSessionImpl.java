package xproject.xdriver.impl;

import xproject.xdriver.impl.model.XElementIdentifier;
import xproject.xdriver.impl.model.XTimeouts;
import xproject.xdriver.impl.model.XWindowIdentifier;
import xproject.xdriver.impl.request.XActions;
import xproject.xdriver.impl.request.XAlert;
import xproject.xdriver.impl.request.XBy;
import xproject.xdriver.impl.request.XCookieRequest;
import xproject.xdriver.impl.request.XFrame;
import xproject.xdriver.impl.request.XScript;
import xproject.xdriver.impl.request.XUrl;
import xproject.xdriver.impl.request.XWindow;
import xproject.xdriver.impl.response.XCookie;
import xproject.xdriver.impl.response.XNoResponse;
import xproject.xdriver.impl.response.XResponse;
import xproject.xdriver.impl.response.XStatus;

public class XDriverSessionImpl implements XDriverSession {

	@Override
	public XNoResponse xdeleteSession() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XStatus> xgetStatus() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XTimeouts> xgetTimeouts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xsetTimeouts(XTimeouts timeouts) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xnavigateTo(XUrl request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<String> xgetCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xback() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xforward() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xrefresh() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<String> xgetTitle() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XWindowIdentifier> xgetWindowHandle() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String xcloseWindow() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xswitchToWindow(XWindow request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String xgetWindowHandles() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xswitchToFrame(XFrame request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xswitchToParentFrame() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XRect> xgetWindowRect() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XRect> xsetWindowRect(XRect rect) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XRect> xmaximizeWindow() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XRect> xminimizeWindow() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XRect> xfullscreenWindow() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XElementIdentifier> xgetActiveElement() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XElementIdentifier> xfindElement(XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String xfindElements(XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XDriverElement xgetElement(String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<String> xgetPageSource(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<Object> xexecuteScript(String session_id, XScript script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<Object> xexecuteAsyncScript(String session_id, XScript script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String xgetAllCookies(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<XCookie> xgetNamedCookie(String session_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xaddCookie(String session_id, XCookieRequest cookie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xdeleteCookie(String session_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xdeleteAllCookies(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xperformActions(String session_id, XActions actions) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xreleaseActions(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xdismissAlert(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xacceptAlert(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<String> xgetAlertText(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XNoResponse xsendAlertText(String session_id, XAlert text) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<String> xtakeScreenshot(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XResponse<String> xtakeElementScreenshot(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
