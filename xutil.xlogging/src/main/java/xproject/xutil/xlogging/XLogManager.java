package xproject.xutil.xlogging;

import xproject.xrmi.XRemote;

public interface XLogManager extends XRemote 
{
	XLogger xgetLogger(String name) throws Exception;
	String[] xgetLoggerNames() throws Exception;
}
