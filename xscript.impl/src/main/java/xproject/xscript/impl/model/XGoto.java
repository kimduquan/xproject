package xproject.xscript.impl.model;

public class XGoto extends XCommand {

	private XLine xgoto;
	private String line;
	
	protected XGoto(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
		xgoto = null;
		this.line = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xgoto = xgoto(xeval(), line);
	}

	public XLine xgoto()
	{
		return xgoto;
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}
}
