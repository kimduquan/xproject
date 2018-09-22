package xproject.xlang.xws.xrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import xproject.xlang.XClass;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xrmi.XRemote;

public interface XClassResource extends XRemote {

	@Path("/{name}")
	@POST
	XClass xforName(@PathParam("name") String name) throws Exception;
	
	@Path("/{name}")
	@GET
	XClassResource xclass(@QueryParam("name") String name) throws Exception;
	
	@GET
	@Path("/fields")
	XField[] xgetFields() throws Exception;
	
	@GET
	@Path("/field/{name}")
	XFieldResource xgetField(@PathParam("name") String name) throws Exception;
	
	@GET
	@Path("/methods")
	XMethod[] xgetMethods() throws Exception;
	
	@GET
	@Path("/constructors")
	XConstructor[] xgetConstructors() throws Exception;
	
	@GET
	@Path("/modifiers")
	XModifier xgetModifiers() throws Exception;
	
	@GET
	@Path("/method")
	XMethodResource xgetMethod(@QueryParam("name") String name, @QueryParam("parameterTypes") List<XClassParam> parameterTypes) throws Exception;
	
	@GET
	@Path("/constructor")
	XConstructorResource xgetConstructor(@QueryParam("parameterTypes") List<XClassParam> parameterTypes) throws Exception;
	
}
