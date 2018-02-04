package xproject.xcr.impl;

import javax.jcr.Workspace;

import xproject.xcr.XNamespaceRegistry;
import xproject.xcr.XSession;
import xproject.xcr.XWorkspace;
import xproject.xcr.observation.XObservationManager;
import xproject.xcr.xlock.XLockManager;
import xproject.xcr.xnodetype.XNodeTypeManager;
import xproject.xcr.xquery.XQueryManager;
import xproject.xcr.xversion.XVersionManager;

public class XWorkspaceImpl extends XCRImpl<XWorkspace, Workspace> implements XWorkspace {

	protected XWorkspaceImpl(Workspace workspace, XFactory factory) {
		super(workspace, factory);
		// TODO Auto-generated constructor stub
	}

	public void xclone(String srcWorkspace, String srcAbsPath, String destAbsPath, boolean removeExisting)
			throws Exception {
		// TODO Auto-generated method stub
		x().clone(srcWorkspace, srcAbsPath, destAbsPath, removeExisting);
	}

	public void xcopy(String srcAbsPath, String destAbsPath) throws Exception {
		// TODO Auto-generated method stub
		x().copy(srcAbsPath, destAbsPath);
	}

	public void xcopy(String srcWorkspace, String srcAbsPath, String destAbsPath) throws Exception {
		// TODO Auto-generated method stub
		x().copy(srcWorkspace, srcAbsPath, destAbsPath);
	}

	public void xcreateWorkspace(String name) throws Exception {
		// TODO Auto-generated method stub
		x().createWorkspace(name);
	}

	public void xcreateWorkspace(String name, String srcWorkspace) throws Exception {
		// TODO Auto-generated method stub
		x().createWorkspace(name, srcWorkspace);
	}

	public void xdeleteWorkspace(String name) throws Exception {
		// TODO Auto-generated method stub
		x().deleteWorkspace(name);
	}

	public String[] xgetAccessibleWorkspaceNames() throws Exception {
		// TODO Auto-generated method stub
		return x().getAccessibleWorkspaceNames();
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return x().getName();
	}

	public XSession xgetSession() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xSession(x().getSession());
	}

	public void xmove(String srcAbsPath, String destAbsPath) throws Exception {
		// TODO Auto-generated method stub
		x().move(srcAbsPath, destAbsPath);
	}

	public XLockManager xgetLockManager() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNamespaceRegistry xgetNamespaceRegistry() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNodeTypeManager xgetNodeTypeManager() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XObservationManager xgetObservationManager() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XQueryManager xgetQueryManager() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XVersionManager xgetVersionManager() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
