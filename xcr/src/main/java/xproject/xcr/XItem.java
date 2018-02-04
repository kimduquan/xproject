package xproject.xcr;

import xproject.xrmi.XRemote;

public interface XItem extends XRemote {

	XItem xgetAncestor(int depth) throws Exception;
	int xgetDepth() throws Exception;
	String xgetName() throws Exception;
	XNode xgetParent() throws Exception;
	String xgetPath() throws Exception;
	XSession xgetSession() throws Exception;
	boolean xisModified() throws Exception;
	boolean xisNew() throws Exception;
	boolean xisNode() throws Exception;
	boolean xisSame(XItem otherItem) throws Exception;
	void xrefresh(boolean keepChanges) throws Exception;
	void xremove() throws Exception;
}
