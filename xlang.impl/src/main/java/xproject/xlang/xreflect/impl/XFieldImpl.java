package xproject.xlang.xreflect.impl;

import java.lang.reflect.Field;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XModifier;

public class XFieldImpl implements XField {

	private Field field;
	private XModifier modifiers;
	private XClass type;
	private XClass declaringClass;
	
	protected XFieldImpl(Field f)
	{
		field = f;
		modifiers = null;
		type = null;
		declaringClass = null;
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		if(modifiers == null)
			modifiers = XFactoryImpl.get().xModifier(field.getModifiers());
		return modifiers;
	}

	public XClass xgetType() {
		// TODO Auto-generated method stub
		if(type == null)
			type = XFactoryImpl.get().xClass(field.getType());
		return type;
	}

	public XObject xget(XObject object) throws Exception {
		// TODO Auto-generated method stub
		Object value = field.get(object.x());
					
		return XFactoryImpl.get().xObject(value);
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return field.getName();
	}

	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		if(declaringClass == null)
			declaringClass = XFactoryImpl.get().xClass(field.getDeclaringClass());
		return declaringClass;
	}
	
	public static XField xnew(Field field)
	{
		return new XFieldImpl(field);
	}
}
