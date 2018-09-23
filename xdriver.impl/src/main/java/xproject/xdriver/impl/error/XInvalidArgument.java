package xproject.xdriver.impl.error;

public class XInvalidArgument extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XInvalidArgument()
	{
		super();
		description = "The arguments passed to a command are either invalid or malformed.";
		HTTPStatus = 400;
		error.value.error = "invalid argument";
	}

}
