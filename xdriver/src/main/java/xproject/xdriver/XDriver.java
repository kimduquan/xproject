package xproject.xdriver;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XDriver extends XRemote {

	void xclose() throws Exception;
	XObject xexecuteAsyncScript(String script, XObject... args) throws Exception;
	XObject xexecuteScript(String script, XObject... args) throws Exception;
	XElement xfindElement(XBy by) throws Exception;
	XElement[] xfindElements(XBy by) throws Exception;
	XNavigation xnavigate() throws Exception;
	XCommandExecutor xgetCommandExecutor() throws Exception;
	XCapabilities xgetCapabilities() throws Exception;
	String xgetCurrentUrl() throws Exception;
	XErrorHandler xgetErrorHandler() throws Exception;
	XFileDetector xgetFileDetector() throws Exception;
	XKeyboard xgetKeyboard() throws Exception;
	XMouse xgetMouse() throws Exception;
	String xgetSource() throws Exception;
	XFile xgetScreenShot() throws Exception;
	XSession xgetSession() throws Exception;
	String xgetTitle() throws Exception;
	String xgetHandle() throws Exception;
	String[] xgetHandles() throws Exception;
	XOptions xmanage() throws Exception;
}
