package xproject.xrmi.xserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import xproject.xrmi.xserver.XUnicastRemoteObject;

public class XUnicastRemoteObjectImpl extends UnicastRemoteObject implements XUnicastRemoteObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XUnicastRemoteObjectImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
