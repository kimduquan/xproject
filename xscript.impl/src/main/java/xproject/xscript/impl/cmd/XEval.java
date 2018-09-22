package xproject.xscript.impl.cmd;

import java.util.Map;

import xproject.xlang.XRunnable;
import xproject.xscript.impl.XConstants;

public class XEval extends XEvaluatorImpl 
{

	public XEval(String name, XEvaluator parent, Map<String, XRunnable> runnables) throws Exception 
	{
		super(name, parent, runnables);
		// TODO Auto-generated constructor stub
		xaddRunnable(XConstants.RETURN, new XEvalReturn());
	}
}
