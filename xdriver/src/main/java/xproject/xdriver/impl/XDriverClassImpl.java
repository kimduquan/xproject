package xproject.xdriver.impl;

import java.util.ArrayList;
import java.util.HashMap;

import xproject.xdriver.XDriverClass;
import xproject.xdriver.XDriverMethod;
import xproject.xdriver.XDriverObject;
import xproject.xdriver.XDriverParameter;
import xproject.xdriver.XDriverReturn;
import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XMethod;

public class XDriverClassImpl implements XDriverClass {

	private XClass xclass;
	private XObject xobject;
	private HashMap<String, XMethod> xmethods;
	
	protected void initializeMethods() throws Exception
	{
		if(xmethods == null)
		{
			xmethods = new HashMap<String, XMethod>();
			for(XMethod method : xclass.xgetMethods())
			{
				String name = method.xgetName();
				if(name.startsWith("get"))
				{
					name = name.substring(3);
					char[] chars = name.toCharArray();
					ArrayList<String> tokens = new ArrayList<String>();
					String temp = "";
					for(int i = 0; i < chars.length - 1; i++)
					{
						temp += chars[i];
						if(Character.isUpperCase(chars[i + 1]) && Character.isLowerCase(chars[i]))
						{
							tokens.add(temp.toLowerCase());
							temp = "";
						}
						else if(Character.isDigit(chars[i]) && Character.isLetter(chars[i + 1]))
						{
							tokens.add(temp.toLowerCase());
							temp = "";
						}
						else if(Character.isDigit(chars[i + 1]) && Character.isLetter(chars[i]))
						{
							tokens.add(temp.toLowerCase());
							temp = "";
						}
					}
					String key = String.join("-", tokens);
					if(key.isEmpty() == false)
					{
						xmethods.put(key, method);
					}
				}
			}
		}
	}
	
	public XDriverClassImpl(XClass cls, XObject object)
	{
		xclass = cls;
		xobject = object;
		xmethods = null;
		
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xclass = null;
		xobject = null;
		xmethods.clear();
		xmethods = null;
		finalize();
	}

	public XDriverObject xobject(String cls, String object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XDriverReturn xnew(XDriverParameter parameter) throws Exception {
		// TODO Auto-generated method stub
		XConstructor constructor = xclass.xgetConstructor(parameter.xtypes());
		XObject object = constructor.xnewInstance(parameter.values());
		return new XDriverReturnImpl(xclass, object);
	}

	public XDriverMethod xfield(String field) throws Exception {
		// TODO Auto-generated method stub
		initializeMethods();
		XMethod xmethod = xmethods.getOrDefault(field, null);
		if(xmethod != null)
		{
			return new XDriverMethodImpl(xmethod, xobject);
		}
		return null;
	}

}
