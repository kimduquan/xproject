package xproject.xdriver.impl.error;

public class XStaleElementReference extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XStaleElementReference()
	{
		super();
		description = "A command failed because the referenced element is no longer attached to the DOM.";
		HTTPStatus = 404;
		error.value.error = "stale element reference";
	}

}
