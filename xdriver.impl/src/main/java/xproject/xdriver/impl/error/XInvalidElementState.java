package xproject.xdriver.impl.error;

public class XInvalidElementState extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XInvalidElementState()
	{
		super();
		description = "A command could not be completed because the element is in an invalid state, e.g. attempting to clear an element that isn't both editable and resettable.";
		HTTPStatus = 400;
		response.value.error = "invalid element state";
	}

}
