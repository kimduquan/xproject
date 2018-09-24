package xproject.xdriver.impl.error;

import xproject.xdriver.impl.response.XResponse;

public class XWebDriverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XWebDriverException()
	{
		super();
		response = new XResponse<XError>(new XError());
		response.value.message = "";
		response.value.stacktrace = "";
	}
	
	public int HTTPStatus;
	public XResponse<XError> response;
	public String description;

}
