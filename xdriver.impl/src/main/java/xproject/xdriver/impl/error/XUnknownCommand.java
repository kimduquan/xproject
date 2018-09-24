package xproject.xdriver.impl.error;

public class XUnknownCommand extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XUnknownCommand()
	{
		super();
		description = "A command could not be executed because the remote end is not aware of it.";
		HTTPStatus = 404;
		response.value.error = "unknown command";
	}

}
