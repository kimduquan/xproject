package xproject.xscript.impl.model;

public class XFinally extends XCommand {

	protected XFinally(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xeval(xeval(), "");
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
