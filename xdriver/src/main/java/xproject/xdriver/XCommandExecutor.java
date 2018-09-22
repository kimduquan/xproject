package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XCommandExecutor extends XRemote {

	XResponse xexecute(XCommand command) throws Exception;
}
