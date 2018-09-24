package xproject.xdriver.impl.error;

public class XUnexpectedAlertOpen extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XUnexpectedAlertOpen()
	{
		super();
		description = "A modal dialog was open, blocking this operation.";
		HTTPStatus = 500;
		response.value.error = "unexpected alert open";
	}

}
