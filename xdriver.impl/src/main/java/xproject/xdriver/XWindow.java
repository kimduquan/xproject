package xproject.xdriver;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import xproject.xdriver.impl.XRect;
import xproject.xdriver.impl.model.XWindowIdentifier;
import xproject.xrmi.XRemote;

public interface XWindow extends XRemote {
	
	@GET
	@Path("/")
	XReturn<XWindowIdentifier> xgetWindowHandle() throws Exception;
	
	@DELETE
	@Path("/")
	String xcloseWindow() throws Exception;
	
	@POST
	@Path("/")
	XNullReturn xswitchToWindow(XWindow request) throws Exception;
	
	@GET
	@Path("/handles")
	String xgetWindowHandles() throws Exception;
	
	@GET
	@Path("/rect")
	XReturn<XRect> xgetWindowRect() throws Exception;
	
	@POST
	@Path("/rect")
	XReturn<XRect> xsetWindowRect(XRect rect) throws Exception;
	
	@POST
	@Path("/maximize")
	XReturn<XRect> xmaximizeWindow() throws Exception;
	
	@POST
	@Path("/minimize")
	XReturn<XRect> xminimizeWindow() throws Exception;
	
	@POST
	@Path("/fullscreen")
	XReturn<XRect> xfullscreenWindow() throws Exception;
}
