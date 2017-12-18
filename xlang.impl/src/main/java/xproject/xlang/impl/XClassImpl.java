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
	
	protected XClassImpl(Class<?> cls)
	{
		this.cls = cls;
		fields = null;
		methods = null;
		constructors = null;
		modifiers = null;
		superClass = null;
		componentType = null;
	}
	
	protected void initializeFields()
	{
		Field[] fs = cls.getFields();
		fields = new XField[fs.length];
		
		for(int i = 0; i < fs.length; i++)
		{
			fields[i] = XFactoryImpl.get().xField(fs[i]);
		}
	}
	
	protected void initializeMethods()
	{
		Method[] ms = cls.getMethods();
		methods = new XMethod[ms.length];
		
		for(int i = 0; i < ms.length; i++)
		{
			methods[i] = XFactoryImpl.get().xMethod(ms[i]);
		}
	}
	protected void initializeConstructors()
	{
		Constructor<?>[] cs = cls.getConstructors();
		constructors = new XConstructor[cs.length];
		
		for(int i = 0; i < cs.length; i++)
		{
			constructors[i] = XFactoryImpl.get().xConstructor(cs[i]);
		}
	}
	
	public static XClass xforName(String name) throws Exception
	{
		if(xclasses.containsKey(name))
			return xclasses.get(name);
		else
		{
			XClass newClass = XFactoryImpl.get().xClass(Class.forName(name));
			return newClass;
		}
	}
	
	public static XClass xnew(Class<?> cls)
	{
		String name = cls.getName();
		if(xclasses.containsKey(name))
			return xclasses.get(name);
		
		XClass newClass = new XClassImpl(cls);
		xclasses.put(name, newClass);
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
				componentType = XFactoryImpl.get().xClass(type);
		}
		return componentType;
	}

	public XClass xgetSuperClass() {
		// TODO Auto-generated method stub
		if(superClass == null)
		{
			Class<?> superCls = cls.getSuperclass();
			if(superCls != null)
				superClass = XFactoryImpl.get().xClass(cls.getSuperclass());
		}
		return superClass;
	}
	
	/*
	public static boolean xisBoolean(XClass xclass)
	{
		return boolean.class.getName().equals(xclass.xgetName());
	}
	public static boolean xisByte(XClass xclass)
	{
		return byte.class.getName().equals(xclass.xgetName());
	}
	public static boolean xisDouble(XClass xclass)
	{
		return double.class.getName().equals(xclass.xgetName());
	}
	public static boolean xisFloat(XClass xclass)
	{
		return float.class.getName().equals(xclass.xgetName());
	}
	public static boolean xisInt(XClass xclass)
	{
		return int.class.getName().equals(xclass.xgetName());
	}
	public static boolean xisLong(XClass xclass)
	{
		return long.class.getName().equals(xclass.xgetName());
	}
	
	public static boolean xisShort(XClass xclass)
	{
		return short.class.getName().equals(xclass.xgetName());
	}
	
	public static boolean xisString(XClass xclass)
	{
		return String.class.getName().equals(xclass.xgetName());
	}*/

	public XConstructor[] xgetConstructors() {
		// TODO Auto-generated method stub
		if(constructors == null)
			initializeConstructors();
		return constructors;
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		if(modifiers == null)
			modifiers = XFactoryImpl.get().xModifier(cls.getModifiers());
		return modifiers;
	}
}
