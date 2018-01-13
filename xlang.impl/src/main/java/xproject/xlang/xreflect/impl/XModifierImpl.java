package xproject.xlang.xreflect.impl;

import java.lang.reflect.Modifier;

import xproject.xlang.xreflect.XModifier;

public class XModifierImpl implements XModifier {

	private int modifiers;
	
	protected XModifierImpl(int m)
	{
		modifiers = m;
	}
	
	public boolean xisStatic() {
		// TODO Auto-generated method stub
		return Modifier.isStatic(modifiers);
	}

	public boolean xisPublic() {
		// TODO Auto-generated method stub
		return Modifier.isPublic(modifiers);
	}

	public boolean xisAbstract() {
		// TODO Auto-generated method stub
		return Modifier.isAbstract(modifiers);
	}

	public static XModifier xnew(int m)
	{
		return new XModifierImpl(m);
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}
}
