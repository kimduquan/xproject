package xproject.xdriver.impl.error;

public class XJavascriptError extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XJavascriptError()
	{
		super();
		description = "An response occurred while executing JavaScript supplied by the user.";
		HTTPStatus = 500;
		response.value.error = "javascript response";
	}

}
