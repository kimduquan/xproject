package xproject.xdriver.impl.error;

public class XSessionNotCreated extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XSessionNotCreated()
	{
		super();
		description = "A new session could not be created.";
		HTTPStatus = 500;
		error.value.error = "session not created";
	}

}
