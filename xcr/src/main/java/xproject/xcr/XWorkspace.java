package xproject.xcr;

import xproject.xcr.observation.XObservationManager;
import xproject.xcr.xlock.XLockManager;
import xproject.xcr.xnodetype.XNodeTypeManager;
import xproject.xcr.xquery.XQueryManager;
import xproject.xcr.xversion.XVersionManager;
import xproject.xrmi.XRemote;

public interface XWorkspace extends XRemote {
	void xclone(String srcWorkspace, String srcAbsPath, String destAbsPath, boolean removeExisting) throws Exception;
	void xcopy(String srcAbsPath, String destAbsPath) throws Exception;
	void xcopy(String srcWorkspace, String srcAbsPath, String destAbsPath) throws Exception;
	void xcreateWorkspace(String name) throws Exception;
	void xcreateWorkspace(String name, String srcWorkspace) throws Exception;
	void xdeleteWorkspace(String name) throws Exception;
	String[] xgetAccessibleWorkspaceNames() throws Exception;
	XLockManager xgetLockManager() throws Exception;
	String xgetName() throws Exception;
	XNamespaceRegistry xgetNamespaceRegistry() throws Exception;
	XNodeTypeManager xgetNodeTypeManager() throws Exception;
	XObservationManager xgetObservationManager() throws Exception;
	XQueryManager xgetQueryManager() throws Exception;
	XSession xgetSession() throws Exception;
	XVersionManager xgetVersionManager() throws Exception;
	void xmove(String srcAbsPath, String destAbsPath) throws Exception;
}
