package xproject.xcr.xversion;

import xproject.xcr.XNode;
import xproject.xcr.XNodeIterator;
import xproject.xrmi.XRemote;

public interface XVersionHistory extends XNode, XRemote {
	void xaddVersionLabel(String versionName, String label, boolean moveLabel) throws Exception;
	XNodeIterator xgetAllFrozenNodes() throws Exception;
	XNodeIterator xgetAllLinearFrozenNodes() throws Exception;
	XVersionIterator xgetAllLinearVersions() throws Exception;
	XVersionIterator xgetAllVersions() throws Exception;
	XVersion xgetRootVersion() throws Exception;
	XVersion xgetVersion(String versionName) throws Exception;
	String xgetVersionableIdentifier() throws Exception;
	XVersion xgetVersionByLabel(String label) throws Exception;
	String[] xgetVersionLabels() throws Exception;
	String[] xgetVersionLabels(XVersion version) throws Exception;
	boolean xhasVersionLabel(String label) throws Exception;
	boolean xhasVersionLabel(XVersion version, String label) throws Exception;
	void xremoveVersion(String versionName) throws Exception;
	void xremoveVersionLabel(String label) throws Exception;
}
