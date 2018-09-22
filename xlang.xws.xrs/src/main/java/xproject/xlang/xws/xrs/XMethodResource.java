package xproject.xlang.xws.xrs;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XMethodResource extends XRemote {
	
	@POST
	@Path("/")
	XObject xinvoke(XObjectParam xobject, List<XObjectParam> xparameters) throws Exception;
}
