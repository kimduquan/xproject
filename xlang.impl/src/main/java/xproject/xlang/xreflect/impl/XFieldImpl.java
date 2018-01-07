package xproject.xlang.xreflect.impl;

import java.lang.reflect.Field;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XModifier;

public class XFieldImpl implements XField {

	private Field field;
	private XModifier modifiers;
	private XClass type;
	private XClass declaringClass;
	private XFactory xfactory;
	
	protected XFieldImpl(Field f, XFactory xfactory)
	{
		field = f;
		modifiers = null;
		type = null;
		declaringClass = null;
		this.xfactory = xfactory;
	}

	public XModifier xgetModifiers() throws Exception {
		// TODO Auto-generated method stub
		if(modifiers == null)
			modifiers = xfactory.xModifier(field.getModifiers());
		return modifiers;
	}

	public XClass xgetType() throws Exception {
		// TODO Auto-generated method stub
		if(type == null)
			type = xfactory.xClass(field.getType());
		return type;
	}

	public XObject xget(XObject object) throws Exception {
		// TODO Auto-generated method stub
		Object value = field.get(object.x());
					
		return xfactory.xObject(value);
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return field.getName();
	}

	public XClass xgetDeclaringClass() throws Exception {
		// TODO Auto-generated method stub
		if(declaringClass == null)
			declaringClass = xfactory.xClass(field.getDeclaringClass());
		return declaringClass;
	}
	
	public static XField xnew(Field field, XFactory xfactory)
	{
		return new XFieldImpl(field, xfactory);
	}
}
