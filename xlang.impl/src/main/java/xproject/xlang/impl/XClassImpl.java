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
import xproject.xlang.xreflect.impl.XConstructorImpl;
import xproject.xlang.xreflect.impl.XFieldImpl;
import xproject.xlang.xreflect.impl.XMethodImpl;
import xproject.xlang.xreflect.impl.XModifierImpl;

public class XClassImpl implements XClass {
	
	private static HashMap<String, XClass> xclasses = new HashMap<String, XClass>();
	
	private Class<?> cls;
	private XField[] fields;
	private XMethod[] methods;
	private XConstructor[] constructors;
	private XModifier modifiers;
	
	protected XClassImpl(Class<?> cls)
	{
		this.cls = cls;
		initializeFields();
		initializeMethods();
		initializeConstructors();
		modifiers = new XModifierImpl(cls.getModifiers());
	}
	
	protected void initializeFields()
	{
		Field[] fs = cls.getFields();
		fields = new XField[fs.length];
		
		for(int i = 0; i < fs.length; i++)
		{
			fields[i] = XFieldImpl.xnew(fs[i]);
		}
	}
	
	protected void initializeMethods()
	{
		Method[] ms = cls.getMethods();
		methods = new XMethod[ms.length];
		
		for(int i = 0; i < ms.length; i++)
		{
			methods[i] = XMethodImpl.xnew(ms[i]);
		}
	}
	protected void initializeConstructors()
	{
		Constructor<?>[] cs = cls.getConstructors();
		constructors = new XConstructor[cs.length];
		
		for(int i = 0; i < cs.length; i++)
		{
			constructors[i] = XConstructorImpl.xnew(cs[i]);
		}
	}
	
	public static XClass xforName(String name) throws Exception
	{
		if(xclasses.containsKey(name))
			return xclasses.get(name);
		else
		{
			XClassImpl newClass = new XClassImpl(Class.forName(name));
			xclasses.put(name, newClass);
			return newClass;
		}
	}
	
	public static XClass xnew(Class<?> cls)
	{
		String name = cls.getName();
		if(xclasses.containsKey(name))
			return xclasses.get(name);
		
		XClassImpl newClass = new XClassImpl(cls);
		xclasses.put(name, newClass);
		return newClass;
	}

	public XField[] xgetFields() {
		// TODO Auto-generated method stub
		return fields;
	}

	public boolean xisPrimitive() {
		// TODO Auto-generated method stub
		return cls.isPrimitive();
	}

	public XMethod[] xgetMethods() {
		// TODO Auto-generated method stub
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
		try {
			return XClassImpl.xnew(cls.getComponentType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public XClass xgetSuperClass() {
		// TODO Auto-generated method stub
		Class<?> superCls = cls.getSuperclass();
		try {
			if(superCls != null)
				return XClassImpl.xnew(cls.getSuperclass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
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
	}

	public XConstructor[] xgetConstructors() {
		// TODO Auto-generated method stub
		return constructors;
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		return modifiers;
	}
}
