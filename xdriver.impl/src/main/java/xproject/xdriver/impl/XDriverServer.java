package xproject.xdriver.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xproject.xdriver.impl.request.*;
import xproject.xdriver.impl.response.*;
import xproject.xrmi.XRemote;

@Path("/")
public interface XDriverServer extends XRemote {

	@POST
	@Path("/session")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/*
	 * {
		  "desiredCapabilities": {
		    "browserName": "MicrosoftEdge",
		    "version": "",
		    "platform": "WINDOWS"
		  },
		  "capabilities": {
		    "firstMatch": [
		      {
		        "browserName": "MicrosoftEdge",
		        "platformName": "windows"
		      }
		    ]
		  }
		}
	 */
	XSessionRes xnewSession(XCapabilitiesReq capabilities) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}")
	void xdeleteSession(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	XStatus xgetStatus() throws Exception;
	
	@GET
	@Path("/session/{session_id}/timeouts")
	@Produces(MediaType.APPLICATION_JSON)
	XTimeouts xgetTimeouts(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/timeouts")
	@Consumes(MediaType.APPLICATION_JSON)
	void xsetTimeouts(@PathParam("session_id") String session_id, XTimeouts timeouts) throws Exception;
	
	@POST
	@Path("/session/{session_id}/url")
	@Consumes(MediaType.APPLICATION_JSON)
	void xnavigateTo(@PathParam("session_id") String session_id, XUrl request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/url")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetCurrentUrl(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/back")
	void xback(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/forward")
	void xforward(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/refresh")
	void xrefresh(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/title")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetTitle(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetWindowHandle(@PathParam("session_id") String session_id) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/window")
	@Produces(MediaType.APPLICATION_JSON)
	String[] xcloseWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window")
	@Consumes(MediaType.APPLICATION_JSON)
	void xswitchToWindow(@PathParam("session_id") String session_id, XWindow request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window/handles")
	@Produces(MediaType.APPLICATION_JSON)
	String[] xgetWindowHandles(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/frame")
	@Consumes(MediaType.APPLICATION_JSON)
	void xswitchToFrame(@PathParam("session_id") String session_id, XFrame request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/frame/parent")
	void xswitchToParentFrame(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window/rect")
	XRect xgetWindowRect(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/rect")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	XRect xsetWindowRect(@PathParam("session_id") String session_id, XRect rect) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/maximize")
	@Produces(MediaType.APPLICATION_JSON)
	XRect xmaximizeWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/minimize")
	@Produces(MediaType.APPLICATION_JSON)
	XRect xminimizeWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/fullscreen")
	@Produces(MediaType.APPLICATION_JSON)
	XRect xfullscreenWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/active")
	@Produces(MediaType.APPLICATION_JSON)
	XWebElement xgetActiveElement(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	XWebElement xfindElement(@PathParam("session_id") String session_id, XBy by) throws Exception;
	
	@POST
	@Path("/session/{session_id}/elements")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	XWebElement[] xfindElements(@PathParam("session_id") String session_id, XBy by) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/element")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	XWebElement xfindElementFromElement(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, XBy by) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/elements")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	XWebElement[] xfindElementsFromElement(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, XBy by) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/selected")
	@Produces(MediaType.APPLICATION_JSON)
	boolean xisElementSelected(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/attribute/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetElementAttribute(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("name") String name) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/property/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetElementProperty(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("name") String name) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/css/{property_name}")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetElementCssProperty(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("property_name") String property_name) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/text")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetElementText(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/name")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetElementTagName(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/rect")
	@Produces(MediaType.APPLICATION_JSON)
	XRect xgetElementRect(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/enabled")
	@Produces(MediaType.APPLICATION_JSON)
	boolean xisElementEnabled(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/click")
	void xelementClick(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/clear")
	void xelementClear(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/value")
	@Consumes(MediaType.APPLICATION_JSON)
	void xelementSendKeys(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, XKeys keys) throws Exception;
	
	@GET
	@Path("/session/{session_id}/source")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetPageSource(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/execute/sync")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Object xexecuteScript(@PathParam("session_id") String session_id, XScript script) throws Exception;
	
	@POST
	@Path("/session/{session_id}/execute/async")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Object xexecuteAsyncScript(@PathParam("session_id") String session_id, XScript script) throws Exception;
	
	@GET
	@Path("/session/{session_id}/cookie")
	@Produces(MediaType.APPLICATION_JSON)
	XCookie[] xgetAllCookies(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/cookie/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	XCookie xgetNamedCookie(@PathParam("session_id") String session_id, @PathParam("name") String name) throws Exception;
	
	@POST
	@Path("/session/{session_id}/cookie")
	@Consumes(MediaType.APPLICATION_JSON)
	void xaddCookie(@PathParam("session_id") String session_id, XCookieRequest cookie) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/cookie/{name}")
	void xdeleteCookie(@PathParam("session_id") String session_id, @PathParam("name") String name) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/cookie")
	void xdeleteAllCookies(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/actions")
	@Consumes(MediaType.APPLICATION_JSON)
	void xperformActions(@PathParam("session_id") String session_id, XActions actions) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/actions")
	void xreleaseActions(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/dismiss")
	void xdismissAlert(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/accept")
	void xacceptAlert(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/alert/text")
	@Produces(MediaType.TEXT_PLAIN)
	String xgetAlertText(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/text")
	@Consumes(MediaType.APPLICATION_JSON)
	void xsendAlertText(@PathParam("session_id") String session_id, XAlert text) throws Exception;
	
	@GET
	@Path("/session/{session_id}/screenshot")
	@Produces(MediaType.TEXT_PLAIN)
	String xtakeScreenshot(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/screenshot")
	@Produces(MediaType.TEXT_PLAIN)
	String xtakeElementScreenshot(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	 
}
