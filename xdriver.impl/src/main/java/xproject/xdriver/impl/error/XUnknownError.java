package xproject.xdriver.impl.error;

import java.io.PrintWriter;
import java.io.StringWriter;

public class XUnknownError extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XUnknownError()
	{
		super();
		description = "A command could not be executed because the remote end is not aware of it.";
		HTTPStatus = 500;
		response.value.data = null;
		response.value.error = "unknown response";
		response.value.message = "";
		response.value.stacktrace = "";
	}
	
	public XUnknownError(Exception ex)
	{
		super();
		description = "A command could not be executed because the remote end is not aware of it.";
		HTTPStatus = 500;
		response.value.data = null;
		response.value.error = "unknown response";
		response.value.message = ex.getMessage();
		StringWriter stacktrace = new StringWriter();
		ex.printStackTrace(new PrintWriter(stacktrace));
		response.value.stacktrace = stacktrace.toString();
	}

}
