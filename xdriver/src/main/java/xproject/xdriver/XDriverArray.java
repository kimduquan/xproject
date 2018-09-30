package xproject.xdriver;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface XDriverArray extends XDriverObject {

	@Path("/{index}")
	XDriverObject xobject(@PathParam("index") int index) throws Exception;
}
