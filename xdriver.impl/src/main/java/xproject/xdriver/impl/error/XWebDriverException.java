package xproject.xdriver.impl.error;

public class XWebDriverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XWebDriverException()
	{
		super();
		error = new XErrorRes();
		error.value = new XError();
		error.value.message = "";
		error.value.stacktrace = "";
	}
	
	public int HTTPStatus;
	public XErrorRes error;
	public String description;

}
