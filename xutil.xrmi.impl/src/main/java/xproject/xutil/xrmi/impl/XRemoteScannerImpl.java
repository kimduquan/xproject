package xproject.xutil.xrmi.impl;

import xproject.xrmi.XRemote;
import xproject.xrmi.xserver.impl.XUnicastRemoteObject;
import xproject.xutil.XScanner;

public class XRemoteScannerImpl extends XUnicastRemoteObject<XScanner> implements XScanner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XRemoteScannerImpl(XScanner ref) throws Exception {
		super(ref);
		// TODO Auto-generated constructor stub
	}

	public boolean xhasNextLine() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextLine();
	}

	public XScanner xuseDelimiter(String pattern) throws Exception {
		// TODO Auto-generated method stub
		return xnew(ref().xuseDelimiter(pattern));
	}

	public boolean xhasNext() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNext();
	}

	public String xnext() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnext();
	}

	public void xclose() throws Exception {
		// TODO Auto-generated method stub
		ref().xclose();
	}

	public boolean xhasNextBoolean() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextBoolean();
	}

	public boolean xhasNextByte() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextByte();
	}

	public boolean xhasNextDouble() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextDouble();
	}

	public boolean xhasNextFloat() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextFloat();
	}

	public boolean xhasNextInt() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextInt();
	}

	public boolean xhasNextLong() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextLong();
	}

	public boolean xhasNextShort() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextShort();
	}

	public boolean xnextBoolean() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextBoolean();
	}

	public byte xnextByte() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextByte();
	}

	public double xnextDouble() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextDouble();
	}

	public float xnextFloat() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextFloat();
	}

	public int xnextInt() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextInt();
	}

	public long xnextLong() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextLong();
	}

	public short xnextShort() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextShort();
	}

	public static XScanner xnew(XScanner ref) throws Exception
	{
		return new XRemoteScannerImpl(ref);
	}

	public XScanner xclone() throws Exception {
		// TODO Auto-generated method stub
		return xnew(ref().xclone());
	}

	public XScanner xnextLine() throws Exception {
		// TODO Auto-generated method stub
		return xnew(ref().xnextLine());
	}
	
	public static boolean xunexportObject(XRemote xremote, boolean force) throws Exception
	{
		return XUnicastRemoteObject.unexportObject(xremote, force);
	}
}
