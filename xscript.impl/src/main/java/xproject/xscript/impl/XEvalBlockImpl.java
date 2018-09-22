package xproject.xscript.impl;

import xproject.xlang.XObject;

public class XEvalBlockImpl extends XBlockImpl implements XEvalBlock {

	private XBinding xbinding;
	private XContext xcontext;
	private XBlockFactory xblockFactory;
	private XEvalBlock xparent;
	
	protected XBlockFactory xfactory()
	{
		return xblockFactory;
	}
	
	protected XEvalBlockImpl(XScript script, XBinding binding, XContext context, XBlockFactory blockFactory) {
		super(script);
		xbinding = binding;
		xcontext = context;
		xblockFactory = blockFactory;
	}

	protected void xrun(String method, XLine line, XScript script) throws Exception {
		// TODO Auto-generated method stub
		if(method.equals(XConstants.RETURN))
		{
			
		}
	}

	public void xreturn(XObject xreturn) throws Exception {
		// TODO Auto-generated method stub
		xfinal();
		if(xparent != null)
			xparent.xreturn(xreturn);
	}

}
