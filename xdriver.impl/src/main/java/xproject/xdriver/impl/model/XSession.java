package xproject.xdriver.impl.model;

public class XSession {
	
	public XSession(String id)
	{
		sessionID = id;
	}
	
	public String sessionID = null;
	public Long sessionScriptTimeout = (long) 30000;
	public Long sessionPageLoadtimeout = (long) 300000;
	public Long sessionImplicitWaitTimeout = (long) 0;
	public XPageLoadStrategy sessionPageLoadingStrategy = XPageLoadStrategy.normal;
	public Boolean secureTLS;
	public XPromptHandlingApproache userPromptHandler = null;

}
