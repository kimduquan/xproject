package xproject.xlang;

import java.rmi.RemoteException;

import xproject.xrmi.XRemote;

public interface XObject extends XRemote {

	XClass xgetClass() throws RemoteException;
	String xtoString() throws RemoteException;
	int xhashCode() throws RemoteException;
	
	public static final XObject NULL = new XObject(){

		public XClass xgetClass() {
			// TODO Auto-generated method stub
			return null;
		}

		public String xtoString() {
			// TODO Auto-generated method stub
			return "";
		}

		public int xhashCode() {
			// TODO Auto-generated method stub
			return 0;
		}};
}
