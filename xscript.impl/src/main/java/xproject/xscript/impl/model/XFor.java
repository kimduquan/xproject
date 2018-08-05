package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;

public class XFor extends XIterator {

	protected XFor(XParameters parameters, XEval eval) {
		super(parameters, eval, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try(XThisParameter xthis = new XThisParameter(xparameters()))
		{
			XObject xobject = xthis.xthis();
			if(xobject.xgetClass().xisArray())
			{
				XArray xarray = (XArray) xthis;
				int length = xarray.xgetLength();
				try(XReturnParameter xreturn = new XReturnParameter(xparameters()))
				{
					for(int i = 0; i < length; i++)
					{
						XObject item = xarray.xget(i);
						xreturn.xreturn(item);
						xdo();
					}
				}
			}
		}
	}
}
