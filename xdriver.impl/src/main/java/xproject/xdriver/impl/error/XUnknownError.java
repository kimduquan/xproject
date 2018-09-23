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
		error.value.data = null;
		error.value.error = "unknown error";
		error.value.message = "";
		error.value.stacktrace = "";
	}
	
	public XUnknownError(Exception ex)
	{
		super();
		description = "A command could not be executed because the remote end is not aware of it.";
		HTTPStatus = 500;
		error.value.data = null;
		error.value.error = "unknown error";
		error.value.message = ex.getMessage();
		StringWriter stacktrace = new StringWriter();
		ex.printStackTrace(new PrintWriter(stacktrace));
		error.value.stacktrace = stacktrace.toString();
	}

}
