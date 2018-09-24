package xproject.xdriver.impl.error;

public class XInvalidCookieDomain extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XInvalidCookieDomain()
	{
		super();
		description = "An illegal attempt was made to set a cookie under a different domain than the current page.";
		HTTPStatus = 400;
		response.value.error = "invalid cookie domain";
	}

}
