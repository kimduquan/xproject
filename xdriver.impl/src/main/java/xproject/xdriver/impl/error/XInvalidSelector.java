package xproject.xdriver.impl.error;

public class XInvalidSelector extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XInvalidSelector()
	{
		super();
		description = "Argument was an invalid selector.";
		HTTPStatus = 400;
		error.value.error = "invalid selector";
	}

}
