package xproject.xdriver.impl.model;

public class XTimeouts {

	public Long script;
	public Long pageLoad;
	public Long implicit;
	
	public XTimeouts()
	{
		script = null;
		pageLoad = null;
		implicit = null;
	}
	
	public XTimeouts(XTimeouts other)
	{
		script = other.script;
		pageLoad = other.pageLoad;
		implicit = other.implicit;
	}
	
	public static final long DEFAULT_SCRIPT_TIMEOUT = 30000;
	public static final long DEFAULT_PAGE_LOAD_TIMEOUT = 300000;
	public static final long DEFAULT_IMPLICIT_WAIT_TIMEOUT = 0;
}
