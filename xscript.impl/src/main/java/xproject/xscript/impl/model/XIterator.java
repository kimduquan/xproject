package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xproject.xscript.impl.XConstants;
import xproject.xutil.XScanner;

public abstract class XIterator extends XCommand {

	protected XIterator(XParameters parameters, XEval eval, String stopLine) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xcache = new ArrayList<XParameters>();
		xstopLine = stopLine;
	}

	private List<XParameters> xcache;
	private String xstopLine;

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected XParameters xdo(XParameters parameters) throws Exception
	{
		String method = parameters.xmethod();
		if(method.isEmpty() == false)
		{
			
			if(method.equals(XConstants.FINAL) || method.equals(XConstants.CONTINUE) || method.equals(XConstants.BREAK) || method.equals(xstopLine))
			{
			}
			else
			{
				try(XCommand xcommand = xeval().xcommandFactory().xcommand(method, xeval(), parameters))
				{
					xcommand.xrun();
				}
				return null;
			}
		}
		return parameters;
	}
	
	protected XParameters xdo() throws Exception
	{
		Iterator<XParameters> it = xcache.iterator();
		ArrayList<XParameters> temp = new ArrayList<XParameters>();
		XParameters xstopLine = null;
		while(xeval().xscanner().xhasNextLine() && xstopLine == null && xeval().xisReturn() == false && xeval().xisFinal() == false);
		{
			if(it.hasNext())
			{
				XParameters parameters = it.next();
				xstopLine = xdo(parameters);
			}
			else
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval().xscanner().xnextLine()))
				{
					try(XParameters parameters = new XParameters(current.x(), xeval(), null))
					{
						xstopLine = xdo(parameters);
						temp.add(parameters.xclone());
					}
				}
			}
		}
		xcache.addAll(temp);
		return xstopLine;
	}
}
