/**
 * 
 */
package xproject.xscript.impl.model;

import java.util.List;

import xproject.xlang.XRunnable;
import xproject.xrmi.XRemote;
import xproject.xscript.impl.XConstants;
import xproject.xutil.XScanner;

/**
 * @author Admin
 *
 */
public abstract class XCommand implements XRemote, XRunnable, xproject.xlang.XAutoCloseable, Runnable, AutoCloseable {

	private XLine xline;
	private XEval xeval;
	
	protected XCommand(XLine line, XEval eval)
	{
		xline = line;
		xeval = eval;
	}
	
	protected XLine xLine()
	{
		return xline;
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
		xline = null;
		xeval = null;
		finalize();
	}
	
	protected abstract boolean xisBlock();
	
	protected XLine xgoto(XEval xeval, String line) throws Exception
	{
		XLine xgoto = null;
		if(xisBlock())
		{
			boolean isFinal = false;
			while(xeval.xscanner().xhasNextLine() && isFinal == false && xgoto == null && xeval.xisFinal() == false)
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval.xscanner().xnextLine()))
				{
					try(XLine parameters = new XLine(current.x(), xeval, null))
					{
						String method = parameters.xmethod();
						if(method.isEmpty() == false)
						{
							if(method.equals(line))
							{
								xgoto = parameters.xclone();
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
		return xgoto;
	}
	
	protected XLine xeval(XEval xeval, String line) throws Exception
	{
		XLine xgoto = null;
		if(xisBlock())
		{
			boolean isFinal = false;
			while(xeval.xscanner().xhasNextLine() && xgoto == null && isFinal == false && xeval.xisReturn() == false && xeval.xisFinal() == false)
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval.xscanner().xnextLine()))
				{
					try(XLine parameters = new XLine(current.x(), xeval, null))
					{
						String method = parameters.xmethod();
						if(method.isEmpty() == false)
						{
							
							if(method.equals(line))
							{
								xgoto = parameters.xclone();
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
		return xgoto;
	}
	
	protected XLine xclone(XEval xeval, String line, List<XScanner> xscanners) throws Exception
	{
		XLine xgoto = null;
		if(xisBlock())
		{
			boolean isFinal = false;
			while(xeval.xscanner().xhasNextLine() && isFinal == false)
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval.xscanner().xnextLine()))
				{
					try(XLine parameters = new XLine(current.x(), xeval, null))
					{
						String method = parameters.xmethod();
						if(method.isEmpty() == false)
						{
							if(method.equals(line))
							{
								xgoto = parameters.xclone();
							}
							else if(method.equals(XConstants.FINAL))
							{
								isFinal = true;
								xscanners.add(current.x().xclone());
							}
							else
							{
								xscanners.add(current.x().xclone());
							}
						}
					}
				}
			}
		}
		return xgoto;
	}
}
