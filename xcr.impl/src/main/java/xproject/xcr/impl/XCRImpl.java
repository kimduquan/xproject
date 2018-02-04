package xproject.xcr.impl;

import xproject.x.impl.XImpl;
import xproject.xrmi.XRemote;

public class XCRImpl<R extends XRemote, Value> extends XImpl<R, Value, XFactory> {

	protected XCRImpl(Value value, XFactory factory) {
		super(value, factory);
		// TODO Auto-generated constructor stub
	}
	
	protected XCRImpl(Value value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

}
