package xproject.xio.impl;

import java.io.Writer;

import xproject.xio.XWriter;

public class XWriterImpl implements XWriter {

	private Writer writer;
	
	protected XWriterImpl(Writer w)
	{
		writer = w;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		writer = null;
		finalize();
	}

	public void xwrite(String str) throws Exception {
		// TODO Auto-generated method stub
		writer.write(str);
	}

	public void xflush() throws Exception {
		// TODO Auto-generated method stub
		writer.flush();
	}

	public void xclose() throws Exception {
		// TODO Auto-generated method stub
		writer.close();
	}

	public static XWriter xnew(Writer writer)
	{
		return XWriterImpl.xnew(writer);
	}
}
