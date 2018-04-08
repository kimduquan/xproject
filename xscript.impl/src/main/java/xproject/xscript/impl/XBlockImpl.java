package xproject.xscript.impl;

public abstract class XBlockImpl implements XBlock 
{
	private XScript xscript;
	private boolean stop;
	
	protected XBlockImpl(XScript script)
	{
		xscript = script;
		stop = false;
	}
	
	public void xfinalize() throws Throwable 
	{
		xscript = null;
		finalize();
	}

	public void xrun() throws Exception 
	{
		for(XLine currentLine = null; xscript.xhasNextLine(); currentLine = xscript.xnextLine())
		{
			String methodName = currentLine.xmethod();
			if(methodName.isEmpty() == false)
			{
				xrun(methodName, currentLine, xscript);
			}
			currentLine.xclose();
			if(stop)
				break;
		}
	}

	public void xfinal() throws Exception 
	{
		stop = true;
	}
	
	protected abstract void xrun(String method, XLine line, XScript script) throws Exception;
}
