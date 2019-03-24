package xproject.xdriver;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import xproject.xdriver.impl.model.XElementIdentifier;
import xproject.xdriver.impl.request.XBy;
import xproject.xdriver.impl.request.XScript;
import xproject.xdriver.impl.request.XUrl;
import xproject.xdriver.impl.response.XStatus;

public interface XSession {

	@DELETE
	@Path("/")
	XNullReturn xdeleteSession() throws Exception;
	
	@GET
	@Path("/status")
	XReturn<XStatus> xgetStatus() throws Exception;
	
	@Path("/timeouts")
	XTimeouts xtimeouts() throws Exception;
	
	@POST
	@Path("/url")
	XNullReturn xnavigateTo(XUrl request) throws Exception;
	
	@GET
	@Path("/url")
	XReturn<String> xgetCurrentUrl() throws Exception;
	
	@POST
	@Path("/back")
	XNullReturn xback() throws Exception;
	
	@POST
	@Path("/forward")
	XNullReturn xforward() throws Exception;
	
	@POST
	@Path("/refresh")
	XNullReturn xrefresh() throws Exception;
	
	@GET
	@Path("/title")
	XReturn<String> xgetTitle() throws Exception;
	
	@Path("/window")
	XWindow xwindow() throws Exception;
	
	@Path("/frame")
	XFrame xframe() throws Exception;
	
	@GET
	@Path("/element/active")
	XReturn<XElementIdentifier> xgetActiveElement() throws Exception;
	
	@POST
	@Path("/element")
	XReturn<XElementIdentifier> xfindElement(XBy by) throws Exception;
	
	@POST
	@Path("/elements")
	String xfindElements(XBy by) throws Exception;
	
	@Path("/element/{element_id}")
	XElement xelement(@PathParam("element_id") String element_id) throws Exception;
	
	@GET
	@Path("/source")
	XReturn<String> xgetPageSource() throws Exception;
	
	@POST
	@Path("/execute/sync")
	XReturn<Object> xexecuteScript(XScript script) throws Exception;
	
	@POST
	@Path("/execute/async")
	XReturn<Object> xexecuteAsyncScript(XScript script) throws Exception;
	
	@Path("/actions")
	XActions xactions() throws Exception;
	
	@Path("alert")
	XAlert xalert() throws Exception;
	
	@GET
	@Path("/screenshot")
	XReturn<String> xtakeScreenshot() throws Exception;
	
}
