package xproject.xdriver;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import xproject.xrmi.XRemote;

public interface XActions extends XRemote {

	@POST
	@Path("/")
	XNullReturn xperformActions(XActions actions) throws Exception;
	
	@DELETE
	@Path("/")
	XNullReturn xreleaseActions() throws Exception;
}
