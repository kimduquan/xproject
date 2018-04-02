package xproject.xutil.xconcurrent.impl;

import xproject.xlang.XRunnable;

public class RunnableImpl implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		try 
		{
			xrunnable.xrun();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	private XRunnable xrunnable;
	
	protected RunnableImpl(XRunnable runnable)
	{
		xrunnable = runnable;
	}
	
	public static Runnable xnew(XRunnable runnable)
	{
		return new RunnableImpl(runnable);
	}
	
	public XRunnable x()
	{
		return xrunnable;
	}
}
