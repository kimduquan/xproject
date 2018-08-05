package xproject.xscript.impl.model;

public class XAssert extends XCommand {

	protected XAssert(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try(XBooleanParameter xboolean = new XBooleanParameter(xparameters()))
		{
			b = xboolean.xboolean(false);
		}
		assert(b);
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}

}
