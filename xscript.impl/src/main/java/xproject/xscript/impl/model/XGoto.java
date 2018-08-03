package xproject.xscript.impl.model;

public class XGoto extends XCommand {

	private XParameters xgoto;
	private String xend;
	
	protected XGoto(XParameters parameters, XEval eval, String end) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xend = end;
		xgoto = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public XParameters xgoto()
	{
		return xgoto;
	}
}
