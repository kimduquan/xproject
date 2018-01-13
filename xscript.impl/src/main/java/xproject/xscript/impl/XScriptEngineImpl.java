package xproject.xscript.impl;

import java.util.ArrayList;
import java.util.HashMap;

import xproject.xlang.XClass;
import xproject.xlang.XException;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XArray;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XMethod;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;
import xproject.xscript.XScriptEngineEx;
import xproject.xutil.XScanner;

public class XScriptEngineImpl implements XScriptEngine, XScriptEngineEx {

	private static final String THIS = "this";
	private static final String NULL = "null";
	private static final String CLASS = "class";
	private static final String RETURN = "return";
	private static final String PARAMETER_NAME_PREFIX = "-";
	private static final String OBJECT_REF_PREFIX = "#";
	private static final String PARAMETER_SEPARATOR = "\t";
	
	private HashMap<String, XClass> importedClasses;
	
	private XFactory xfactory;
	private XRegistry xregistry;
	
	protected XScriptEngineImpl(XFactory factory, XRegistry registry)
	{
		importedClasses = new HashMap<String, XClass>();
		xfactory = factory;
		xregistry = registry;
	}
	
	public XObject xeval(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		context.xgetBindings(XScriptContext.XENGINE_SCOPE).xput(NULL, xfactory.xObject(null));
		
		XObject xobject = null;
		
		boolean isBreak = false;
		
		while(scanner.xhasNextLine() && isBreak == false)
		{
			XScanner temp = scanner.xnextLine();
			XScanner currentLine = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(currentLine.xhasNext())
			{
				String methodName = currentLine.xnext();
						
				for(; methodName.isEmpty() && currentLine.xhasNext(); methodName = currentLine.xnext())
				{
				}
				

				if(methodName.isEmpty() == false)
				{
					xobject = xeval(methodName, currentLine, scanner, context);
					
					if(methodName.equals(RETURN))
					{
						isBreak = true;
					}
				}
			}

			currentLine.xclose();
			xfactory.xfinalize(currentLine);
			
			if(isBreak)
			{
				break;
			}
		}
		
		return xobject;
	}
	
	public XObject xeval(String method, XScanner currentLine, XScanner scanner, XScriptContext context) throws Exception
	{
		XObject xobject = null;
		
		if(method.equals(IMPORT))
		{
			ximport(currentLine);
		}
		else if(method.equals(NEW))
		{
			xobject = xnew(currentLine, context);
		}
		else if(method.equals(RETURN))
		{
			xobject = xreturn(currentLine, context);
		}
		else if(method.equals(TRY))
		{
			xtry(scanner, context);
		}
		else if(method.equals(IF))
		{
			xif(currentLine, scanner, context);
		}
		else
		{
			xobject = xinvoke(method, scanner, context);
		}
			
		return xobject;
	}
	
	public static XScriptEngine xnew(XFactory xfactory, XRegistry registry)
	{
		return new XScriptEngineImpl(xfactory, registry);
	}

