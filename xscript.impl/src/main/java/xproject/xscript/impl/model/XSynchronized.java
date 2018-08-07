package xproject.xscript.impl.model;

public class XSynchronized extends XCommand {

	protected XSynchronized(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub

		try(XThisParameter xthis = new XThisParameter(xparameters()))
		{
			synchronized(xthis)
			{
				xeval(xeval(), "");
			}
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}

}
