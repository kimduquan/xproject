package xproject.xscript.impl.model;

public class XImport extends XCommand {

	protected XImport(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xeval().xclassLoader().xloadClass(xparameters().xclass());
	}
}
