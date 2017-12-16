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
	
	protected XFieldImpl(Field f)
	{
		field = f;
		modifiers = new XModifierImpl(f.getModifiers());
	}

	@Override
	public XModifier xgetModifiers() {
		// TODO Auto-generated method stub
		return modifiers;
	}

	@Override
	public XClass xgetType() {
		// TODO Auto-generated method stub
		try {
			return XClassImpl.xnew(field.getType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
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
			return new XArrayImpl(value);
					
		return XObjectImpl.xnew(value);
	}

	@Override
	public String xgetName() {
		// TODO Auto-generated method stub
		return field.getName();
	}

	@Override
	public XClass xgetDeclaringClass() {
		// TODO Auto-generated method stub
		try {
			return XClassImpl.xnew(field.getDeclaringClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static XField xnew(Field field)
	{
		return new XFieldImpl(field);
	}
}
