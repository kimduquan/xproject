package xproject.xscript.impl.model;

import java.util.ArrayList;

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
	private XClass[] xparameterTypes;
	
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
		xparameters = null;
		xparameterTypes = null;
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
		if(xclass == null)
		{
			xclass = "";
			if(xscanner.xhasNext())
			{
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
				}
			}
		}
		return xclass;
	}
	
	public String xthis() throws Exception
	{
		if(xthis == null)
		{
			xthis = "";
			if(xscanner.xhasNext())
			{
				String paramName = xscanner.xnext();
				if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(paramName.equals(XConstants.THIS))
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
				}
			}
		}
		return xthis;
	}
	
	public String xreturn() throws Exception
	{
		if(xreturn == null)
		{
			xreturn = "";
			if(xscanner.xhasNext())
			{
				String paramName = xscanner.xnext();
				if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(paramName.equals(XConstants.RETURN))
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
				}
			}
		}
		return xreturn;
	}
	
	public XScanner xscanner()
	{
		return xscanner;
	}
	
	public XObject[] xparameters() throws Exception
	{
		if(xparameters == null)
		{
			xparameters = new ArrayList<XObject>();
			if(xscanner.xhasNext())
			{
				String paramName = xscanner.xnext();
				if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(xscanner.xhasNextBoolean())
					{
						xparameters.add(xeval.xfactory().xObject(xscanner.xnextBoolean()));
					}
					else if(xscanner.xhasNextByte())
					{
						xparameters.add(xeval.xfactory().xObject(xscanner.xnextByte()));
					}
					else if(xscanner.xhasNextDouble())
					{
						xparameters.add(xeval.xfactory().xObject(xscanner.xnextDouble()));
					}
					else if(xscanner.xhasNextFloat())
					{
						xparameters.add(xeval.xfactory().xObject(xscanner.xnextFloat()));
					}
					else if(xscanner.xhasNextInt())
					{
						xparameters.add(xeval.xfactory().xObject(xscanner.xnextInt()));
					}
					else if(xscanner.xhasNextLong())
					{
						xparameters.add(xeval.xfactory().xObject(xscanner.xnextLong()));
					}
					else if(xscanner.xhasNextShort())
					{
						xparameters.add(xeval.xfactory().xObject(xscanner.xnextShort()));
					}
					else if(xscanner.xhasNext())
					{
						String value = xscanner.xnext();
						if(value.startsWith(XConstants.OBJECT_REF_PREFIX))
						{
							value = value.substring(XConstants.OBJECT_REF_PREFIX.length());
							if(xeval.xbindings().xcontainsKey(value))
							{
								XObject xobject = xeval.xbindings().xget(paramName);
								if(xobject != null)
								{
									if(xobject instanceof XFutureObject)
									{
										xobject = ((XFutureObject)xobject).xfuture().xget();
									}
								}
								xparameters.add(xobject);
							}
						}
						else
						{
							xparameters.add(xeval.xfactory().xObject(value));
						}
					}
				}
			}
			XObject[] parameters = new XObject[xparameters.size()];
			parameters = xparameters.toArray(parameters);
			return parameters;
		}
		return null;
	}
	
	public XClass[] xparameterTypes() throws Exception
	{
		if(xparameterTypes == null && xparameters != null)
		{
			xparameterTypes = new XClass[xparameters.size()];
			for(int i = 0; i < xparameterTypes.length; i++)
			{
				XObject object = xparameters.get(i);
				if(object != null)
					xparameterTypes[i] = object.xgetClass();
				else
					xparameterTypes[i] = null;
			}
		}
		return xparameterTypes;
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
	
	public String xstring(String name) throws Exception
	{
		String value = null;
		if(xscanner.xhasNext())
		{
			String paramName = xscanner.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(name != null)
				{
					if(name.equals(paramName))
					{
						value = xscanner.xnext();
					}
				}
			}
		}
		return value;
	}
	
	public boolean xnext() throws Exception
	{
		if(xscanner.xhasNext())
		{
			String paramName = xscanner.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(XConstants.RETURN))
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
				else if(paramName.equals(XConstants.CLASS))
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
				else if(xscanner.xhasNextBoolean())
				{
					xparameters.add(xeval.xfactory().xObject(xscanner.xnextBoolean()));
				}
				else if(xscanner.xhasNextByte())
				{
					xparameters.add(xeval.xfactory().xObject(xscanner.xnextByte()));
				}
				else if(xscanner.xhasNextDouble())
				{
					xparameters.add(xeval.xfactory().xObject(xscanner.xnextDouble()));
				}
				else if(xscanner.xhasNextFloat())
				{
					xparameters.add(xeval.xfactory().xObject(xscanner.xnextFloat()));
				}
				else if(xscanner.xhasNextInt())
				{
					xparameters.add(xeval.xfactory().xObject(xscanner.xnextInt()));
				}
				else if(xscanner.xhasNextLong())
				{
					xparameters.add(xeval.xfactory().xObject(xscanner.xnextLong()));
				}
				else if(xscanner.xhasNextShort())
				{
					xparameters.add(xeval.xfactory().xObject(xscanner.xnextShort()));
				}
				else if(xscanner.xhasNext())
				{
					String value = xscanner.xnext();
					if(value.startsWith(XConstants.OBJECT_REF_PREFIX))
					{
						value = value.substring(XConstants.OBJECT_REF_PREFIX.length());
						if(xeval.xbindings().xcontainsKey(value))
						{
							XObject xobject = xeval.xbindings().xget(paramName);
							if(xobject != null)
							{
								if(xobject instanceof XFutureObject)
								{
									xobject = ((XFutureObject)xobject).xfuture().xget();
								}
							}
							xparameters.add(xobject);
						}
					}
					else
					{
						xparameters.add(xeval.xfactory().xObject(value));
					}
				}
			}
			return true;
		}
		return false;
	}
	
	public XParameters xclone() throws Exception
	{
		XParameters other = new XParameters(xscanner, xeval, xmethod);
		other.xeval = xeval;
		other.xscanner = xscanner;
		other.xmethod = xmethod;
		other.xthis = xthis;
		other.xclass = xclass;
		other.xreturn = xreturn;
		other.xparameters = xparameters;
		other.xparameterTypes = xparameterTypes;
		return other;
	}
}
