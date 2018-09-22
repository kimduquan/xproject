package xproject.xscript.impl;

import xproject.xutil.XScanner;

public abstract class XBlockImpl implements XBlock {

	private XScript xscript;
	private boolean xfinal;
	
	protected XBlockImpl(XScript script)
	{
		xscript = script;
		xfinal = false;
	}
	
	public void xfinalize() throws Throwable {
		xscript = null;
		finalize();
	}

	public void xfinal() throws Exception {
		// TODO Auto-generated method stub
		xfinal = true;
	}

	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		for(XLine currentLine = null; xscript.xhasNextLine(); currentLine = xscript.xnextLine())
		{
			XScanner scanner = currentLine.xscanner();
			if(scanner.xhasNext())
			{
				String method = xmethod(scanner);
				if(method.isEmpty() == false)
				{
					xrun(method, currentLine, xscript);
				}
			}
			currentLine.xclose();
			if(xfinal)
				break;
		}
	}
	
	protected String xmethod(XScanner currentLine) throws Exception
	{
		String methodName = currentLine.xnext();
		for(; methodName.isEmpty() && currentLine.xhasNext(); methodName = currentLine.xnext())
		{
		}
		return methodName;
	}
	
	protected abstract void xrun(String method, XLine line, XScript script) throws Exception;
}
