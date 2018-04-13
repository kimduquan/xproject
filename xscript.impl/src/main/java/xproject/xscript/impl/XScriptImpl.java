package xproject.xscript.impl;

import xproject.xutil.XScanner;

public class XScriptImpl implements XScript {

	private XScanner xscanner;
	private XScriptFactory xfactory;
	private long current;
	
	protected XScriptImpl(XScanner scanner, XScriptFactory factory)
	{
		xscanner = scanner;
		xfactory = factory;
		current = 0;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xscanner = null;
		xfactory = null;
		finalize();
	}

	@Override
	public boolean xhasNextLine() throws Exception {
		// TODO Auto-generated method stub
		return xscanner.xhasNextLine();
	}

	@Override
	public XLine xnextLine() throws Exception {
		// TODO Auto-generated method stub
		current += 1;
		return xfactory.xLine(current, xscanner.xnextLine());
	}

	public static XScript xnew(XScanner scanner, XScriptFactory factory)
	{
		return new XScriptImpl(scanner, factory);
	}
}
