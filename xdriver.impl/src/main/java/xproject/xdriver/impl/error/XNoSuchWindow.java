package xproject.xdriver.impl.error;

public class XNoSuchWindow extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XNoSuchWindow()
	{
		super();
		description = "A command to switch to a window could not be satisfied because the window could not be found.";
		HTTPStatus = 404;
		error.value.error = "no such window";
	}

}
