package xproject.xlang.xreflect;

import java.rmi.RemoteException;

import xproject.xrmi.XRemote;

public interface XModifier extends XRemote {
	boolean xisStatic() throws RemoteException;
	boolean xisPublic() throws RemoteException;
	boolean xisAbstract() throws RemoteException;
}
