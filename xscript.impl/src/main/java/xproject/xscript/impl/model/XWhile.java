package xproject.xscript.impl.model;

public class XWhile extends XIterator {

	protected XWhile(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		boolean xif = XIf.xif(xparameters());
		while(xif)
		{
			xdo();
			xif = XIf.xif(xparameters().xclone());
		}
	}
}
