package xproject.xscript.impl.model;

import java.util.ArrayList;
import java.util.Iterator;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.impl.XConstants;
import xproject.xscript.impl.XFutureObject;
import xproject.xutil.XScanner;

public class XParameters implements XRemote, AutoCloseable {

	private XEval xeval;
	private XScanner xscanner;
	private String xmethod;
	private String xthis;
	private String xclass;
	private String xreturn;
	private ArrayList<XObject> xparameters;
	private ArrayList<XClass> xparameterTypes;
	private ArrayList<String> xparameterNames;
	private ArrayList<String> xparameterValues;
	
	public XParameters(XScanner scanner, XEval eval, String method)
	{
		xeval = eval;
		xscanner = scanner;
		xmethod = method;
		xthis = null;
		xclass = null;
		xreturn = null;
		xparameters = null;
		xparameterTypes = null;
		xparameterNames = null;
		xparameterValues = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated xmethod stub
		xscanner = null;
		xeval = null;
		xmethod = null;
		xthis = null;
		xclass = null;
		xreturn = null;
		if(xparameters != null)
		{
			xparameters.clear();
			xparameters = null;
		}
		if(xparameterTypes != null)
		{
			xparameterTypes.clear();
			xparameterTypes = null;
		}
		if(xparameterNames != null)
		{
			xparameterNames.clear();
			xparameterNames = null;
		}
		if(xparameterValues != null)
		{
			xparameterValues.clear();
			xparameterValues = null;
		}
		finalize();
	}

	public String xmethod() throws Exception
	{
		if(xmethod == null)
		{
			for(xmethod = ""; xmethod.isEmpty() && xscanner.xhasNext(); xmethod = xscanner.xnext())
			{
			}
		}
		return xmethod;
	}
	
	public String xclass() throws Exception
	{
		xparameters();
		return xclass;
	}
	
	public String xthis() throws Exception
	{
		xparameters();
		return xthis;
	}
	
	public String xreturn() throws Exception
	{
		xparameters();
		return xreturn;
	}
	
	public XScanner xscanner()
	{
		return xscanner;
	}
	
	public Iterator<XObject> xparameters() throws Exception
	{
		if(xparameters == null)
		{
			xparameters = new ArrayList<XObject>();
			while(xnext())
			{
				
			}
		}
		return xparameters.iterator();
	}
	
	public Iterator<XClass> xparameterTypes() throws Exception
	{
		xparameters();
		if(xparameterTypes == null)
		{
			xparameterTypes = new ArrayList<XClass>();
			for(XObject object : xparameters)
			{
				if(object != null)
					xparameterTypes.add(object.xgetClass());
				else
					xparameterTypes.add(null);
			}
		}
		return xparameterTypes.iterator();
	}
	
	public Iterator<String> xparameterNames() throws Exception
	{
		xparameters();
		return xparameterNames.iterator();
	}
	
	public Iterator<String> xparameterValues() throws Exception
	{
		xparameters();
		return xparameterValues.iterator();
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated xmethod stub
		try {
			xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public XEval xeval()
	{
		return xeval;
	}
	
	public boolean xnext() throws Exception
	{
		if(xscanner == null)
			return false;
		
		if(xscanner.xhasNext())
		{
			if(xparameterNames == null)
			{
				xparameterNames = new ArrayList<String>();
			}
			if(xparameterValues == null)
			{
				xparameterValues = new ArrayList<String>();
			}
			String paramName = xscanner.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.CLASS))
				{
					if(xscanner.xhasNext())
					{
						String paramValue = xscanner.xnext();
						xclass = paramValue;
					}
				}
				else if(paramName.equals(XConstants.THIS))
				{
					if(xscanner.xhasNext())
					{
						String paramValue = xscanner.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								xthis = paramValue;
							}
						}
					}
				}
				else if(paramName.equals(XConstants.RETURN))
				{
					if(xscanner.xhasNext())
					{
						String paramValue = xscanner.xnext();
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(XConstants.OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(XConstants.OBJECT_REF_PREFIX.length());
								xreturn = paramValue;
							}
						}
					}
				}
				else
				{
					xparameterNames.add(paramName);
					if(xscanner.xhasNextBoolean())
					{
						boolean value = xscanner.xnextBoolean();
						xparameterValues.add(String.valueOf(value));
						xparameters.add(xeval.xfactory().xObject(value));
					}
					else if(xscanner.xhasNextByte())
					{
						byte value = xscanner.xnextByte();
						xparameterValues.add(String.valueOf(value));
						xparameters.add(xeval.xfactory().xObject(value));
					}
					else if(xscanner.xhasNextDouble())
					{
						double value = xscanner.xnextDouble();
						xparameterValues.add(String.valueOf(value));
						xparameters.add(xeval.xfactory().xObject(value));
					}
					else if(xscanner.xhasNextFloat())
					{
						float value = xscanner.xnextFloat();
						xparameterValues.add(String.valueOf(value));
						xparameters.add(xeval.xfactory().xObject(value));
					}
					else if(xscanner.xhasNextInt())
					{
						int value = xscanner.xnextInt();
						xparameterValues.add(String.valueOf(value));
						xparameters.add(xeval.xfactory().xObject(value));
					}
					else if(xscanner.xhasNextLong())
					{
						long value = xscanner.xnextLong();
						xparameterValues.add(String.valueOf(value));
						xparameters.add(xeval.xfactory().xObject(value));
					}
					else if(xscanner.xhasNextShort())
					{
						short value = xscanner.xnextShort();
						xparameterValues.add(String.valueOf(value));
						xparameters.add(xeval.xfactory().xObject(value));
					}
					else if(xscanner.xhasNext())
					{
						String value = xscanner.xnext();
						xparameterValues.add(value);
						if(value.startsWith(XConstants.OBJECT_REF_PREFIX))
						{
							value = value.substring(XConstants.OBJECT_REF_PREFIX.length());
							if(xeval.xbindings().xcontainsKey(value))
							{
								XObject xobject = xeval.xbindings().xget(value);
								if(xobject != null)
								{
									if(xobject instanceof XFutureObject)
									{
										xobject = ((XFutureObject)xobject).xfuture().xget();
									}
									xparameters.add(xobject);
								}
							}
						}
						else
						{
							xparameters.add(xeval.xfactory().xObject(value));
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	public XParameters xclone() throws Exception
	{
		XParameters other = new XParameters(xscanner.xclone(), xeval, null);
		other.xmethod();
		/*other.xeval = xeval;
		other.xscanner = xscanner;
		other.xmethod = xmethod;
		other.xthis = xthis;
		other.xclass = xclass;
		other.xreturn = xreturn;
		other.xparameters = xparameters;
		other.xparameterTypes = xparameterTypes;
		other.xparameterNames = xparameterNames;
		other.xparameterValues = xparameterValues;*/
		return other;
	}
}
