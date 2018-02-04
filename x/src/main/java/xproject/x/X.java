package xproject.x;

import xproject.xrmi.XRemote;

public interface X<XValue extends XRemote, Value, Factory> extends XRemote {

	Value x() throws Exception;
	
	Factory xfactory() throws Exception;
	
}
