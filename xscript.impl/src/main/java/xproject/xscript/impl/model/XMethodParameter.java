package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;

import xproject.xlang.XClass;
import xproject.xlang.xreflect.XMethod;
import xproject.xrmi.XRemote;

public class XMethodParameter implements XRemote, AutoCloseable {

	private XLine xline;
	private XClassParameter xclass;
	private XThisParameter xthis;
	private XMethod xmethod;
	
	public XMethodParameter(XLine line, XClassParameter cls, XThisParameter ths)
	{
		xline = line;
		xclass = cls;
		xthis = ths;
		xmethod = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
		xclass = null;
		xthis = null;
		xmethod = null;
		finalize();
	}
	
	public XMethod xmethod() throws Exception
	{
		if(xmethod == null)
		{
			XClass xtype = null;
			if(xthis.xthis() == null)
			{
				xtype = xclass.xclass();
			}
			else
			{
				xtype = xthis.xthis().xgetClass();
			}
			ArrayList<XClass> temp = new ArrayList<XClass>();
			Iterator<XClass> it = xline.xparameterTypes();
			while(it.hasNext())
			{
				temp.add(it.next());
			}
			XClass[] array = new XClass[temp.size()];
			array = temp.toArray(array);
			try
			{
				xmethod = xtype.xgetMethod(xline.xmethod(), array);
			}
			catch(Exception ex)
			{
				for(XMethod method : xtype.xgetMethods())
				{
					if(method.xgetName().equals(xline.xmethod()) && method.xgetParameterCount() == array.length)
					{
						xmethod = method;
						break;
					}
				}
			}
		}
		return xmethod;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
