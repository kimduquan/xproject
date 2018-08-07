package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;

import xproject.xlang.XObject;

public class XInvoke extends XCommand {

	protected XInvoke(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		try(XClassParameter xclass = new XClassParameter(xparameters()))
		{
			try(XThisParameter xthis = new XThisParameter(xparameters()))
			{
				try(XMethodParameter xmethod = new XMethodParameter(xparameters(), xclass, xthis))
				{
					if(xmethod.xmethod() != null)
					{
						ArrayList<XObject> temp2 = new ArrayList<XObject>();
						Iterator<XObject> it2 = xparameters().xparameters();
						while(it2.hasNext())
						{
							temp2.add(it2.next());
						}
						XObject[] array2 = new XObject[temp2.size()];
						array2 = temp2.toArray(array2);
						XObject xobject = xmethod.xmethod().xinvoke(xthis.xthis() != null ? xthis.xthis() : XObject.xnull, array2);
						try(XReturnParameter xreturn = new XReturnParameter(xparameters()))
						{
							xreturn.xreturn(xobject);
						}
					}
				}
			}
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
