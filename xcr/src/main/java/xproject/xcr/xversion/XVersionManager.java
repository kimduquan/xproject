package xproject.xcr.xversion;

import xproject.xcr.XNode;
import xproject.xcr.XNodeIterator;
import xproject.xrmi.XRemote;

public interface XVersionManager extends XRemote {
	void xcancelMerge(String absPath, XVersion version) throws Exception;
	XVersion xcheckin(String absPath) throws Exception;
	void xcheckout(String absPath) throws Exception;
	XVersion xcheckpoint(String absPath) throws Exception;
	XNode xcreateActivity(String title) throws Exception;
	XNode xcreateConfiguration(String absPath) throws Exception;
	void xdoneMerge(String absPath, XVersion version) throws Exception;
	XNode xgetActivity() throws Exception;
	XVersion xgetBaseVersion(String absPath) throws Exception;
	XVersionHistory xgetVersionHistory(String absPath) throws Exception;
	boolean xisCheckedOut(String absPath) throws Exception;
	XNodeIterator xmerge(XNode activityNode) throws Exception;
	XNodeIterator xmerge(String absPath, String srcWorkspace, boolean bestEffort) throws Exception;
	XNodeIterator xmerge(String absPath, String srcWorkspace, boolean bestEffort, boolean isShallow) throws Exception;
	void xremoveActivity(XNode activityNode) throws Exception;
	void xrestore(String absPath, String versionName, boolean removeExisting) throws Exception;
	void xrestore(String absPath, XVersion version, boolean removeExisting) throws Exception;
	void xrestore(XVersion[] versions, boolean removeExisting) throws Exception;
	void xrestore(XVersion version, boolean removeExisting) throws Exception;
	void xrestoreByLabel(String absPath, String versionLabel, boolean removeExisting) throws Exception;
	XNode xsetActivity(XNode activity) throws Exception;
}
