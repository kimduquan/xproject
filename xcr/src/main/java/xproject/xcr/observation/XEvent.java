package xproject.xcr.observation;

import java.util.Map;

import xproject.xrmi.XRemote;

public interface XEvent extends XRemote {
	long xgetDate() throws Exception;
	String xgetIdentifier() throws Exception;
	Map<?, ?> xgetInfo() throws Exception;
	String xgetPath() throws Exception;
	int xgetType() throws Exception;
	String xgetUserData() throws Exception;
	String xgetUserID() throws Exception;
}
