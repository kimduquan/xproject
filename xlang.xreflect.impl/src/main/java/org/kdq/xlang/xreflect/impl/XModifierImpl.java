package xproject.xlang.xreflect.impl;

import java.lang.reflect.Modifier;

import xproject.xlang.xreflect.XModifier;

public class XModifierImpl implements XModifier {

	private int modifiers;
	
	public XModifierImpl(int m)
	{
		modifiers = m;
	}
	
	@Override
	public boolean xisStatic() {
		// TODO Auto-generated method stub
		return Modifier.isStatic(modifiers);
	}

	@Override
	public boolean xisPublic() {
		// TODO Auto-generated method stub
		return Modifier.isPublic(modifiers);
	}

	@Override
	public boolean xisAbstract() {
		// TODO Auto-generated method stub
		return Modifier.isAbstract(modifiers);
	}

	
}
