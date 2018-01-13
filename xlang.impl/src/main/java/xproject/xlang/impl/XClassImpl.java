package xproject.xlang.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;

public class XClassImpl implements XClass {
	
	private static HashMap<String, XClass> xclasses = new HashMap<String, XClass>();
	
	private Class<?> cls;
	private XField[] fields;
	private XMethod[] methods;
	private XConstructor[] constructors;
	private XModifier modifiers;
	private XClass superClass;
	private XClass componentType;
	private XFactory xfactory;
	
	protected XClassImpl(Class<?> cls, XFactory factory)
	{
		this.cls = cls;
		fields = null;
		methods = null;
		constructors = null;
		modifiers = null;
		superClass = null;
		componentType = null;
		xfactory = factory;
	}
	
	protected void initializeFields() throws Exception
	{
		Field[] fs = cls.getFields();
		fields = new XField[fs.length];
		
		for(int i = 0; i < fs.length; i++)
		{
			fields[i] = xfactory.xField(fs[i]);
		}
	}
	
	protected void initializeMethods() throws Exception
	{
		Method[] ms = cls.getMethods();
		methods = new XMethod[ms.length];
		
		for(int i = 0; i < ms.length; i++)
		{
			methods[i] = xfactory.xMethod(ms[i]);
		}
	}
	protected void initializeConstructors() throws Exception
	{
		Constructor<?>[] cs = cls.getConstructors();
		constructors = new XConstructor[cs.length];
		
		for(int i = 0; i < cs.length; i++)
		{
			constructors[i] = xfactory.xConstructor(cs[i]);
		}
	}
	
	protected void uninitializeFields() throws Exception
	{
		if(fields != null)
		{
			for(int i = 0; i < fields.length; i++)
			{
				xfactory.xfinalize(fields[i]);
			}
			fields = null;
		}
	}
	
	protected void uninitializeMethods() throws Exception
	{
		if(methods != null)
		{
			for(int i = 0; i < methods.length; i++)
			{
				xfactory.xfinalize(methods[i]);
			}
			methods = null;
		}
	}
	protected void uninitializeConstructors() throws Exception
	{
		if(constructors != null)
		{
			for(int i = 0; i < constructors.length; i++)
			{
				xfactory.xfinalize(constructors[i]);
			}
			constructors = null;
		}
	}
	public static XClass xforName(String name, XFactory xfactory) throws Exception
	{
		if(xclasses.containsKey(name))
			return xclasses.get(name);
		else
		{
			Class<?> cls = Class.forName(name);
			name = cls.getName();
			XClass newClass = xfactory.xClass(cls);
			xclasses.put(name, newClass);
			return newClass;
		}
	}
	
	public static XClass xnew(Class<?> cls, XFactory xfactory)
	{
		XClass newClass = new XClassImpl(cls, xfactory);
		return newClass;
	}

	public XField[] xgetFields() throws Exception {
		// TODO Auto-generated method stub
		if(fields == null)
			initializeFields();
		return fields;
	}

	public boolean xisPrimitive() {
		// TODO Auto-generated method stub
		return cls.isPrimitive();
	}

	public XMethod[] xgetMethods() throws Exception {
		// TODO Auto-generated method stub
		if(methods == null)
			initializeMethods();
		return methods;
	}

	public String xgetSimpleName() {
		// TODO Auto-generated method stub
		return cls.getSimpleName();
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return cls.getName();
	}

	public boolean xisArray() {
		// TODO Auto-generated method stub
		return cls.isArray();
	}

	public XClass xgetComponentType() throws Exception {
		// TODO Auto-generated method stub
		if(componentType == null)
		{
			Class<?> type = cls.getComponentType();
			if(type != null)
				componentType = xfactory.xClass(type);
		}
		return componentType;
	}

	public XClass xgetSuperClass() throws Exception {
		// TODO Auto-generated method stub
		if(superClass == null)
		{
			Class<?> superCls = cls.getSuperclass();
			if(superCls != null)
				superClass = xfactory.xClass(cls.getSuperclass());
		}
		return superClass;
	}

	public XConstructor[] xgetConstructors() throws Exception {
		// TODO Auto-generated method stub
		if(constructors == null)
			initializeConstructors();
		return constructors;
	}

	public XModifier xgetModifiers() throws Exception {
		// TODO Auto-generated method stub
		if(modifiers == null)
			modifiers = xfactory.xModifier(cls.getModifiers());
		return modifiers;
	}

	public XMethod xgetMethod(String name, XClass[] parameterTypes) throws Exception
	{
		// TODO Auto-generated method stub
		Class<?>[] classes = new Class<?>[parameterTypes.length];
		for(int i = 0; i< classes.length; i++)
		{
			classes[i] = parameterTypes[i].x();
		}
		Method mt = cls.getMethod(name, classes);
		
		if(mt != null)
			return xfactory.xMethod(mt);
		
		return null;
	}

	public Class<?> x() {
		// TODO Auto-generated method stub
		return cls;
	}

	public XConstructor xgetConstructor(XClass[] parameterTypes) throws Exception {
		// TODO Auto-generated method stub
		Class<?>[] classes = new Class<?>[parameterTypes.length];
		for(int i = 0; i< classes.length; i++)
		{
			classes[i] = parameterTypes[i].x();
		}
		Constructor<?> ct = cls.getConstructor(classes);
		
		if(ct != null)
			return xfactory.xConstructor(ct);
		
		return null;
	}

	public boolean xisAssignableFrom(XClass xclass) throws Exception {
		// TODO Auto-generated method stub
		return cls.isAssignableFrom(xclass.x());
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		cls = null;
		
		uninitializeFields();
		uninitializeMethods();
		uninitializeConstructors();
		
		if(modifiers != null)
		{
			xfactory.xfinalize(modifiers);
			modifiers = null;
		}
		
		if(superClass != null)
		{
			xfactory.xfinalize(superClass);
			superClass = null;
		}
		
		if(componentType != null)
		{
			xfactory.xfinalize(componentType);
			componentType = null;
		}
		
		xfactory = null;
		finalize();
	}
}
