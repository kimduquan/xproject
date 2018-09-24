package xproject.xdriver.impl.error;

public class XUnableToCaptureScreen extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XUnableToCaptureScreen()
	{
		super();
		description = "A screen capture was made impossible.";
		HTTPStatus = 500;
		response.value.error = "unable to capture screen";
	}

}
