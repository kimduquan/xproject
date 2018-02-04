package xproject.xcr.xquery;

import xproject.xcr.XNode;
import xproject.xcr.XValue;
import xproject.xrmi.XRemote;

public interface XQuery extends XRemote {
	void xbindValue(String varName, XValue value) throws Exception;
	XQueryResult xexecute() throws Exception;
	String[] xgetBindVariableNames() throws Exception;
	String xgetLanguage() throws Exception;
	String xgetStatement() throws Exception;
	String xgetStoredQueryPath() throws Exception;
	void xsetLimit(long limit) throws Exception;
	void xsetOffset(long offset) throws Exception;
	XNode xstoreAsNode(String absPath) throws Exception;
}
