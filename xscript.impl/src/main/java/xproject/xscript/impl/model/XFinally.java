package xproject.xscript.impl.model;

public class XFinally extends XCommand {

	protected XFinally(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xeval().xrun();
	}
	
}
