package xproject.xdriver.impl.error;

public class XNoSuchCookie extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XNoSuchCookie()
	{
		super();
		description = "No cookie matching the given path name was found amongst the associated cookies of the current browsing context’s active document.";
		HTTPStatus = 404;
		response.value.error = "no such cookie";
	}

}
