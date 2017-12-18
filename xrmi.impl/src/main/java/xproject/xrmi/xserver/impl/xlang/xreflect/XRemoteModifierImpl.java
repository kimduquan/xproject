package xproject.xrmi.xserver.impl.xlang.xreflect;

import xproject.xlang.xreflect.XModifier;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

public class XRemoteModifierImpl extends XUnicastRemoteObject<XModifier> implements XModifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteModifierImpl(XModifier ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public boolean xisStatic() throws Exception {
		// TODO Auto-generated method stub
		return ref().xisStatic();
	}

	public boolean xisPublic() throws Exception {
		// TODO Auto-generated method stub
		return ref().xisPublic();
	}

	public boolean xisAbstract() throws Exception {
		// TODO Auto-generated method stub
		return ref().xisAbstract();
	}

}
