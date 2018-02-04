package xproject.xcr.impl;

import javax.jcr.Credentials;
import javax.jcr.Session;

import xproject.xcr.XCredentials;
import xproject.xcr.XItem;
import xproject.xcr.XNode;
import xproject.xcr.XProperty;
import xproject.xcr.XRepository;
import xproject.xcr.XSession;
import xproject.xcr.XValueFactory;
import xproject.xcr.XWorkspace;
import xproject.xcr.xretention.XRetentionManager;
import xproject.xcr.xsecurity.XAccessControlManager;
import xproject.xlang.XObject;

public class XSessionImpl extends XCRImpl<XSession, Session> implements XSession {

	protected XSessionImpl(Session session, XFactory factory) {
		super(session, factory);
		// TODO Auto-generated constructor stub
	}

	public void xcheckPermission(String absPath, String actions) throws Exception {
		// TODO Auto-generated method stub
		x().checkPermission(absPath, actions);
	}

	public XObject xgetAttribute(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] xgetAttributeNames() throws Exception {
		// TODO Auto-generated method stub
		return x().getAttributeNames();
	}

	public String xgetNamespacePrefix(String uri) throws Exception {
		// TODO Auto-generated method stub
		return x().getNamespacePrefix(uri);
	}

	public String[] xgetNamespacePrefixes() throws Exception {
		// TODO Auto-generated method stub
		return x().getNamespacePrefixes();
	}

	public String xgetNamespaceURI(String prefix) throws Exception {
		// TODO Auto-generated method stub
		return x().getNamespaceURI(prefix);
	}

	public XNode xgetNode(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().getNode(absPath));
	}

	public XNode xgetNodeByIdentifier(String id) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().getNodeByIdentifier(id));
	}

	public XProperty xgetProperty(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().getProperty(absPath));
	}

	public XRepository xgetRepository() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xRepository(x().getRepository());
	}

	public XRetentionManager xgetRetentionManager() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNode xgetRootNode() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().getRootNode());
	}

	public String xgetUserID() throws Exception {
		// TODO Auto-generated method stub
		return x().getUserID();
	}

	public XValueFactory xgetValueFactory() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XWorkspace xgetWorkspace() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xWorkspace(x().getWorkspace());
	}

	public boolean xhasCapability(String methodName, XObject target, XObject[] arguments) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean xhasPendingChanges() throws Exception {
		// TODO Auto-generated method stub
		return x().hasPendingChanges();
	}

	public boolean xhasPermission(String absPath, String actions) throws Exception {
		// TODO Auto-generated method stub
		return x().hasPermission(absPath, actions);
	}

	public XSession ximpersonate(XCredentials credentials) throws Exception {
		// TODO Auto-generated method stub
		Credentials c = x(credentials);
		return xfactory().xSession(x().impersonate(c));
	}

	public boolean xisLive() throws Exception {
		// TODO Auto-generated method stub
		return x().isLive();
	}

	public boolean xitemExists(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return x().itemExists(absPath);
	}

	public void xlogout() throws Exception {
		// TODO Auto-generated method stub
		x().logout();
	}

	public void xmove(String srcAbsPath, String destAbsPath) throws Exception {
		// TODO Auto-generated method stub
		x().move(srcAbsPath, destAbsPath);
	}

	public boolean xnodeExists(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return x().nodeExists(absPath);
	}

	public boolean xpropertyExists(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return x().propertyExists(absPath);
	}

	public void xrefresh(boolean keepChanges) throws Exception {
		// TODO Auto-generated method stub
		x().refresh(keepChanges);
	}

	public void xremoveItem(String absPath) throws Exception {
		// TODO Auto-generated method stub
		x().removeItem(absPath);
	}

	public void xsave() throws Exception {
		// TODO Auto-generated method stub
		x().save();
	}

	public void xsetNamespacePrefix(String prefix, String uri) throws Exception {
		// TODO Auto-generated method stub
		x().setNamespacePrefix(prefix, uri);
	}

	public XAccessControlManager xgetAccessControlManager() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XItem xgetItem(String absPath) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
