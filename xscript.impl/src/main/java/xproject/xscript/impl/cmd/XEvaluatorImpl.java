package xproject.xscript.impl.cmd;

import java.util.HashMap;
import java.util.Map;

import xproject.xlang.XObject;
import xproject.xlang.XRunnable;
import xproject.xscript.impl.XBinding;
import xproject.xscript.impl.XContext;
import xproject.xscript.impl.XLine;
import xproject.xscript.impl.XScript;
import xproject.xutil.XScanner;

public abstract class XEvaluatorImpl implements XEvaluator {

	private Map<String, XRunnable> runnables;
	private Map<String, XRunnable> customRunnables;
	private XEvaluator parent;
	private String name;
	private XEvaluator active;
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}
	
	public XEvaluatorImpl(String name, XEvaluator parent, Map<String, XRunnable> runnables)
	{
		this.parent = parent;
		this.runnables = runnables;
		this.name = name;
		customRunnables = new HashMap<String, XRunnable>();
	}

	public XObject xeval(XScript script, XContext context, XBinding binding) throws Exception
	{
		XObject object = null;
		for(XLine currentLine = null; script.xhasNextLine(); currentLine = script.xnextLine())
		{
			XScanner scanner = currentLine.xscanner();
			if(scanner.xhasNext())
			{
				String methodName = xmethod(scanner);
				if(methodName.isEmpty() == false)
				{
					XRunnable runnable = null;
					for(XEvaluator eval = xgetActive(); eval != null; eval = eval.xgetParent())
					{
						runnable = eval.xgetRunnable(methodName);
						if(runnable != null)
							break;
					}
					if(runnable != null)
					{
						runnable.xrun();
					}
				}
			}
			currentLine.xclose();
			
			if(xgetActive() == null)
				break;
		}
		return object;
	}
	
	public void xsetActive(XEvaluator evaluator) throws Exception
	{
		active = evaluator;
	}
	
	public XEvaluator xgetParent() throws Exception
	{
		return parent;
	}
	
	public XEvaluator xgetActive() throws Exception
	{
		return active;
	} 
	
	public XRunnable xgetRunnable(String name) throws Exception
	{
		if(customRunnables.containsKey(name))
			return customRunnables.get(name);
		return runnables.getOrDefault(name, null);
	}
	
	protected String xmethod(XScanner currentLine) throws Exception
	{
		String methodName = currentLine.xnext();
		for(; methodName.isEmpty() && currentLine.xhasNext(); methodName = currentLine.xnext())
		{
		}
		return methodName;
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return name;
	}
	
	protected void xaddRunnable(String name, XRunnable runnable) throws Exception
	{
		customRunnables.put(name, runnable);
	}
}
