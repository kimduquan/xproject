package xproject.xdriver.impl.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class XExceptionMapper implements ExceptionMapper<Exception> {

	public Response toResponse(Exception exception) {
		// TODO Auto-generated method stub
		XWebDriverException ex = null;
		if(exception instanceof XWebDriverException)
		{
			ex = (XWebDriverException) exception;
		}
		else
		{
			ex = new XUnknownError(exception);
		}
		return Response.status(ex.HTTPStatus).entity(ex.error).build();
	}

}
