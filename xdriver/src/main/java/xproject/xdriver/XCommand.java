package xproject.xdriver;

import java.util.Map;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XCommand extends XRemote {

	String xgetName() throws Exception;
	XSession xgetSession() throws Exception;
	Map<String, XObject> xgetParameters();
}
