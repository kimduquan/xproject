package xproject.xscript.impl.model;

public class XGoto extends XCommand {

	private XParameters xline;
	private String line;
	
	protected XGoto(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xline = null;
		this.line = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xline = xgoto(xeval(), line);
	}

	public XParameters xline()
	{
		return xline;
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}
}
