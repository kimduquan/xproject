package xproject.xrmi.xserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import xproject.xrmi.XRemote;
import xproject.xrmi.xserver.XUnicastRemoteObject;

public class XUnicastRemoteObjectImpl implements XUnicastRemoteObject {

	private XUnicastRemoteObjectImpl()
	{
		
	}
	
	public XRemote xexportObject(XRemote object, int port) throws RemoteException {
		// TODO Auto-generated method stub
		return (XRemote) UnicastRemoteObject.exportObject(object, port);
	}

	public static XUnicastRemoteObject xnew()
	{
		return new XUnicastRemoteObjectImpl();
	}
}
