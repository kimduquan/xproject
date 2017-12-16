package xproject.xlang.xreflect;

import java.rmi.RemoteException;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XArray extends XRemote {

	XObject xget(int index) throws RemoteException;
	void xset(int index, XObject object) throws RemoteException;
	int xgetLength() throws RemoteException;
}
