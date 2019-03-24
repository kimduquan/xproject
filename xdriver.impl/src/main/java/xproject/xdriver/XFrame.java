package xproject.xdriver;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import xproject.xrmi.XRemote;

public interface XFrame extends XRemote {

	@POST
	@Path("/")
	XNullReturn xswitchToFrame(XFrame request) throws Exception;
	
	@POST
	@Path("/parent")
	XNullReturn xswitchToParentFrame() throws Exception;
}
