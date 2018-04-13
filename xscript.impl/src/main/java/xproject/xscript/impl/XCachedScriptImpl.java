package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.Iterator;

public class XCachedScriptImpl implements XCachedScript {

	private ArrayList<XLine> xlines;
	private XScript xscript;
	private Iterator<XLine> iterator;
	
	protected XCachedScriptImpl(XScript script)
	{
		xscript = script;
		xlines = new ArrayList<XLine>();
		iterator = null;
	}
	
	public boolean xhasNextLine() throws Exception {
		// TODO Auto-generated method stub
		if(iterator != null)
			return iterator.hasNext();
		return xscript.xhasNextLine();
	}

	public XLine xnextLine() throws Exception 
	{
		XLine line = null;
		if(iterator != null)
			line = iterator.next();
		else
		{
			line = xscript.xnextLine();
			xlines.add(line);
		}
		return line.xclone();
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		for(XLine line : xlines)
		{
			line.xclose();
			line.xfinalize();
		}
		xlines.clear();
		xlines = null;
		xscript = null;
		iterator = null;
		finalize();
	}

	public void xrefresh() throws Exception 
	{
		// TODO Auto-generated method stub
		if(iterator != null)
			iterator = xlines.iterator();
	}

	public static XCachedScript xnew(XScript script)
	{
		return new XCachedScriptImpl(script);
	}

	public void xstopCaching() throws Exception 
	{
		// TODO Auto-generated method stub
		if(iterator == null)
			iterator = xlines.iterator();
	}
}
