package xproject.xdriver;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import xproject.xrmi.XRemote;

public interface XDriverClass extends XRemote {
	
	@Path("/{class}-{object}")
	XDriverObject xobject(@PathParam("class") String cls, @PathParam("object") String object) throws Exception;

	@Path("/")
	@POST
	XDriverReturn xnew(XDriverParameter parameter) throws Exception;
	
	@Path("/{field}")
	@GET
	XDriverMethod xfield(@PathParam("field") String field) throws Exception;
}
