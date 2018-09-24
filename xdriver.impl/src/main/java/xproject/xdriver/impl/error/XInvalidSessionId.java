package xproject.xdriver.impl.error;

public class XInvalidSessionId extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XInvalidSessionId()
	{
		super();
		description = "Occurs if the given session id is not in the list of active sessions, meaning the session either does not exist or that it’s not active.";
		HTTPStatus = 404;
		response.value.error = "invalid session id";
	}

}
