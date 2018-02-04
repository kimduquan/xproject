package xproject.xcr.xquery;

import xproject.xcr.XNode;
import xproject.xcr.XValue;
import xproject.xrmi.XRemote;

public interface XRow extends XRemote {
	XNode xgetNode() throws Exception;
	XNode xgetNode(String selectorName) throws Exception;
	String xgetPath() throws Exception;
	String xgetPath(String selectorName) throws Exception;
	double xgetScore() throws Exception;
	double xgetScore(String selectorName) throws Exception;
	XValue xgetValue(String columnName) throws Exception;
	XValue[] xgetValues() throws Exception;
}
