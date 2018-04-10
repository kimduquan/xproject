package xproject.xscript.impl;

public class Eval implements Runnable
{
	private XEvalTask xeval;
	
	protected Eval(XEvalTask eval)
	{
		xeval = eval;
	}
	
	public void run() 
	{
		try 
		{
			xeval.xrun();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
