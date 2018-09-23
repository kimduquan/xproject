package xproject.xdriver.impl.error;

public class XNoSuchElement extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XNoSuchElement()
	{
		super();
		description = "An element could not be located on the page using the given search parameters.";
		HTTPStatus = 404;
		error.value.error = "no such element";
	}

}
