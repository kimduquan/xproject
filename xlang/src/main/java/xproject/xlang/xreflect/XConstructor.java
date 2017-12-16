package xproject.xlang.xreflect;

import java.rmi.RemoteException;

import xproject.xlang.XClass;
import xproject.xrmi.XRemote;

public interface XConstructor extends XRemote {
	XClass xgetDeclaringClass() throws RemoteException;
	XModifier xgetModifiers() throws RemoteException;
	XParameter[] xgetParameters() throws RemoteException;
	int xgetParameterCount() throws RemoteException;
	XClass[] xgetParameterTypes() throws RemoteException;
}
