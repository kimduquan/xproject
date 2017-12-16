package xproject.xlang.xreflect;

import java.rmi.RemoteException;

import xproject.xlang.XClass;
import xproject.xrmi.XRemote;

public interface XParameter extends XRemote {

	String xgetName() throws RemoteException;
	XClass xgetType() throws RemoteException;
}
