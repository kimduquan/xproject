package xproject.xscript.impl.model;

import xproject.xlang.XClass;

public class XImport extends XCommand {

	protected XImport(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		XClass xclass = xeval().xclassLoader().xloadClass(xparameters().xclass());
		xeval().xclasses().put(xclass.xgetSimpleName(), xclass);
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}
}
