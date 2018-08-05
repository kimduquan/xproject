/**
 * 
 */
package xproject.xscript.impl.model;

import xproject.xlang.XRunnable;
import xproject.xrmi.XRemote;
import xproject.xscript.impl.XConstants;
import xproject.xutil.XScanner;

/**
 * @author Admin
 *
 */
public abstract class XCommand implements XRemote, XRunnable, xproject.xlang.XAutoCloseable, Runnable, AutoCloseable {

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
	
	protected abstract boolean xisBlock();
	
	protected XParameters xgoto(XEval xeval, String line) throws Exception
	{
		XParameters xline = null;
		if(xisBlock())
		{
			boolean isFinal = false;
			while(xeval.xscanner().xhasNextLine() && isFinal == false && xline == null && xeval.xisFinal() == false)
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval.xscanner().xnextLine()))
				{
					try(XParameters parameters = new XParameters(current.x(), xeval, null))
					{
						String method = parameters.xmethod();
						if(method.isEmpty() == false)
						{
							if(method.equals(line))
							{
								xline = parameters.xclone();
							}
							else if(method.equals(XConstants.FINAL))
							{
								isFinal = true;
							}
							else
							{
								try(XCommand xcommand = xeval.xcommandFactory().xcommand(method, xeval, parameters))
								{
									xcommand.xgoto(xeval, "");
								}
							}
						}
					}
				}
			}
		}
		return xline;
	}
	
	protected XParameters xeval(XEval xeval, String line) throws Exception
	{
		XParameters xline = null;
		if(xisBlock())
		{
			boolean isFinal = false;
			while(xeval.xscanner().xhasNextLine() && xline == null && isFinal == false && xeval.xisReturn() == false && xeval.xisFinal() == false)
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval.xscanner().xnextLine()))
				{
					try(XParameters parameters = new XParameters(current.x(), xeval, null))
					{
						String method = parameters.xmethod();
						if(method.isEmpty() == false)
						{
							
							if(method.equals(line))
							{
								xline = parameters.xclone();
							}
							else if(method.equals(XConstants.FINAL))
							{
								isFinal = true;
							}
							else
							{
								try(XCommand xcommand = xeval.xcommandFactory().xcommand(method, xeval, parameters))
								{
									xcommand.xrun();
								}
							}
						}
					}
				}
			}
		}
		return xline;
	}
}
