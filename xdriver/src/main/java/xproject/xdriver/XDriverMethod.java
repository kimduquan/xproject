package xproject.xdriver;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import xproject.xrmi.XRemote;

public interface XDriverMethod extends XRemote {

	@Path("/")
	@POST
	XDriverReturn xset(XDriverParameter parameter) throws Exception;
	
	@Path("/")
	@GET
	XDriverReturn xget(XDriverParameter parameter) throws Exception;
	
	@Path("/")
	XDriverObject xvalue() throws Exception;
	
}
