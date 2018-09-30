package xproject.xdriver;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import xproject.xrmi.XRemote;

public interface XDriverMap extends XRemote {
	
	@Path("/")
	@DELETE
	XDriverReturn xfinal() throws Exception;
	
	@Path("/{key}")
	XDriverObject xvalue(@PathParam("key") String key) throws Exception;
}
