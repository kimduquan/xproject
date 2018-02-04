package xproject.xcr.xquery;

import xproject.xcr.XNode;
import xproject.xrmi.XRemote;

public interface XQueryManager extends XRemote {
	XQuery xcreateQuery(String statement, String language) throws Exception;
	XQuery xgetQuery(XNode node) throws Exception;
	String[] xgetSupportedQueryLanguages() throws Exception;
}
