package xproject.xscript.impl;

public interface XCachedScript extends XScript 
{
	void xrefresh() throws Exception;
	void xstopCaching() throws Exception;
}
