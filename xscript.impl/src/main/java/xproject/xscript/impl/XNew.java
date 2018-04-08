package xproject.xscript.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.XRunnable;
import xproject.xlang.xreflect.XConstructor;
import xproject.xscript.XBindings;

public class XNew implements XRunnable {

	private XLine xline;
	private XContext xcontext;
	private XBindings xbindings;
	
	protected XNew(XLine line, XContext context, XBindings bindings)
	{
		xline = line;
		xcontext = context;
		xbindings = bindings;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
		xcontext = null;
		xbindings = null;
		finalize();
	}

	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		if(xline.xhasNextParam(XConstants.CLASS))
		{
			XClass xclass = xline.xnextClassParam(xcontext);
			String xreturn = null;
			if(xline.xhasNextParam(XConstants.RETURN))
			{
				xreturn = (String) xline.xnextParam();
			}
			XObject[] xparameters = xline.xparameter(xbindings, xcontext.xfactory());
			XClass[] xparameterTypes = xparameterTypes(xparameters);
			XConstructor xconstructor = xclass.xgetConstructor(xparameterTypes);
			if(xconstructor != null)
			{
				XObject xobject = xconstructor.xnewInstance(xparameters);
				if(xreturn != null)
				{
					if(xreturn.isEmpty() == false)
					{
						xbindings.xput(xreturn, xobject);
					}
				}
			}
		}
	}
	
	protected XClass[] xparameterTypes(XObject[] xparameters) throws Exception
	{
		XClass[] xparameterTypes = new XClass[xparameters.length];
		for(int i = 0; i < xparameterTypes.length; i++)
		{
			xparameterTypes[i] = xparameters[i].xgetClass();
		}
		return xparameterTypes;
	}
	
	
}
