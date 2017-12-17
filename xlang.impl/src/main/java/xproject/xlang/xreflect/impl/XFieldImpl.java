package xproject.xlang.xreflect.impl;

import java.lang.reflect.Field;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.impl.XClassImpl;
import xproject.xlang.impl.XObjectImpl;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XModifier;

public class XFieldImpl implements XField {

	private Field field;
	private XModifier modifiers;
	
	private XFieldImpl(Field f)
	{
		field = f;
		modifiers = XModifierImpl.xnew(f.getModifiers());
	}

	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		return modifiers;
	}

	public XClass xgetType() {
		// TODO Auto-generated method stub
		return XClassImpl.xnew(field.getType());
	}

	public XObject xget(XObject object) throws Exception {
		// TODO Auto-generated method stub
		Object value = null;
		Object obj = null;
		
		if(object instanceof XObjectImpl)
		{
			obj = ((XObjectImpl)object).get();
		}
		
		value = field.get(obj);
		
		if(value == null)
			return XObject.NULL;
		
		if(value.getClass().isArray())
			return XArrayImpl.xnew(value);
					
		return XObjectImpl.xnew(value);
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return field.getName();
	}

	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		return XClassImpl.xnew(field.getDeclaringClass());
	}
	
	public static XField xnew(Field field)
	{
		return XFieldImpl.xnew(field);
	}
}
