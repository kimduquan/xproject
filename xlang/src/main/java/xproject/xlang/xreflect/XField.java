package xproject.xlang.xreflect;

import java.rmi.RemoteException;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XField extends XRemote {

	XModifier xgetModifiers() throws RemoteException;
	XClass xgetType() throws RemoteException;
	XObject xget(XObject object) throws RemoteException, Exception;
	String xgetName() throws RemoteException;
	XClass xgetDeclaringClass() throws RemoteException;
}
