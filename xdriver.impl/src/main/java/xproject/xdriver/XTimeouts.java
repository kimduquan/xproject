package xproject.xdriver;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import xproject.xrmi.XRemote;

public interface XTimeouts extends XRemote {

	@GET
	@Path("/")
	XReturn<XTimeouts> xgetTimeouts() throws Exception;
	
	@POST
	@Path("/")
	XNullReturn xsetTimeouts(XTimeouts timeouts) throws Exception;
}
