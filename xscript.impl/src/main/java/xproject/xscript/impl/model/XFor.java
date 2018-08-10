package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;

public class XFor extends XIterator {

	protected XFor(XLine line, XEval eval) {
		super(line, eval, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try(XThisParameter xthis = new XThisParameter(xLine()))
		{
			XObject xobject = xthis.xthis();
			if(xobject.xgetClass().xisArray())
			{
				XArray xarray = (XArray) xthis;
				int length = xarray.xgetLength();
				try(XReturnParameter xreturn = new XReturnParameter(xLine()))
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
