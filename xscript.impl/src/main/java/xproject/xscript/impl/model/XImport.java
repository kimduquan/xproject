package xproject.xscript.impl.model;

public class XImport extends XCommand {

	public XImport(XParameters parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xparameters().xclassLoader().xloadClass(xparameters().xclass());
	}
}