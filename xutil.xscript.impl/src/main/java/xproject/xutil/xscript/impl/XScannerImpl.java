package xproject.xutil.xscript.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xproject.xutil.XScanner;

public class XScannerImpl implements XScanner {

	private Iterator<XScanner> xiterator;
	private List<XScanner> xlines;
	
	protected XScannerImpl(List<XScanner> lines) throws Exception
	{
		xclone(lines);
		xiterator = xlines.iterator();
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xiterator = null;
		finalize();
	}

	public XScanner xnextLine() throws Exception {
		// TODO Auto-generated method stub
		return xiterator.next();
	}

	public XScanner xuseDelimiter(String pattern) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean xhasNext() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public String xnext() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void xclose() throws Exception {
		// TODO Auto-generated method stub
		for(XScanner line : xlines)
		{
			line.xclose();
		}
		xlines.clear();
	}

	public boolean xhasNextBoolean() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xhasNextByte() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xhasNextDouble() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xhasNextFloat() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xhasNextInt() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xhasNextLong() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xhasNextShort() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xnextBoolean() throws Exception {
		// TODO Auto-generated method stub
		return false;
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

	public XScanner xclone() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static XScanner xnew(List<XScanner> lines) throws Exception
	{
		return new XScannerImpl(lines);
	}

	public boolean xhasNextLine() throws Exception {
		// TODO Auto-generated method stub
		return xiterator.hasNext();
	}
	
	protected void xclone(List<XScanner> lines) throws Exception
	{
		xlines = new ArrayList<XScanner>();
		for(XScanner line : lines)
		{
			xlines.add(line.xclone());
		}
	}
}
