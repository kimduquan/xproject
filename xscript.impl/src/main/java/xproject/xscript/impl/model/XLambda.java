package xproject.xscript.impl.model;

import java.util.ArrayList;

import xproject.xutil.XScanner;

public class XLambda extends XCommand {

	private ArrayList<XScanner> xscanners;
	protected XLambda(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xscanners = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		if(xscanners == null)
		{
			xscanners = new ArrayList<XScanner>();
			xclone(xeval(), "", xscanners);
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public XScanner[] xscanners()
	{
		XScanner[] scanners = new XScanner[xscanners.size()];
		scanners = xscanners.toArray(scanners);
		return scanners;
	}
}
