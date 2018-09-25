package xproject.xdriver.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xproject.xdriver.impl.model.XTimeouts;
import xproject.xdriver.impl.model.XElementIdentifier;
import xproject.xdriver.impl.model.XWindowIdentifier;
import xproject.xdriver.impl.request.*;
import xproject.xdriver.impl.response.*;
import xproject.xrmi.XRemote;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface XDriverServer extends XRemote {

	@POST
	@Path("/session")
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
	XResponse<XSessionInfo> xnewSession(XCapabilitiesReq capabilities) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}")
	XNoResponse xdeleteSession(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/status")
	XResponse<XStatus> xgetStatus() throws Exception;
	
	@GET
	@Path("/session/{session_id}/timeouts")
	XResponse<XTimeouts> xgetTimeouts(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/timeouts")
	XNoResponse xsetTimeouts(@PathParam("session_id") String session_id, XTimeouts timeouts) throws Exception;
	
	@POST
	@Path("/session/{session_id}/url")
	XNoResponse xnavigateTo(@PathParam("session_id") String session_id, XUrl request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/url")
	XResponse<String> xgetCurrentUrl(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/back")
	XNoResponse xback(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/forward")
	XNoResponse xforward(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/refresh")
	XNoResponse xrefresh(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/title")
	XResponse<String> xgetTitle(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window")
	XResponse<XWindowIdentifier> xgetWindowHandle(@PathParam("session_id") String session_id) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/window")
	String xcloseWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window")
	XNoResponse xswitchToWindow(@PathParam("session_id") String session_id, XWindow request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window/handles")
	String xgetWindowHandles(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/frame")
	XNoResponse xswitchToFrame(@PathParam("session_id") String session_id, XFrame request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/frame/parent")
	XNoResponse xswitchToParentFrame(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window/rect")
	XResponse<XRect> xgetWindowRect(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/rect")
	XResponse<XRect> xsetWindowRect(@PathParam("session_id") String session_id, XRect rect) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/maximize")
	XResponse<XRect> xmaximizeWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/minimize")
	XResponse<XRect> xminimizeWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/fullscreen")
	XResponse<XRect> xfullscreenWindow(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/active")
	XResponse<XElementIdentifier> xgetActiveElement(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element")
	XResponse<XElementIdentifier> xfindElement(@PathParam("session_id") String session_id, XBy by) throws Exception;
	
	@POST
	@Path("/session/{session_id}/elements")
	String xfindElements(@PathParam("session_id") String session_id, XBy by) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/element")
	XResponse<XElementIdentifier> xfindElementFromElement(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, XBy by) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/elements")
	String xfindElementsFromElement(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, XBy by) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/selected")
	XResponse<Boolean> xisElementSelected(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/attribute/{name}")
	XResponse<String> xgetElementAttribute(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("name") String name) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/property/{name}")
	XResponse<String> xgetElementProperty(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("name") String name) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/css/{property_name}")
	XResponse<String> xgetElementCssProperty(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("property_name") String property_name) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/text")
	XResponse<String> xgetElementText(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/name")
	XResponse<String> xgetElementTagName(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/rect")
	XResponse<XRect> xgetElementRect(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/enabled")
	XResponse<Boolean> xisElementEnabled(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/click")
	XNoResponse xelementClick(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/clear")
	XNoResponse xelementClear(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/value")
	XNoResponse xelementSendKeys(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, XKeys keys) throws Exception;
	
	@GET
	@Path("/session/{session_id}/source")
	XResponse<String> xgetPageSource(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/execute/sync")
	XResponse<Object> xexecuteScript(@PathParam("session_id") String session_id, XScript script) throws Exception;
	
	@POST
	@Path("/session/{session_id}/execute/async")
	XResponse<Object> xexecuteAsyncScript(@PathParam("session_id") String session_id, XScript script) throws Exception;
	
	@GET
	@Path("/session/{session_id}/cookie")
	String xgetAllCookies(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/cookie/{name}")
	XResponse<XCookie> xgetNamedCookie(@PathParam("session_id") String session_id, @PathParam("name") String name) throws Exception;
	
	@POST
	@Path("/session/{session_id}/cookie")
	XNoResponse xaddCookie(@PathParam("session_id") String session_id, XCookieRequest cookie) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/cookie/{name}")
	XNoResponse xdeleteCookie(@PathParam("session_id") String session_id, @PathParam("name") String name) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/cookie")
	XNoResponse xdeleteAllCookies(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/actions")
	XNoResponse xperformActions(@PathParam("session_id") String session_id, XActions actions) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/actions")
	XNoResponse xreleaseActions(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/dismiss")
	XNoResponse xdismissAlert(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/accept")
	XNoResponse xacceptAlert(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/alert/text")
	XResponse<String> xgetAlertText(@PathParam("session_id") String session_id) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/text")
	XNoResponse xsendAlertText(@PathParam("session_id") String session_id, XAlert text) throws Exception;
	
	@GET
	@Path("/session/{session_id}/screenshot")
	XResponse<String> xtakeScreenshot(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/screenshot")
	XResponse<String> xtakeElementScreenshot(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id) throws Exception;
	 
}
