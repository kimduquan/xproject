package xproject.xcr.xquery;

import xproject.xcr.XNodeIterator;
import xproject.xrmi.XRemote;

public interface XQueryResult extends XRemote {
	String[] xgetColumnNames() throws Exception;
	XNodeIterator xgetNodes() throws Exception;
	XRowIterator xgetRows() throws Exception;
	String[] xgetSelectorNames() throws Exception;
}
