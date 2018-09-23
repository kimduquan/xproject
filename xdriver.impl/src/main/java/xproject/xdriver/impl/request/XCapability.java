package xproject.xdriver.impl.request;

import xproject.xdriver.impl.XProxy;
import xproject.xdriver.impl.XTimeouts;

public class XCapability {
	
	public String browserName;
	public String browserVersion;
	public String platformName;
	public boolean acceptInsecureCerts;
	public String pageLoadStrategy;
	public XProxy proxy;
	public boolean setWindowRect;
	public XTimeouts timeouts;
	public String unhandledPromptBehavior;
}
