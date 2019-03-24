package xproject.xdriver;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xproject.xrmi.XRemote;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface XDriver extends XRemote {

	@Path("/{class}")
	@POST
	XDriverReturn xnew(@PathParam("class") String class_name, XDriverParameter parameter) throws Exception;
	
	@Path("/{class}/{field}/.")
	@GET
	XDriverReturn xgetStaticField(@PathParam("class") String class_name, @PathParam("field") String field) throws Exception;
	
	@Path("/{class}/{field}/.")
	@POST
	void xsetStaticField(@PathParam("class") String class_name, @PathParam("field") String field, XDriverParameter parameter) throws Exception;
	
	@Path("/{class}/{object}")
	@DELETE
	void xfinalizeObject(@PathParam("class") String cls, @PathParam("object") String object) throws Exception;
	
	@Path("/{class}/{object}/{field}")
	@GET
	XDriverReturn xgetObjectField(@PathParam("class") String cls, @PathParam("object") String object, @PathParam("field") String field) throws Exception;
	
	
}
