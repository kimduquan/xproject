package xproject.xdriver.impl.error;

public class XInsecureCertificate extends XWebDriverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XInsecureCertificate()
	{
		super();
		description = "Navigation caused the user agent to hit a certificate warning, which is usually the result of an expired or invalid TLS certificate.";
		HTTPStatus = 400;
		error.value.error = "insecure certificate";
	}

}
