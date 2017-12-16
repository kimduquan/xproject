package xproject.xrmi.xregistry;

import java.rmi.RemoteException;

import xproject.xrmi.XRemote;

public interface XRegistry extends XRemote {

	void xbind(String name, XRemote remote) throws RemoteException, Exception;
	void xrebind(String name, XRemote remote) throws RemoteException, Exception;
	String[] xlist() throws RemoteException;
	XRemote lookup(String name) throws RemoteException, Exception;
	void xunbind(String name) throws RemoteException, Exception;
}
