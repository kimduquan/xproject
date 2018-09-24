package xproject.xdriver.impl.error;

public class XNoSuchAlert extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XNoSuchAlert()
	{
		super();
		description = "An attempt was made to operate on a modal dialog when one was not open.";
		HTTPStatus = 404;
		response.value.error = "no such alert";
	}

}
