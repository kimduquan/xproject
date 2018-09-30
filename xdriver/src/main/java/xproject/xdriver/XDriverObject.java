package xproject.xdriver;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import xproject.xrmi.XRemote;

public interface XDriverObject extends XRemote {

	@Path("/")
	@DELETE
	XDriverReturn xfinal() throws Exception;
	
	@Path("/")
	XDriverClass xclass() throws Exception;
	
}
