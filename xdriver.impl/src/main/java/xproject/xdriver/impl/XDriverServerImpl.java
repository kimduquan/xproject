package xproject.xdriver.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import xproject.xdriver.impl.error.XExceptionMapper;
import xproject.xdriver.impl.error.XSessionNotCreated;
import xproject.xdriver.impl.model.XPageLoadStrategy;
import xproject.xdriver.impl.model.XSession;
import xproject.xdriver.impl.request.XActions;
import xproject.xdriver.impl.request.XAlert;
import xproject.xdriver.impl.request.XBy;
import xproject.xdriver.impl.request.XCapabilitiesReq;
import xproject.xdriver.impl.request.XCookieRequest;
import xproject.xdriver.impl.request.XFrame;
import xproject.xdriver.impl.request.XKeys;
import xproject.xdriver.impl.request.XScript;
import xproject.xdriver.impl.request.XUrl;
import xproject.xdriver.impl.request.XWindow;
import xproject.xdriver.impl.response.XCookie;
import xproject.xdriver.impl.response.XNoResponse;
import xproject.xdriver.impl.response.XSessionRes;
import xproject.xdriver.impl.response.XStatus;
import xproject.xdriver.impl.response.XResponse;
import xproject.xdriver.impl.response.XWebElement;

public class XDriverServerImpl implements XDriverServer {
	
