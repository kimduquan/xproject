package xproject.xdriver;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import xproject.xrmi.XRemote;

public interface XDriverObject extends XRemote {

	@Path("/")
	@DELETE
	void xfinalizeObject() throws Exception;
	
	@Path("/")
	@GET
	XDriverReturn xtoStringOjbect() throws Exception;
	
	@Path("/{field}")
	@POST
	XDriverMethod xsetObjectField(@PathParam("class") String class_name, @PathParam("object") String object, @PathParam("field") String field) throws Exception;
	
}
