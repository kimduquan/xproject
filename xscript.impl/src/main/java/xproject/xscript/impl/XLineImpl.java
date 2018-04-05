package xproject.xscript.impl;

import xproject.xutil.XScanner;

public class XLineImpl implements XLine {

	private XScanner xscanner;
	private long number;
	
	protected XLineImpl(long n, XScanner scanner)
	{
		xscanner = scanner;
		number = n;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xscanner = null;
		finalize();
	}

	public XScanner xscanner() throws Exception {
		// TODO Auto-generated method stub
		return xscanner;
	}

	public long xnumber() throws Exception {
		// TODO Auto-generated method stub
		return number;
	}

	public static XLine xnew(long n, XScanner scanner)
	{
		return new XLineImpl(n, scanner);
	}
}