	private int maximumActiveSessions;
	private List<XSession> activeSessions;

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub

	}
	
	public XDriverServerImpl()
	{
		maximumActiveSessions = -1;
		activeSessions = new ArrayList<XSession>();
	}
	
	protected String convert(InputStream inputStream) throws Exception
	{
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) != -1) {
		    result.write(buffer, 0, length);
		}
		return result.toString();
	}
	
	public XResponse<XSessionRes> xnewSession(XCapabilitiesReq capabilities) throws Exception {
		// TODO Auto-generated method stub
		//3. If the maximum active sessions is equal to the length of the list of active sessions, return response with response code session not created.
		if(maximumActiveSessions == activeSessions.size())
		{
			throw new XSessionNotCreated();
		}
		
		//5. If capabilities's is null, return response with response code session not created.
		if(capabilities == null)
		{
			throw new XSessionNotCreated();
		}
		
		//6. Let session id be the result of generating a UUID.
		UUID sessionId = UUID.randomUUID();
		
		//7. Let session be a new session with the session ID of session id.
		XSession session = new XSession(sessionId.toString());
		
		//8. Set the current session to session.
		XSession currentSession = session;
		
		//9. Append session to active sessions.
		activeSessions.add(session);
		
		/*10. Let body be a JSON Object initialised with:
		 * 
		 * "sessionId"
		 * 		session id
		 * "capabilities"
		 * 		capabilities 
		*/
		XSessionRes body = new XSessionRes();
		
		//11. Initialize the following from capabilities:
		//11.1 Let strategy be the result of getting property "pageLoadStrategy" from capabilities.
		String strategy = capabilities.capabilities.firstMatch[0].pageLoadStrategy;
		
		//11.2 If strategy is a string, set the current session’s page loading strategy to strategy. Otherwise, set the page loading strategy to normal and set a property of capabilities with name "pageLoadStrategy" and value "normal".
		if(strategy != null)
		{
			currentSession.sessionPageLoadingStrategy = XPageLoadStrategy.valueOf(strategy);
		}
		else
		{
			currentSession.sessionPageLoadingStrategy = XPageLoadStrategy.normal;
			capabilities.capabilities.firstMatch[0].pageLoadStrategy = XPageLoadStrategy.normal.toString();
		}
		
		//11.3 Let proxy be the result of getting property "proxy" from capabilities and run the substeps of the first matching statement:
		XProxy proxy = capabilities.capabilities.firstMatch[0].proxy;
		
		//11.4 Let timeouts be the result of getting property "timeouts" from capabilities.
		XTimeouts timeouts = capabilities.capabilities.firstMatch[0].timeouts;
		
		//11.5 If timeouts is a session timeouts configuration object:
		if(timeouts != null)
		{
			//11.5.1 If timeouts has a numeric property with key "implicit", set the current session’s session implicit wait timeout to the value of property "implicit". Otherwise, set the session implicit wait timeout to 0 (zero) milliseconds.
			if(timeouts.implicit != null)
			{
				currentSession.sessionImplicitWaitTimeout = timeouts.implicit;
			}
			else
			{
				currentSession.sessionImplicitWaitTimeout = (long) 0;
			}
			
			//11.5.2 If timeouts has a numeric property with key "pageLoad", set the current session’s session page load timeout to the value of property "pageLoad". Otherwise, set the session page load timeout to 300,000 milliseconds.
			if(timeouts.pageLoad != null)
			{
				currentSession.sessionPageLoadtimeout = timeouts.pageLoad;
			}
			else
			{
				currentSession.sessionPageLoadtimeout = (long) 300000;
			}
			
			//11.5.3 If timeouts has a numeric property with key "script", set the current session’s session script timeout to the value of property "script". Otherwise, set the session script timeout to 30,000 milliseconds.
			if(timeouts.script != null)
			{
				currentSession.sessionScriptTimeout = timeouts.script;
			}
			else
			{
				currentSession.sessionScriptTimeout = (long) 30000;
			}
		}
		
		//15. Return success with data body.
		body.sessionId = sessionId.toString();
		body.capabilities = capabilities.capabilities.firstMatch[0];
		
		XResponse<XSessionRes> success = new XResponse<XSessionRes>(body);
		return success;
	}

	public XNoResponse xdeleteSession(String session_id) throws Exception {
		// TODO Auto-generated method stub
		XSession current = null;
		for(XSession session : activeSessions)
		{
			if(session.sessionID.equals(session_id))
			{
				current = session;
				break;
			}
		}
		
		//2. Remove the current session from active sessions.
		activeSessions.remove(current);
		
		//Return success with data null.
		return new XNoResponse();
	}

	public XResponse<XStatus> xgetStatus() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XTimeouts> xgetTimeouts(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xsetTimeouts(String session_id, XTimeouts timeouts) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xnavigateTo(String session_id, XUrl request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetCurrentUrl(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xback(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xforward(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xrefresh(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetTitle(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetWindowHandle(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String[]> xcloseWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xswitchToWindow(String session_id, XWindow request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String[]> xgetWindowHandles(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xswitchToFrame(String session_id, XFrame request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xswitchToParentFrame(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XRect> xgetWindowRect(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XRect> xsetWindowRect(String session_id, XRect rect) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XRect> xmaximizeWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XRect> xminimizeWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XRect> xfullscreenWindow(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XWebElement> xgetActiveElement(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XWebElement> xfindElement(String session_id, XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XWebElement[]> xfindElements(String session_id, XBy by) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XWebElement> xfindElementFromElement(String session_id, String element_id, XBy by)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XWebElement[]> xfindElementsFromElement(String session_id, String element_id, XBy by)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<Boolean> xisElementSelected(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetElementAttribute(String session_id, String element_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetElementProperty(String session_id, String element_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetElementCssProperty(String session_id, String element_id, String property_name)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetElementText(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetElementTagName(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XRect> xgetElementRect(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<Boolean> xisElementEnabled(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xelementClick(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xelementClear(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xelementSendKeys(String session_id, String element_id, XKeys keys) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetPageSource(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<Object> xexecuteScript(String session_id, XScript script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<Object> xexecuteAsyncScript(String session_id, XScript script) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XCookie[]> xgetAllCookies(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<XCookie> xgetNamedCookie(String session_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xaddCookie(String session_id, XCookieRequest cookie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xdeleteCookie(String session_id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xdeleteAllCookies(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xperformActions(String session_id, XActions actions) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xreleaseActions(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xdismissAlert(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xacceptAlert(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xgetAlertText(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNoResponse xsendAlertText(String session_id, XAlert text) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xtakeScreenshot(String session_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XResponse<String> xtakeElementScreenshot(String session_id, String element_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
		ResourceConfig config = new ResourceConfig(XDriverServerImpl.class);
		config.register(XExceptionMapper.class);
		JdkHttpServerFactory.createHttpServer(baseUri, config);
	}
}
