package xproject.xdriver.impl;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

import xproject.xdriver.impl.request.XActions;
import xproject.xdriver.impl.request.XAlert;
import xproject.xdriver.impl.request.XBy;
import xproject.xdriver.impl.request.XCookieRequest;
import xproject.xdriver.impl.request.XFrame;
import xproject.xdriver.impl.request.XKeys;
import xproject.xdriver.impl.request.XScript;
import xproject.xdriver.impl.request.XUrl;
import xproject.xdriver.impl.request.XWindow;
import xproject.xdriver.impl.response.XCookie;
import xproject.xdriver.impl.response.XSession;
import xproject.xdriver.impl.response.XStatus;
import xproject.xdriver.impl.response.XWebElement;

public class XDriverServerImpl implements XDriverServer {

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub

	}

	public XSession xnewSession(XCapabilities capabilities) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xdeleteSession(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public XStatus xgetStatus() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XTimeouts xgetTimeouts(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xsetTimeouts(String session_id, XTimeouts timeouts) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xnavigateTo(String session_id, XUrl request) throws Exception {
		// TODO Auto-generated method stub

	}

	public String xgetCurrentUrl(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xback(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xforward(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xrefresh(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public String xgetTitle(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String xgetWindowHandle(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] xcloseWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xswitchToWindow(String session_id, XWindow request) throws Exception {
		// TODO Auto-generated method stub

	}

	public String[] xgetWindowHandles(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xswitchToFrame(String session_id, XFrame request) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xswitchToParentFrame(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public XRect xgetWindowRect(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XRect xsetWindowRect(String session_id, XRect rect) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XRect xmaximizeWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XRect xminimizeWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XRect xfullscreenWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XWebElement xgetActiveElement(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XWebElement xfindElement(String session_id, XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XWebElement[] xfindElements(String session_id, XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XWebElement xfindElementFromElement(String session_id, String element_id, XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XWebElement[] xfindElementsFromElement(String session_id, String element_id, XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean xisElementSelected(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public String xgetElementAttribute(String session_id, String element_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String xgetElementProperty(String session_id, String element_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String xgetElementCssProperty(String session_id, String element_id, String property_name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String xgetElementText(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String xgetElementTagName(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XRect xgetElementRect(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean xisElementEnabled(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public void xelementClick(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xelementClear(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xelementSendKeys(String session_id, String element_id, XKeys keys) throws Exception {
		// TODO Auto-generated method stub

	}

	public String xgetPageSource(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Object xexecuteScript(String session_id, XScript script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Object xexecuteAsyncScript(String session_id, XScript script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XCookie[] xgetAllCookies(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XCookie xgetNamedCookie(String session_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xaddCookie(String session_id, XCookieRequest cookie) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xdeleteCookie(String session_id, String name) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xdeleteAllCookies(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xperformActions(String session_id, XActions actions) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xreleaseActions(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xdismissAlert(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public void xacceptAlert(String session_id) throws Exception {
		// TODO Auto-generated method stub

	}

	public String xgetAlertText(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xsendAlertText(String session_id, XAlert text) throws Exception {
		// TODO Auto-generated method stub

	}

	public String xtakeScreenshot(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String xtakeElementScreenshot(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
		ResourceConfig config = new ResourceConfig(XDriverServerImpl.class);
		JdkHttpServerFactory.createHttpServer(baseUri, config);
	}

}
