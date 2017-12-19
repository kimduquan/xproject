package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import xproject.util.XScanner;
import xproject.util.impl.XScannerImpl;
import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;

public class XScriptEngineImpl implements XScriptEngine {

	private static final String THIS = "this";
	private static final String CLASS = "class";
	private static final String PACKAGE = "package";
	private static final String RETURN = "return";
	private static final String PARAMETER_NAME_PREFIX = "-";
	private static final String OBJECT_REF_PREFIX = "#";
	private static final String PARAMETER_SEPARATOR = "\t";
	
	private XObject xthis;
	private HashMap<String, XClass> importedClasses;
	
	protected XScriptEngineImpl()
	{
		xthis = XObject.NULL;
		importedClasses = new HashMap<String, XClass>();
	}
	
	public XObject xeval(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		xthis = XFactoryImpl.get().xObject(this);
		context.xgetBindings(XScriptContext.XENGINE_SCOPE).xput(THIS, xthis);

		XScanner inLineScanner = null;
		
		while(scanner.xhasNextLine())
		{
			String nextLine = scanner.xnextLine();
			inLineScanner = XScannerImpl.xnew("String", nextLine);
			inLineScanner.xuseDelimiter(PARAMETER_SEPARATOR);
			
			if(inLineScanner.xhasNext())
			{
				String methodName = inLineScanner.xnext();
				
				if(methodName.equals(RETURN))
					return xthis;
				
				xeval(methodName, inLineScanner, context);
				
			}
			
			inLineScanner.xclose();
			inLineScanner = null;
		}
		
		return xthis;
	}
	
	public XObject xeval(String method, XScanner inLineScanner, XScriptContext context) throws Exception
	{
		
		List<String> parameterNames = new ArrayList<String>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, String> specialParameters = new HashMap<String, String>();
		XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
		
		while(inLineScanner.xhasNext())
		{
			String parameterName = inLineScanner.xnext();
			
			if(parameterName.startsWith(PARAMETER_NAME_PREFIX))
				parameterName = parameterName.substring(1);

			if(parameterName.equals(CLASS) 
					|| parameterName.equals(THIS) 
					|| parameterName.equals(RETURN) 
					|| parameterName.equals(PACKAGE))
			{
				if(inLineScanner.xhasNext())
				{
					String parameterValue = inLineScanner.xnext();
					specialParameters.put(parameterName, parameterValue);
					continue;
				}	
			}
			else
			{
				parameterNames.add(parameterName);
				
				if(inLineScanner.xhasNextBoolean())
				{
					parameters.put(parameterName, inLineScanner.xnextBoolean());
				}
				else if(inLineScanner.xhasNextByte())
				{
					parameters.put(parameterName, inLineScanner.xnextByte());
				}
				else if(inLineScanner.xhasNextDouble())
				{
					parameters.put(parameterName, inLineScanner.xnextDouble());
				}
				else if(inLineScanner.xhasNextFloat())
				{
					parameters.put(parameterName, inLineScanner.xnextFloat());
				}
				else if(inLineScanner.xhasNextInt())
				{
					parameters.put(parameterName, inLineScanner.xnextInt());
				}
				else if(inLineScanner.xhasNextLong())
				{
					parameters.put(parameterName, inLineScanner.xnextLong());
				}
				else if(inLineScanner.xhasNextShort())
				{
					parameters.put(parameterName, inLineScanner.xnextShort());
				}
				else if(inLineScanner.xhasNext())
				{
					String parameterValue = inLineScanner.xnext();
					
					if(parameterValue.startsWith(OBJECT_REF_PREFIX))
					{
						parameterValue = parameterValue.substring(1);
						
						if(bindings.xcontainsKey(parameterValue))
						{
							parameters.put(parameterName, bindings.xget(parameterValue));
						}
					}
					else
					{
						parameters.put(parameterName, parameterValue);
					}	
				}
			}
			
		}

		
		XClass cls = null;
		XObject obj = null;
		String returnObj = null;
	
		if(specialParameters.containsKey(THIS))
		{
			String objName = specialParameters.get(THIS);
			if(objName.startsWith(OBJECT_REF_PREFIX))
			{
				objName = objName.substring(1);
				if(bindings.xcontainsKey(objName))
				{
					obj = bindings.xget(objName);
				}
			}
		}
		
		if(specialParameters.containsKey(CLASS))
		{
			String clsName = specialParameters.get(CLASS);
			if(importedClasses.containsKey(clsName))
			{
				cls = importedClasses.get(clsName);
			}
		}
		
		if(specialParameters.containsKey(RETURN))
		{
			returnObj = specialParameters.get(RETURN);
			if(returnObj.startsWith(OBJECT_REF_PREFIX))
			{
				returnObj = returnObj.substring(1);
			}
		}
		
		String[] names = new String[parameterNames.size()];
		parameterNames.toArray(names);
		
		return xthis;
	}
	
	public static XScriptEngine xnew()
	{
		return new XScriptEngineImpl();
	}
}
