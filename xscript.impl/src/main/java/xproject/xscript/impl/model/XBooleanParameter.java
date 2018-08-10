package xproject.xscript.impl.model;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.impl.XConstants;

public class XBooleanParameter implements XRemote, AutoCloseable {

	private XLine xline;
	private boolean xboolean;
	
	public XBooleanParameter(XLine line)
	{
		xline = line;
		xboolean = false;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xline = null;
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
		xboolean = defaultValue;
		xline.xscanner();
		if(xline.xscanner().xhasNextBoolean())
		{
			xboolean = xline.xscanner().xnextBoolean();
		}
		else if(xline.xscanner().xhasNext())
		{
			String name = xline.xscanner().xnext();
			if(!name.isEmpty())
			{
				if(name.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					name = name.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(name.isEmpty() == false)
					{
						if(name.equals(XConstants.TRUE))
							xboolean = xtrue();
						else if(name.equals(XConstants.FALSE))
							xboolean = xfalse();
						else if(name.equals(XConstants.AND))
							xboolean = xand();
						else if(name.equals(XConstants.OR))
							xboolean = xor();
						else if(name.equals(XConstants.NOT))
							xboolean = xnot();
						else if(name.equals(XConstants.NULL))
							xboolean = xnull();
						else if(name.equals(XConstants.EQUALS))
							xboolean = xnull();
					}
				}
				else if(name.startsWith(XConstants.OBJECT_REF_PREFIX))
				{
					name = name.substring(XConstants.OBJECT_REF_PREFIX.length());
					if(!name.isEmpty())
					{
						if(xline.xeval().xbindings().xcontainsKey(name))
						{
							XObject xobject = xline.xeval().xbindings().xget(name);
							if(xobject.xequals(XObject.xnull) == false)
							{
								if(xobject.xgetClass().xgetName().equals("java.lang.Boolean"))
								{
									xboolean = (Boolean) xobject.x();
								}
							}
						}
					}
				}
			}
		}
		return xboolean;
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
	
	protected boolean xnull() throws Exception
	{
		if(xline.xscanner().xhasNext())
		{
			String name = xline.xscanner().xnext();
			if(!name.isEmpty())
			{
				if(name.startsWith(XConstants.OBJECT_REF_PREFIX))
				{
					name = name.substring(XConstants.OBJECT_REF_PREFIX.length());
					if(!name.isEmpty())
					{
						if(xline.xeval().xbindings().xcontainsKey(name))
						{
							XObject xobject = xline.xeval().xbindings().xget(name);
							return xobject.xequals(XObject.xnull);
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean xboolean()
	{
		return xboolean;
	}
}
