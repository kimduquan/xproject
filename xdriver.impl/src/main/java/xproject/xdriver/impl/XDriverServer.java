package xproject.xdriver.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import xproject.xdriver.impl.request.*;
import xproject.xdriver.impl.response.*;
import xproject.xrmi.XRemote;

public interface XDriverServer extends XRemote {

	@POST
	@Path("/session")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	NewSession xnewSession(XCapabilities capabilities) throws Exception;
	
	@DELETE
	@Path("//session/{session_id}")
	void xdeleteSession(@PathParam("session_id") String session_id) throws Exception;
	
	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	GetStatus xgetStatus() throws Exception;
	
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
	void xnavigateTo(@PathParam("session_id") String session_id, NavigateTo request) throws Exception;
	
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
	void xswitchToWindow(@PathParam("session_id") String session_id, SwitchToWindow request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window/handles")
	@Produces(MediaType.APPLICATION_JSON)
	String[] xgetWindowHandles(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/frame")
	@Consumes(MediaType.APPLICATION_JSON)
	void xswitchToFrame(@PathParam("session_id") String session_id, SwitchToFrame request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/frame/parent")
	Response xswitchToParentFrame(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/window/rect")
	Response xgetWindowRect(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/rect")
	Response xsetWindowRect(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/maximize")
	Response xmaximizeWindow(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/minimize")
	Response xminimizeWindow(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/window/fullscreen")
	Response xfullscreenWindow(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/active")
	Response xgetActiveElement(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element")
	Response xfindElement(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/elements")
	Response xfindElements(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/element")
	Response xfindElementFromElement(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/elements")
	Response xfindElementsFromElement(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/selected")
	Response xisElementSelected(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/attribute/{name}")
	Response xgetElementAttribute(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("name") String name, Request request) throws Exception;
	
	@GET
	@Path("/session/{session id}/element/{element id}/property/{name}")
	Response xgetElementProperty(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("name") String name, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/css/{property_name}")
	Response xgetElementCssProperty(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, @PathParam("property_name") String property_name, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/text")
	Response xgetElementText(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/name")
	Response xgetElementTagName(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/rect")
	Response xgetElementRect(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/enabled")
	Response xisElementEnabled(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/click")
	Response xelementClick(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/clear")
	Response xelementClear(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/element/{element_id}/value")
	Response xelementSendKeys(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/source")
	Response xgetPageSource(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/execute/sync")
	Response xexecuteScript(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/execute/async")
	Response xexecuteAsyncScript(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/cookie")
	Response xgetAllCookies(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/cookie/{name}")
	Response xgetNamedCookie(@PathParam("session_id") String session_id, @PathParam("name") String name, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/cookie")
	Response xaddCookie(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/cookie/{name}")
	Response xdeleteCookie(@PathParam("session_id") String session_id, @PathParam("name") String name, Request request) throws Exception;
	
	@DELETE
	@Path("/session/{session_id)/cookie")
	Response xdeleteAllCookie(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/actions")
	Response xperformActions(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@DELETE
	@Path("/session/{session_id}/actions")
	Response xreleaseActions(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/dismiss")
	Response xdismissAlert(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/accept")
	Response xacceptAlert(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/alert/text")
	Response xgetAlertText(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@POST
	@Path("/session/{session_id}/alert/text")
	Response xsendAlertText(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/screenshot")
	Response xtakeScreenshot(@PathParam("session_id") String session_id, Request request) throws Exception;
	
	@GET
	@Path("/session/{session_id}/element/{element_id}/screenshot")
	Response xtakeElementScreenshot(@PathParam("session_id") String session_id, @PathParam("element_id") String element_id, Request request) throws Exception;
	
}
