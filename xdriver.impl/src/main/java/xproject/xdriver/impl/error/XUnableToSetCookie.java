package xproject.xdriver.impl.error;

public class XUnableToSetCookie extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XUnableToSetCookie()
	{
		super();
		description = "A command to set a cookie’s value could not be satisfied.";
		HTTPStatus = 500;
		response.value.error = "unable to set cookie";
	}

}
