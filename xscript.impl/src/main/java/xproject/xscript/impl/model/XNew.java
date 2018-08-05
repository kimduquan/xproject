package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XConstructor;

public class XNew extends XCommand {

	protected XNew(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xparameters().xclass();
		xparameters().xreturn();
		xparameters().xparameters();
		try(XClassParameter xclass = new XClassParameter(xparameters()))
		{
			try(XReturnParameter xreturn = new XReturnParameter(xparameters()))
			{
				XClass cls = xclass.xclass();
				ArrayList<XClass> temp = new ArrayList<XClass>();
				Iterator<XClass> it = xparameters().xparameterTypes();
				while(it.hasNext())
				{
					temp.add(it.next());
				}
				XClass[] array = new XClass[temp.size()];
				array = temp.toArray(array);
				XConstructor xconstructor = cls.xgetConstructor(array);
				
				ArrayList<XObject> temp2 = new ArrayList<XObject>();
				Iterator<XObject> it2 = xparameters().xparameters();
				while(it2.hasNext())
				{
					temp2.add(it2.next());
				}
				XObject[] array2 = new XObject[temp2.size()];
				array2 = temp2.toArray(array2);
				XObject xnew = xconstructor.xnewInstance(array2);
				xreturn.xreturn(xnew);
			}
		}
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return false;
	}
}
