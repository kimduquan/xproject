package xproject.xlang;

import java.rmi.RemoteException;

import xproject.xlang.xreflect.XConstructor;
import xproject.xlang.xreflect.XField;
import xproject.xlang.xreflect.XMethod;
import xproject.xlang.xreflect.XModifier;
import xproject.xrmi.XRemote;

public interface XClass extends XRemote {

	XField[] xgetFields() throws RemoteException;
	boolean xisPrimitive() throws RemoteException;
	XMethod[] xgetMethods() throws RemoteException;
	String xgetSimpleName() throws RemoteException;
	String xgetName() throws RemoteException;
	boolean xisArray() throws RemoteException;
	XClass xgetComponentType() throws RemoteException;
	XClass xgetSuperClass() throws RemoteException;
	XConstructor[] xgetConstructors() throws RemoteException;
	XModifier xgetModifiers() throws RemoteException;
	static final String XOBJECT_CLASS_NAME = "java.lang.Object";
}
