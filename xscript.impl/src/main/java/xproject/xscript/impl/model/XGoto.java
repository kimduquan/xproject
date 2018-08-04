package xproject.xscript.impl.model;

public class XGoto extends XCommand {

	private XParameters xline;
	private String line;
	private XGoto xgoto;
	
	protected XGoto(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xline = null;
		line = null;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		if(xparameters().xscanner().xhasNext())
		{
			line = xparameters().xstring("line");
			if(line != null && line.isEmpty() == false)
			{
				xline = xeval().xgoto(line);
			}
		}
	}

	public XParameters xline()
	{
		return xline;
	}
	
	public static XGoto xnew(XEval xeval, String xline) throws Exception
	{
		return null;
	}
}
