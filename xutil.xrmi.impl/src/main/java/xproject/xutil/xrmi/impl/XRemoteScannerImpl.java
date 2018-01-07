package xproject.xutil.xrmi.impl;

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

	public XScanner xnextLine(String sep) throws Exception {
		// TODO Auto-generated method stub
		return xnew(ref().xnextLine(sep));
	}

	public boolean xhasNextLine() throws Exception {
		// TODO Auto-generated method stub
		return ref().xhasNextLine();
	}

	public String xnextLine() throws Exception {
		// TODO Auto-generated method stub
		return ref().xnextLine();
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
		return 0;
	}

	public double xnextDouble() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public float xnextFloat() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int xnextInt() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public long xnextLong() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public short xnextShort() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public static XScanner xnew(XScanner ref) throws Exception
	{
		return new XRemoteScannerImpl(ref);
	}
}
