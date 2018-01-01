package xproject.xlang.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import xproject.xlang.XClass;
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
	
	protected void initializeFields()
	{
		Field[] fs = cls.getFields();
		fields = new XField[fs.length];
		
		for(int i = 0; i < fs.length; i++)
		{
			fields[i] = xfactory.xField(fs[i]);
		}
	}
	
	protected void initializeMethods()
	{
		Method[] ms = cls.getMethods();
		methods = new XMethod[ms.length];
		
		for(int i = 0; i < ms.length; i++)
		{
			methods[i] = xfactory.xMethod(ms[i]);
		}
	}
	protected void initializeConstructors()
	{
		Constructor<?>[] cs = cls.getConstructors();
		constructors = new XConstructor[cs.length];
		
		for(int i = 0; i < cs.length; i++)
		{
			constructors[i] = xfactory.xConstructor(cs[i]);
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

	public XField[] xgetFields() {
		// TODO Auto-generated method stub
		if(fields == null)
			initializeFields();
		return fields;
	}

	public boolean xisPrimitive() {
		// TODO Auto-generated method stub
		return cls.isPrimitive();
	}

	public XMethod[] xgetMethods() {
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

	public XClass xgetComponentType() {
		// TODO Auto-generated method stub
		if(componentType == null)
		{
			Class<?> type = cls.getComponentType();
			if(type != null)
				componentType = xfactory.xClass(type);
		}
		return componentType;
	}

	public XClass xgetSuperClass() {
		// TODO Auto-generated method stub
		if(superClass == null)
		{
			Class<?> superCls = cls.getSuperclass();
			if(superCls != null)
				superClass = xfactory.xClass(cls.getSuperclass());
		}
		return superClass;
	}

	public XConstructor[] xgetConstructors() {
		// TODO Auto-generated method stub
		if(constructors == null)
			initializeConstructors();
		return constructors;
	}

	public XModifier xgetModifiers() {
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
}
