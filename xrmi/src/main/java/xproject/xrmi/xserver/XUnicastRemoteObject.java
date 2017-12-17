package xproject.xrmi.xserver;

import java.rmi.RemoteException;

import xproject.xrmi.XRemote;

public interface XUnicastRemoteObject extends XRemote {

	XRemote xexportObject(XRemote object, int port) throws RemoteException;
}
