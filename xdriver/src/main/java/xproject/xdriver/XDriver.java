package xproject.xdriver;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xproject.xrmi.XRemote;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface XDriver extends XRemote {

	@Path("/{class_name}")
	XDriverClass xclass(@PathParam("class_name") String class_name) throws Exception;
	
}
