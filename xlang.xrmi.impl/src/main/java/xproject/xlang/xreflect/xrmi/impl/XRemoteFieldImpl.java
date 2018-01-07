/**
 * 
 */
package xproject.xlang.xreflect.xrmi.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XModifier;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;

/**
 * @author Admin
 *
 */
public class XRemoteFieldImpl extends XUnicastRemoteObject<XField> implements XField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XRemoteFieldImpl(XField ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see xproject.xlang.xreflect.XField#xgetModifiers()
	 */
	public XModifier xgetModifiers() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetModifiers();
	}

	/* (non-Javadoc)
	 * @see xproject.xlang.xreflect.XField#xgetType()
	 */
	public XClass xgetType() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetType();
	}

	/* (non-Javadoc)
	 * @see xproject.xlang.xreflect.XField#xget(xproject.xlang.XObject)
	 */
	public XObject xget(XObject object) throws Exception {
		// TODO Auto-generated method stub
		return ref().xget(object);
	}

	/* (non-Javadoc)
	 * @see xproject.xlang.xreflect.XField#xgetName()
	 */
	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetName();
	}

	/* (non-Javadoc)
	 * @see xproject.xlang.xreflect.XField#xgetDeclaringClass()
	 */
	public XClass xgetDeclaringClass() throws Exception {
		// TODO Auto-generated method stub
		return ref().xgetDeclaringClass();
	}

}
