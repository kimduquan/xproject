package xproject.xdriver.impl.error;

public class XElementNotInteractable extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XElementNotInteractable()
	{
		super();
		description = "A command could not be completed because the element is not pointer- or keyboard interactable.";
		HTTPStatus = 400;
		error.value.error = "element not interactable";
	}

}
