package xproject.xdriver.impl.model;

public class XSession {
	
	public XSession(String id)
	{
		sessionID = id;
		timeouts = new XTimeouts();
		timeouts.script = XTimeouts.DEFAULT_SCRIPT_TIMEOUT;
		timeouts.pageLoad = XTimeouts.DEFAULT_PAGE_LOAD_TIMEOUT;
		timeouts.implicit = XTimeouts.DEFAULT_IMPLICIT_WAIT_TIMEOUT;
		sessionPageLoadingStrategy = XPageLoadStrategy.normal;
	}
	
	public String sessionID;
	public XTimeouts timeouts;
	public XPageLoadStrategy sessionPageLoadingStrategy;
	public Boolean secureTLS = null;
	public XPromptHandlingApproache userPromptHandler = null;

}
