package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XConstructor;

public class XNew extends XCommand {

	protected XNew(XLine line, XEval eval) {
		super(line, eval);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xLine().xclass();
		xLine().xreturn();
		xLine().xparameters();
		try(XClassParameter xclass = new XClassParameter(xLine()))
		{
			try(XReturnParameter xreturn = new XReturnParameter(xLine()))
			{
				XClass cls = xclass.xclass();
				ArrayList<XClass> temp = new ArrayList<XClass>();
				Iterator<XClass> it = xLine().xparameterTypes();
				while(it.hasNext())
				{
					temp.add(it.next());
				}
				XClass[] array = new XClass[temp.size()];
				array = temp.toArray(array);
				XConstructor xconstructor = cls.xgetConstructor(array);
				
				ArrayList<XObject> temp2 = new ArrayList<XObject>();
				Iterator<XObject> it2 = xLine().xparameters();
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
