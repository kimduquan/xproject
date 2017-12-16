package xproject.xlang;

import java.rmi.RemoteException;

import xproject.xrmi.XRemote;

public interface XPackage extends XRemote {

	String xgetName() throws RemoteException;
}
