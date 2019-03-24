package xproject.xdriver;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import xproject.xdriver.impl.request.XCookieRequest;
import xproject.xrmi.XRemote;

public interface XCookie extends XRemote {

	@GET
	@Path("/")
	String xgetAllCookies() throws Exception;
	
	@GET
	@Path("/{name}")
	XReturn<XCookie> xgetNamedCookie(@PathParam("name") String name) throws Exception;
	
	@POST
	@Path("/")
	XNullReturn xaddCookie(XCookieRequest cookie) throws Exception;
	
	@DELETE
	@Path("/{name}")
	XNullReturn xdeleteCookie(@PathParam("name") String name) throws Exception;
	
	@DELETE
	@Path("/")
	XNullReturn xdeleteAllCookies() throws Exception;
}