	public void ximport(XScanner currentLine) throws Exception {

		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(importedClasses.containsKey(paramValue) == false)
							{
								XClass xclass = (XClass) xregistry.xlookup(paramValue);
								
								if(xclass != null)
								{
									importedClasses.put(xclass.xgetSimpleName(), xclass);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public XObject xinvoke(String method, XScanner currentLine, XScriptContext context) throws Exception 
	{
		XObject xobject = null;
		
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX))
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(THIS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(paramValue.startsWith(OBJECT_REF_PREFIX))
							{
								paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
								XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
								if(bindings.xcontainsKey(paramValue))
								{
									xobject = bindings.xget(paramValue);
								}
							}
						}
					}
				}
			}
		}
		
		XClass xclass = null;
		
		if(xobject == null) 
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.startsWith(PARAMETER_NAME_PREFIX));
				{
					paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
					
					if(paramName.equals(CLASS))
					{
						if(currentLine.xhasNext())
						{
							String paramValue = currentLine.xnext();
							
							if(paramValue.isEmpty() == false)
							{
								if(importedClasses.containsKey(paramValue))
								{
									xclass = importedClasses.get(paramValue);
								}
							}
						}
					}
				}
			}
		}
		else
		{
			xclass = xobject.xgetClass();
		}
		

		ArrayList<XClass> xclasses = new ArrayList<XClass>();
		if(xclass != null)
		{
			xclasses.add(xclass);
		}
		else
		{
			xclasses.addAll(importedClasses.values());
		}
		
		
		ArrayList<XObject> paramValues = new ArrayList<XObject>();
		
		while(currentLine.xhasNext())
		{
			String name = currentLine.xnext();
			
			if(name.startsWith(PARAMETER_NAME_PREFIX))
			{
				name = name.substring(PARAMETER_NAME_PREFIX.length());
				
				if(currentLine.xhasNextBoolean())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextBoolean()));
				}
				else if(currentLine.xhasNextByte())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextByte()));
				}
				else if(currentLine.xhasNextDouble())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextDouble()));
				}
				else if(currentLine.xhasNextFloat())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextFloat()));
				}
				else if(currentLine.xhasNextInt())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextInt()));
				}
				else if(currentLine.xhasNextLong())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextLong()));
				}
				else if(currentLine.xhasNextShort())
				{
					paramValues.add(xfactory.xObject(currentLine.xnextShort()));
				}
				else if(currentLine.xhasNext())
				{
					String value = currentLine.xnext();
					
					if(value.startsWith(OBJECT_REF_PREFIX))
					{
						value = value.substring(OBJECT_REF_PREFIX.length());
						
						XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
						
						if(bindings.xcontainsKey(value))
						{
							paramValues.add(bindings.xget(value));
						}
					}
					else
					{
						paramValues.add(xfactory.xObject(value));
					}
				}
			}
		}
		
		XClass[] xparameterTypes = new XClass[paramValues.size()];
		for(int i = 0; i < xparameterTypes.length; i++)
		{
			xparameterTypes[i] = paramValues.get(i).xgetClass();
		}
		
		XMethod xmethod = null;
		for(XClass xcls : xclasses)
		{
			xmethod = xcls.xgetMethod(method, xparameterTypes);
			
			if(xmethod != null)
			{
				break;
			}
		}
		
		
		if(xmethod != null)
		{
			XObject[] xparameters = new XObject[paramValues.size()];
			xparameters = paramValues.toArray(xparameters);
			
			XObject xreturn = xmethod.xinvoke(xobject, xparameters);
			
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.startsWith(PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
					
					if(paramName.equals(RETURN))
					{
						if(currentLine.xhasNext())
						{
							String paramValue = currentLine.xnext();
							
							if(paramValue.isEmpty() == false)
							{
								if(paramValue.startsWith(OBJECT_REF_PREFIX))
								{
									paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
									
									XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
									
									bindings.xput(paramValue, xreturn);
									
									return xreturn;
								}
							}
						}
					}
				}
			}
		}
		
		return XObject.xnull;
	}

	

	public XObject xnew(XScanner currentLine, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
		XClass xclass = null;
		
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(importedClasses.containsKey(paramValue))
							{
								xclass = importedClasses.get(paramValue);
							}
						}
					}
				}
			}
		}
		

		if(xclass != null)
		{
			ArrayList<XObject> paramValues = new ArrayList<XObject>();
			
			while(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				if(paramName.startsWith(PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
					
					if(currentLine.xhasNextBoolean())
					{
						paramValues.add(xfactory.xObject(currentLine.xnextBoolean()));
					}
					else if(currentLine.xhasNextByte())
					{
						paramValues.add(xfactory.xObject(currentLine.xnextByte()));
					}
					else if(currentLine.xhasNextDouble())
					{
						paramValues.add(xfactory.xObject(currentLine.xnextDouble()));
					}
					else if(currentLine.xhasNextFloat())
					{
						paramValues.add(xfactory.xObject(currentLine.xnextFloat()));
					}
					else if(currentLine.xhasNextInt())
					{
						paramValues.add(xfactory.xObject(currentLine.xnextInt()));
					}
					else if(currentLine.xhasNextLong())
					{
						paramValues.add(xfactory.xObject(currentLine.xnextLong()));
					}
					else if(currentLine.xhasNextShort())
					{
						paramValues.add(xfactory.xObject(currentLine.xnextShort()));
					}
					else if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.startsWith(OBJECT_REF_PREFIX))
						{
							paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
							
							XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
							
							if(bindings.xcontainsKey(paramValue))
							{
								paramValues.add(bindings.xget(paramValue));
							}
						}
						else
						{
							paramValues.add(xfactory.xObject(paramValue));
						}
					}
				}
			}
			
			XClass[] xparameterTypes = new XClass[paramValues.size()];
			for(int i = 0; i < xparameterTypes.length; i++)
			{
				xparameterTypes[i] = paramValues.get(i).xgetClass();
			}
			
			XConstructor xconstructor = xclass.xgetConstructor(xparameterTypes);
			
			if(xconstructor != null)
			{
				XObject[] xparameters = new XObject[paramValues.size()];
				xparameters = paramValues.toArray(xparameters);
				
				XObject xreturn = xconstructor.xnewInstance(xparameters);
				
				if(currentLine.xhasNext())
				{
					String paramName = currentLine.xnext();
					
					if(paramName.startsWith(PARAMETER_NAME_PREFIX))
					{
						paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
						
						if(paramName.equals(RETURN))
						{
							if(currentLine.xhasNext())
							{
								String paramValue = currentLine.xnext();
								
								if(paramValue.isEmpty() == false)
								{
									if(paramValue.startsWith(OBJECT_REF_PREFIX))
									{
										paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
										
										XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
										
										bindings.xput(paramValue, xreturn);
										
										return xreturn;
									}
								}
							}
						}
					}
				}
			}
		}
		
		return XObject.xnull;
	}

	public XScanner xgoto(String line, XScanner scanner) throws Exception
	{
		XScanner foundLine = null;
		boolean isBreak = false;
		
		while(scanner.xhasNextLine() && isBreak == false)
		{
			XScanner temp = scanner.xnextLine();
			XScanner current = temp.xuseDelimiter(PARAMETER_SEPARATOR);
			xfactory.xfinalize(temp);
			
			if(current.xhasNext())
			{
				String methodName = current.xnext();
						
				for(; methodName.isEmpty() && current.xhasNext(); methodName = current.xnext())
				{
				}
				

				if(methodName.equals(line))
				{
					foundLine = current;
					isBreak = true;
				}
				
				if(methodName.equals(RETURN))
				{
					isBreak = true;
				}
			}
			
			if(isBreak == false)
			{
				current.xclose();
				xfactory.xfinalize(current);
			}
			else
			{
				break;
			}
		}
		return foundLine;
	}
	
	public void xtry(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			xeval(scanner, context);
		}
		catch(Exception ex)
		{
			XScanner catchLine = xgoto(CATCH, scanner);

			XException xexception = xfactory.xException(ex);
			
			if(catchLine != null)
			{
				xcatch( xexception, catchLine, scanner, context);
				catchLine.xclose();
				xfactory.xfinalize(catchLine);
			}
			else
			{
				xexception.xthrow();
			}
		}
	}

	public XObject xcatch(XException exception, XScanner currentLine, XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
		XClass xclass = null;
		
		if(currentLine.xhasNext())
		{
			String paramName = currentLine.xnext();
			
			if(paramName.startsWith(PARAMETER_NAME_PREFIX));
			{
				paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
				
				if(paramName.equals(CLASS))
				{
					if(currentLine.xhasNext())
					{
						String paramValue = currentLine.xnext();
						
						if(paramValue.isEmpty() == false)
						{
							if(importedClasses.containsKey(paramValue))
							{
								xclass = importedClasses.get(paramValue);
							}
						}
					}
				}
			}
		}
		
		XObject xobject = null;
		
		if(xclass != null)
		{
			if(xclass.xisAssignableFrom(exception.xgetClass()))
			{
				xobject = exception;
			}
			else
			{
				XScanner nextCatchLine = xgoto(CATCH, scanner);

				if(nextCatchLine != null)
				{
					xobject = xcatch(exception, nextCatchLine, scanner, context);
					nextCatchLine.xclose();
					xfactory.xfinalize(nextCatchLine);
				}
				else
				{
					exception.xthrow();
				}
			}
		}
		else
		{
			xobject = exception;
		}
		
		if(xobject != null)
		{
			if(currentLine.xhasNext())
			{
				String paramName = currentLine.xnext();
				
				if(paramName.startsWith(PARAMETER_NAME_PREFIX))
				{
					paramName = paramName.substring(PARAMETER_NAME_PREFIX.length());
					
					if(paramName.equals(RETURN))
					{
						if(currentLine.xhasNext())
						{
							String paramValue = currentLine.xnext();
							
							if(paramValue.isEmpty() == false)
							{
								if(paramValue.startsWith(OBJECT_REF_PREFIX))
								{
									paramValue = paramValue.substring(OBJECT_REF_PREFIX.length());
									
									XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
									
									bindings.xput(paramValue, xobject);
								}
							}
						}
					}
				}
			}
		}
		
		return xobject;
	}
	
	public boolean xif(XScanner currentLine, XScriptContext context) throws Exception
	{
		if(currentLine.xhasNext())
		{
			String methodName = currentLine.xnext();
			
			if(methodName.isEmpty() == false)
			{
				XObject xobject = null;
				
				if(methodName.startsWith(OBJECT_REF_PREFIX))
				{
					methodName = methodName.substring(OBJECT_REF_PREFIX.length());
					
					XBindings bindings = context.xgetBindings(XScriptContext.XGLOBAL_SCOPE);
					
					if(bindings.xcontainsKey(methodName))
					{
						xobject = bindings.xget(methodName);
					}
				}
				else
				{
					xobject = xinvoke(methodName, currentLine, context);
				}
				
				if(xobject != null)
				{
					if(xobject.xequals(XObject.xnull) == false)
					{
						if(xobject.xgetClass().xgetName().equals("java.lang.Boolean"))
						{
							Boolean b = (Boolean) xobject.x();
							
							return b;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean xif(XScanner currentLine, XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		boolean b = xif(currentLine, context);
		if(b)
		{
			xeval(scanner, context);
		}
		else
		{
			XScanner elseLine = xgoto(ELSE, scanner);
			if(elseLine != null)
			{
				xelse(scanner, context);
				
				elseLine.xclose();
				xfactory.xfinalize(elseLine);
			}
		}
		return b;
	}

	public void xelse(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		xeval(scanner, context);
	}

	public void xwhile(XScanner currentLine, XScanner scanner, XScanner[] lines, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void xbreak(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void xfor(XArray array, XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public XObject xreturn(XScanner scanner, XScriptContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		importedClasses.clear();
		importedClasses = null;
		xfactory = null;
		xregistry = null;
		finalize();
	}
}
