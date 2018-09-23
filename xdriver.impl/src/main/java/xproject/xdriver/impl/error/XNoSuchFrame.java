package xproject.xdriver.impl.error;

public class XNoSuchFrame extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XNoSuchFrame()
	{
		super();
		description = "A command to switch to a frame could not be satisfied because the frame could not be found.";
		HTTPStatus = 404;
		error.value.error = "no such frame";
	}

}
