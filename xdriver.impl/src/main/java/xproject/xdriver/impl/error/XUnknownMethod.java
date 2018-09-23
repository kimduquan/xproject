package xproject.xdriver.impl.error;

public class XUnknownMethod extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XUnknownMethod()
	{
		super();
		description = "The requested command matched a known URL but did not match an method for that URL.";
		HTTPStatus = 405;
		error.value.error = "unknown method";
	}

}
