package xproject.xcr.xretention;

import xproject.xrmi.XRemote;

public interface XHold extends XRemote {
	String xgetName() throws Exception;
	boolean xisDeep() throws Exception;
}
