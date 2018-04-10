package xproject.xscript.impl;

import java.util.ArrayList;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xscript.XBindings;
import xproject.xutil.XScanner;

public class XLineImpl implements XLine 
{
	private XScanner xscanner;
	private long number;
	
	protected XLineImpl(long n, XScanner scanner)
	{
		xscanner = scanner;
		number = n;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xscanner.xfinalize();
		xscanner = null;
		finalize();
	}

	public long xlineNumber() throws Exception {
		// TODO Auto-generated method stub
		return number;
	}

	public static XLine xnew(long n, XScanner scanner)
	{
		return new XLineImpl(n, scanner);
	}

	public XScanner xscanner() throws Exception {
		// TODO Auto-generated method stub
		return xscanner;
	}

	public void xclose() throws Exception {
		// TODO Auto-generated method stub
		xscanner.xclose();
	}

	public String xmethod() throws Exception {
		// TODO Auto-generated method stub
		String methodName;
		for(methodName = ""; methodName.isEmpty() && xscanner.xhasNext(); methodName = xscanner.xnext())
		{
		}
		return methodName;
	}

	public boolean xhasNextParam(String name) throws Exception {
		// TODO Auto-generated method stub
		if(xscanner.xhasNext())
		{
			String paramName = xscanner.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(paramName.equals(name))
				{
					return true;
				}
			}
		}
		return false;
	}

	public Object xnextParam() throws Exception {
		// TODO Auto-generated method stub
		if(xscanner.xhasNextBoolean())
		{
			return xscanner.xnextBoolean();
		}
		else if(xscanner.xhasNextByte())
		{
			return xscanner.xnextByte();
		}
		else if(xscanner.xhasNextDouble())
		{
			return xscanner.xnextDouble();
		}
		else if(xscanner.xhasNextFloat())
		{
			return xscanner.xnextFloat();
		}
		else if(xscanner.xhasNextInt())
		{
			return xscanner.xnextInt();
		}
		else if(xscanner.xhasNextLong())
		{
			return xscanner.xnextLong();
		}
		else if(xscanner.xhasNextShort())
		{
			return xscanner.xnextShort();
		}
		else if(xscanner.xhasNext())
		{
			return xscanner.xnext();
		}
		return null;
	}

	public XObject xnextObjectParam(XBindings bindings) throws Exception 
	{
		String value = (String)xnextParam();
		if(value != null)
		{
			if(value.startsWith(XConstants.OBJECT_REF_PREFIX))
			{
				value = value.substring(XConstants.OBJECT_REF_PREFIX.length());
				if(bindings.xcontainsKey(value))
				{
					return bindings.xget(value);
				}
			}
		}
		return null;
	}

	public XClass xnextClassParam(XBinding binding) throws Exception {
		// TODO Auto-generated method stub
		String value = (String)xnextParam();
		if(value != null)
		{
			if(value.startsWith(XConstants.CLASS_REF_PREFIX))
			{
				value = value.substring(XConstants.CLASS_REF_PREFIX.length());
				if(binding.xhasClass(value))
				{
					return binding.xgetClass(value);
				}
			}
		}
		return null;
	}

	public boolean xhasNextParam() throws Exception {
		// TODO Auto-generated method stub
		if(xscanner.xhasNext())
		{
			String paramName = xscanner.xnext();
			if(paramName.startsWith(XConstants.PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				return true;
			}
		}
		return false;
	}

	public XObject[] xparameter(XBindings bindings, XFactory factory) throws Exception
	{
		ArrayList<XObject> paramValues = new ArrayList<XObject>();
		while(xscanner.xhasNext())
		{
			String name = xscanner.xnext();
			if(name.startsWith(XConstants.PARAMETER_NAME_PREFIX))
			{
				name = name.substring(XConstants.PARAMETER_NAME_PREFIX.length());
				if(xscanner.xhasNextBoolean())
				{
					paramValues.add(factory.xObject(xscanner.xnextBoolean()));
				}
				else if(xscanner.xhasNextByte())
				{
					paramValues.add(factory.xObject(xscanner.xnextByte()));
				}
				else if(xscanner.xhasNextDouble())
				{
					paramValues.add(factory.xObject(xscanner.xnextDouble()));
				}
				else if(xscanner.xhasNextFloat())
				{
					paramValues.add(factory.xObject(xscanner.xnextFloat()));
				}
				else if(xscanner.xhasNextInt())
				{
					paramValues.add(factory.xObject(xscanner.xnextInt()));
				}
				else if(xscanner.xhasNextLong())
				{
					paramValues.add(factory.xObject(xscanner.xnextLong()));
				}
				else if(xscanner.xhasNextShort())
				{
					paramValues.add(factory.xObject(xscanner.xnextShort()));
				}
				else if(xscanner.xhasNext())
				{
					String value = xscanner.xnext();
					if(value.startsWith(XConstants.OBJECT_REF_PREFIX))
					{
						value = value.substring(XConstants.OBJECT_REF_PREFIX.length());
						if(bindings.xcontainsKey(value))
						{
							paramValues.add(bindings.xget(value));
						}
					}
					else
					{
						paramValues.add(factory.xObject(value));
					}
				}
			}
		}
		XObject[] xparameters = new XObject[paramValues.size()];
		xparameters = paramValues.toArray(xparameters);
		return xparameters;
	}

	@Override
	public XLine xclone() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass xnextClassParam(XContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
