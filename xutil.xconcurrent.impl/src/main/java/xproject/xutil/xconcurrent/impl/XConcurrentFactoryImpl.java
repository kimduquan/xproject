package xproject.xutil.xconcurrent.impl;

import xproject.xutil.xconcurrent.XConcurrentFactory;
import xproject.xutil.xconcurrent.XExecutors;

public class XConcurrentFactoryImpl implements XConcurrentFactory {

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub

	}

	public XExecutors xExecutors() throws Exception {
		// TODO Auto-generated method stub
		return XExecutorsImpl.xnew();
	}

}
