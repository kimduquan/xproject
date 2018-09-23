package xproject.xdriver.impl.error;

public class XScriptTimeout extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XScriptTimeout()
	{
		super();
		description = "A script did not complete before its timeout expired.";
		HTTPStatus = 408;
		error.value.error = "script timeout";
	}

}
