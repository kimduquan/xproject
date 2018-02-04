package xproject.x.impl;

import xproject.x.X;
import xproject.xrmi.XRemote;

public class XImpl<XValue extends XRemote, Value, Factory> implements X<XValue, Value, Factory> {

	private Value value;
	private Factory factory;
	
	protected XImpl(Value v)
	{
		value = v;
		factory = null;
	}
	
	protected XImpl(Value v, Factory f)
	{
		value = v;
		factory = f;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		value = null;
		factory = null;
		finalize();
	}

	public Value x() throws Exception {
		// TODO Auto-generated method stub
		return value;
	}
	
	@SuppressWarnings("unchecked")
	protected static <XValue1 extends XRemote, Value1> Value1 x(XValue1 remote) throws Exception
	{
		if(remote instanceof X)
		{
			X<?, ?, ?> x = (X<?, ?, ?>)remote;
			Object v = x.x();
			if(v != null)
				return (Value1) x.x();
		}
		return null;
	}
	
	protected static <XValue1 extends XRemote, Value1> void x(Value1[] values, XValue1[] remotes) throws Exception
	{
		for(int i = 0; i < values.length; i++)
		{
			values[i] = x(remotes[i]);
		}
	}
	
	public Factory xfactory() throws Exception
	{
		return factory;
	}
}
