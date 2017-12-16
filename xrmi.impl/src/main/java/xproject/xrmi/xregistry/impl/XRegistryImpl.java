package xproject.xrmi.xregistry.impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import xproject.xrmi.XRemote;
import xproject.xrmi.xregistry.XRegistry;

public class XRegistryImpl implements XRegistry {

	private Registry registry = null;
	
	private XRegistryImpl(Registry reg)
	{
		registry = reg;
	}

	public void xbind(String name, XRemote remote) throws RemoteException, Exception {
		// TODO Auto-generated method stub
		registry.bind(name, remote);
		
	}
	
	public static XRegistry xnew()
	{
		try {
			return new XRegistryImpl(LocateRegistry.getRegistry());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void xrebind(String name, XRemote remote) throws RemoteException, Exception {
		// TODO Auto-generated method stub
		registry.rebind(name, remote);
	}

	public String[] xlist() throws RemoteException {
		// TODO Auto-generated method stub
		return registry.list();
	}

	public XRemote lookup(String name) throws RemoteException, Exception {
		// TODO Auto-generated method stub
		return (XRemote) registry.lookup(name);
	}

	public void xunbind(String name) throws RemoteException, Exception {
		// TODO Auto-generated method stub
		registry.unbind(name);
	}
}
