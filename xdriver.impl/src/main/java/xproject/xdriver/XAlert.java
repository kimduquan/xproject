package xproject.xdriver;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import xproject.xdriver.impl.response.XNoResponse;
import xproject.xdriver.impl.response.XResponse;
import xproject.xrmi.XRemote;

public interface XAlert extends XRemote {

	@POST
	@Path("/dismiss")
	XNoResponse xdismissAlert() throws Exception;
	
	@POST
	@Path("/accept")
	XNoResponse xacceptAlert() throws Exception;
	
	@GET
	@Path("/text")
	XResponse<String> xgetAlertText() throws Exception;
	
	@POST
	@Path("/text")
	XNoResponse xsendAlertText(XAlert text) throws Exception;
	
}
