package xproject.xap.xpart;

import xproject.xrmi.XRemote;

public interface XPart extends XRemote {

	void xpostConstruct() throws Exception;
	void xpreDestroy() throws Exception;
	void xonFocus() throws Exception;
	void xsave() throws Exception;
}
