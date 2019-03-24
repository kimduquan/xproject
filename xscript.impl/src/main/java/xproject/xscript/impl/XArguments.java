package xproject.xscript.impl;

import xproject.xlang.XClass;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xutil.XScanner;

public class XArguments implements XRemote, AutoCloseable {

	private XScanner xscanner;
	
	public XArguments(XScanner scanner)
	{
		xscanner = scanner;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xscanner = null;
		finalize();
	}

	public String xfunction() throws Exception
	{
		return "";
	}
	
	public XObject xthis() throws Exception
	{
		return null;
	}
	
	public XClass xclass() throws Exception
	{
		return null;
	}
	
	public XObject[] xparameters() throws Exception
	{
		return null;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			xfinalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public XScanner xscanner() throws Exception
	{
		return xscanner;
	}
	
	public XArguments xclone() throws Exception
	{
		return null;
	}
}
