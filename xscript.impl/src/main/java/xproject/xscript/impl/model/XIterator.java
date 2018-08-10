package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xproject.xscript.impl.XConstants;
import xproject.xutil.XScanner;

public abstract class XIterator extends XCommand {

	protected XIterator(XLine parameters, XEval eval, String stopLine) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		xcache = new ArrayList<XLine>();
		xstopLine = stopLine;
	}

	private List<XLine> xcache;
	private String xstopLine;

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected XLine xdo(XLine line) throws Exception
	{
		String method = line.xmethod();
		if(method.isEmpty() == false)
		{
			
			if(method.equals(XConstants.FINAL) || method.equals(XConstants.CONTINUE) || method.equals(XConstants.BREAK) || method.equals(xstopLine))
			{
			}
			else
			{
				try(XCommand xcommand = xeval().xcommandFactory().xcommand(method, xeval(), line))
				{
					xcommand.xrun();
				}
				return null;
			}
		}
		return line;
	}
	
	protected XLine xdo() throws Exception
	{
		Iterator<XLine> it = xcache.iterator();
		ArrayList<XLine> temp = new ArrayList<XLine>();
		XLine xstopLine = null;
		while(xeval().xscanner().xhasNextLine() && xstopLine == null && xeval().xisReturn() == false && xeval().xisFinal() == false);
		{
			if(it.hasNext())
			{
				XLine line = it.next();
				xstopLine = xdo(line);
			}
			else
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval().xscanner().xnextLine()))
				{
					try(XLine line = new XLine(current.x(), xeval(), null))
					{
						xstopLine = xdo(line);
						temp.add(line.xclone());
					}
				}
			}
		}
		xcache.addAll(temp);
		return xstopLine;
	}
}
