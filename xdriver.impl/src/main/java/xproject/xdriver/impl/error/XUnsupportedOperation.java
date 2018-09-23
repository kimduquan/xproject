package xproject.xdriver.impl.error;

public class XUnsupportedOperation extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XUnsupportedOperation()
	{
		super();
		description = "Indicates that a command that should have executed properly cannot be supported for some reason.";
		HTTPStatus = 500;
		error.value.error = "unsupported operation";
	}

}
