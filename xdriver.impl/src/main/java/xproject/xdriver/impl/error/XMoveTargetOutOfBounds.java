package xproject.xdriver.impl.error;

public class XMoveTargetOutOfBounds extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XMoveTargetOutOfBounds()
	{
		super();
		description = "The target for mouse interaction is not in the browser’s viewport and cannot be brought into that viewport.";
		HTTPStatus = 500;
		response.value.error = "move target out of bounds";
	}

}
