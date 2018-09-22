package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XKeyboard extends XRemote {
	
	void xpressKey(CharSequence keyToPress) throws Exception;
	void xreleaseKey(CharSequence keyToRelease) throws Exception;
	void xsendKeys(CharSequence... keysToSend);
}
