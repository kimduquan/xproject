/**
 * 
 */
package xproject.xscript.impl.model;

import xproject.xlang.XAutoCloseable;
import xproject.xlang.XRunnable;
import xproject.xrmi.XRemote;

/**
 * @author Admin
 *
 */
public abstract class XCommand implements XRemote, XRunnable, XAutoCloseable, Runnable, AutoCloseable {

	private XParameters xparameters;
	private XEval xeval;
	
	protected XCommand(XParameters parameters, XEval eval)
	{
		xparameters = parameters;
		xeval = eval;
	}
	
	protected XParameters xparameters()
	{
		return xparameters;
	}
	
	protected XEval xeval()
	{
		return xeval;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		xclose();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			xrun();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void xclose() throws Exception {
		// TODO Auto-generated method stub
		try {
			xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		xeval = null;
		finalize();
	}
}
