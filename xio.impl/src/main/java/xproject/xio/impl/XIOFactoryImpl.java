package xproject.xio.impl;

import java.io.Writer;

import xproject.xio.XWriter;

public class XIOFactoryImpl implements XIOFactory {

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}

	public XWriter xWriter(Writer writer) throws Exception {
		// TODO Auto-generated method stub
		return XWriterImpl.xnew(writer);
	}

}
