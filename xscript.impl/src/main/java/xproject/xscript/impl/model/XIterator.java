package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xproject.xscript.impl.XConstants;
import xproject.xutil.XScanner;

public abstract class XIterator extends XCommand {

	protected XIterator(XParameters parameters, XEval eval) {
		super(parameters, eval);
		// TODO Auto-generated constructor stub
		isFinal = false;
		isBreak = false;
		isContinue = false;
		xcache = new ArrayList<XParameters>();
	}

	private boolean isFinal;
	private boolean isBreak;
	private boolean isContinue;
	private List<XParameters> xcache;

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
			
			if(method.equals(XConstants.FINAL))
			{
				isFinal = true;
			}
			else if(method.equals(XConstants.CONTINUE))
			{
				isContinue = true;
			}
			else if(method.equals(XConstants.BREAK))
			{
				isBreak = true;
			}
			else
			{
				try(XCommand xcommand = xeval().xcommandFactory().xcommand(method, xeval(), parameters))
				{
					xcommand.xrun();
				}
			}
		}
		return null;
	}
	
	protected XParameters xdo() throws Exception
	{
		Iterator<XParameters> it = xcache.iterator();
		ArrayList<XParameters> temp = new ArrayList<XParameters>();
		XParameters xwhile = null;
		while(xeval().xscanner().xhasNextLine() && xwhile == null && isBreak == false && isFinal == false && isContinue == false && xeval().xisReturn() == false && xeval().xisFinal() == false);
		{
			if(it.hasNext())
			{
				XParameters parameters = it.next();
				xwhile = xdo(parameters);
			}
			else
			{
				try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xeval().xscanner().xnextLine()))
				{
					try(XParameters parameters = new XParameters(current.x(), xeval(), null))
					{
						xwhile = xdo(parameters);
						temp.add(parameters.xclone());
					}
				}
			}
		}
		xcache.addAll(temp);
		return xwhile;
	}

}
