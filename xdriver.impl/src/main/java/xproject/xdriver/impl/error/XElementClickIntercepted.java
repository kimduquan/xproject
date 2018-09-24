package xproject.xdriver.impl.error;

public class XElementClickIntercepted extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XElementClickIntercepted()
	{
		super();
		description = "The Element Click command could not be completed because the element receiving the events is obscuring the element that was requested clicked.";
		HTTPStatus = 400;
		response.value.error = "element click intercepted";
	}

}
