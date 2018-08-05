package xproject.xscript.impl.model;

public class XReturn extends XCommand {
	
	protected XReturn(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		String xthis = xparameters().xthis();
		if(xparameters().xeval().xbindings().xcontainsKey(xthis))
		{
			xeval().xreturn(xparameters().xeval().xbindings().xget(xthis));
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}
}
