package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.impl.XConstants;

public class XBooleanParameter implements XRemote, AutoCloseable {

	private XParameters xparameters;
	private boolean xboolean;
	
	public XBooleanParameter(XParameters parameters)
	{
		xparameters = parameters;
		xboolean = false;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xparameters = null;
		finalize();
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean xboolean(boolean defaultValue) throws Exception
	{
		xparameters.xscanner();
		if(xparameters.xscanner().xhasNextBoolean())
		{
			return xparameters.xscanner().xnextBoolean();
		}
		else if(xparameters.xscanner().xhasNext())
		{
			String name = xparameters.xscanner().xnext();
			if(!name.isEmpty())
			{
				if(name.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					name = name.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(name.isEmpty() == false)
					{
						if(name.equals(XConstants.TRUE))
							return xtrue();
						else if(name.equals(XConstants.FALSE))
							return xfalse();
						else if(name.equals(XConstants.AND))
							return xand();
						else if(name.equals(XConstants.OR))
							return xor();
						else if(name.equals(XConstants.NOT))
							return xnot();
					}
				}
				else if(name.startsWith(XConstants.OBJECT_REF_PREFIX))
				{
					name = name.substring(XConstants.OBJECT_REF_PREFIX.length());
					if(!name.isEmpty())
					{
						if(xparameters.xeval().xbindings().xcontainsKey(name))
						{
							XObject xobject = xparameters.xeval().xbindings().xget(name);
							if(xobject.xequals(XObject.xnull) == false)
							{
								if(xobject.xgetClass().xgetName().equals("java.lang.Boolean"))
								{
									Boolean value = (Boolean) xobject.x();
									return value;
								}
							}
						}
					}
				}
			}
		}
		return defaultValue;
	}
	
	protected boolean xtrue() throws Exception
	{
		return xboolean(false);
	}
	
	protected boolean xfalse() throws Exception
	{
		return !xboolean(true);
	}
	
	protected boolean xand() throws Exception
	{
		boolean value1 = xboolean(false);
		boolean value2 = xboolean(false);
		return value1 && value2;
	}
	
	protected boolean xor() throws Exception
	{
		boolean value1 = xboolean(false);
		boolean value2 = xboolean(false);
		return value1 || value2;
	}
	
	protected boolean xnot() throws Exception
	{
		return !xboolean(true);
	}
}
