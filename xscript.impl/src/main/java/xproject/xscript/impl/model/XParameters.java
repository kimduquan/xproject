package xproject.xscript.impl.model;

import java.util.ArrayList;

import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xscript.impl.XConstants;
import xproject.xscript.impl.XFutureObject;
import xproject.xutil.XScanner;

public class XParameters implements XRemote, AutoCloseable {

	private XScanner xscanner;
	private XScanner current;
	private XFactory xfactory;
	private XBindings xbindings;
	private String method;
	private String xthis;
	private String xclass;
	private String xreturn;
	private XObject[] xparameters;
	private XClass[] xparameterTypes;
	private XClassLoader xclassLoader;
	
	public XParameters(XScanner scanner, XFactory factory, XBindings bindings, XClassLoader classLoader)
	{
		xscanner = scanner;
		current = null;
		xfactory = factory;
		xbindings = bindings;
		method = null;
		xthis = null;
		xclass = null;
		xreturn = null;
		xparameters = null;
		xparameterTypes = null;
		xclassLoader = classLoader;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xscanner = null;
		current = null;
		xfactory = null;
		xbindings = null;
		method = null;
		xthis = null;
		xclass = null;
		xreturn = null;
		xparameters = null;
		xparameterTypes = null;
		xclassLoader = null;
		finalize();
	}

	public String xmethod() throws Exception
	{
		if(method == null)
		{
			for(method = ""; method.isEmpty() && xscanner.xhasNext(); method = xscanner.xnext())
			{
			}
		}
		return method;
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
	
	public XScanner xcurrent()
	{
		return current;
	}
	
	public XFactory xfactory()
	{
		return xfactory;
	}
	
	public XBindings xbindings()
	{
		return xbindings;
	}
	
	public XClassLoader xclassLoader()
	{
		return xclassLoader;
	}
	
	public XObject[] xparameters() throws Exception
	{
		if(xparameters == null)
		{
			ArrayList<XObject> paramValues = new ArrayList<XObject>();
			if(xscanner.xhasNext())
			{
				String paramName = xscanner.xnext();
				if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
					if(xscanner.xhasNextBoolean())
					{
						paramValues.add(xfactory.xObject(xscanner.xnextBoolean()));
					}
					else if(xscanner.xhasNextByte())
					{
						paramValues.add(xfactory.xObject(xscanner.xnextByte()));
					}
					else if(xscanner.xhasNextDouble())
					{
						paramValues.add(xfactory.xObject(xscanner.xnextDouble()));
					}
					else if(xscanner.xhasNextFloat())
					{
						paramValues.add(xfactory.xObject(xscanner.xnextFloat()));
					}
					else if(xscanner.xhasNextInt())
					{
						paramValues.add(xfactory.xObject(xscanner.xnextInt()));
					}
					else if(xscanner.xhasNextLong())
					{
						paramValues.add(xfactory.xObject(xscanner.xnextLong()));
					}
					else if(xscanner.xhasNextShort())
					{
						paramValues.add(xfactory.xObject(xscanner.xnextShort()));
					}
					else if(xscanner.xhasNext())
					{
						String value = xscanner.xnext();
						if(value.startsWith(XConstants.OBJECT_REF_PREFIX))
						{
							value = value.substring(XConstants.OBJECT_REF_PREFIX.length());
							if(xbindings.xcontainsKey(value))
							{
								XObject xobject = xbindings.xget(paramName);
								if(xobject != null)
								{
									if(xobject instanceof XFutureObject)
									{
										xobject = ((XFutureObject)xobject).xfuture().xget();
									}
								}
								paramValues.add(xobject);
							}
						}
						else
						{
							paramValues.add(xfactory.xObject(value));
						}
					}
				}
			}
			xparameters = new XObject[paramValues.size()];
			xparameters = paramValues.toArray(xparameters);
		}
		return xparameters;
	}
	
	public XClass[] xparameterTypes() throws Exception
	{
		if(xparameterTypes == null && xparameters != null)
		{
			xparameterTypes = new XClass[xparameters.length];
			for(int i = 0; i < xparameterTypes.length; i++)
			{
				if(xparameters[i] != null)
					xparameterTypes[i] = xparameters[i].xgetClass();
			}
		}
		return xparameterTypes;
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
}
