package xproject.xscript.impl.model;

public class XAssert extends XCommand {

	protected XAssert(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try(XBooleanParameter xboolean = new XBooleanParameter(xLine()))
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
