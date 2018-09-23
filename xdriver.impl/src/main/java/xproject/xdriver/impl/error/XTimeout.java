package xproject.xdriver.impl.error;

public class XTimeout extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XTimeout()
	{
		super();
		description = "An operation did not complete before its timeout expired.";
		HTTPStatus = 408;
		error.value.error = "timeout";
	}

}
