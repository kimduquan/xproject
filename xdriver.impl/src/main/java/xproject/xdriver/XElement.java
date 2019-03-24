package xproject.xdriver;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import xproject.xdriver.impl.XRect;
import xproject.xdriver.impl.model.XElementIdentifier;
import xproject.xdriver.impl.request.XBy;
import xproject.xdriver.impl.request.XKeys;

public interface XElement {

	@POST
	@Path("/element")
	XReturn<XElementIdentifier> xfindElementFromElement(XBy by) throws Exception;
	
	@POST
	@Path("/elements")
	String xfindElementsFromElement(XBy by) throws Exception;
	
	@GET
	@Path("/selected")
	XReturn<Boolean> xisElementSelected() throws Exception;
	
	@GET
	@Path("/attribute/{name}")
	XReturn<String> xgetElementAttribute(@PathParam("name") String name) throws Exception;
	
	@GET
	@Path("/property/{name}")
	XReturn<String> xgetElementProperty(@PathParam("name") String name) throws Exception;
	
	@GET
	@Path("/css/{property_name}")
	XReturn<String> xgetElementCssProperty(@PathParam("property_name") String property_name) throws Exception;
	
	@GET
	@Path("/text")
	XReturn<String> xgetElementText() throws Exception;
	
	@GET
	@Path("/name")
	XReturn<String> xgetElementTagName() throws Exception;
	
	@GET
	@Path("/rect")
	XReturn<XRect> xgetElementRect() throws Exception;
	
	@GET
	@Path("/enabled")
	XReturn<Boolean> xisElementEnabled() throws Exception;
	
	@POST
	@Path("/click")
	XNullReturn xelementClick() throws Exception;
	
	@POST
	@Path("/clear")
	XNullReturn xelementClear() throws Exception;
	
	@POST
	@Path("/value")
	XNullReturn xelementSendKeys(XKeys keys) throws Exception;
	
	@GET
	@Path("/screenshot")
	XReturn<String> xtakeElementScreenshot() throws Exception;
}
