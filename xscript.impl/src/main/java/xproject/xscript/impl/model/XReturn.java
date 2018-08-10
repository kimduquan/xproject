package xproject.xscript.impl.model;

public class XReturn extends XCommand {
	
	protected XReturn(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		String xthis = xLine().xthis();
		if(xLine().xeval().xbindings().xcontainsKey(xthis))
		{
			xeval().xreturn(xLine().xeval().xbindings().xget(xthis));
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}
}
