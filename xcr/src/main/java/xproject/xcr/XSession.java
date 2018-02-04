package xproject.xcr;

import xproject.xcr.xretention.XRetentionManager;
import xproject.xcr.xsecurity.XAccessControlManager;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XSession extends XRemote {
	void xcheckPermission(String absPath, String actions) throws Exception;
	XAccessControlManager xgetAccessControlManager() throws Exception;
	XObject xgetAttribute(String name) throws Exception;
	String[] xgetAttributeNames() throws Exception;
	XItem xgetItem(java.lang.String absPath) throws Exception;
	String xgetNamespacePrefix(String uri) throws Exception;
	String[] xgetNamespacePrefixes() throws Exception;
	String xgetNamespaceURI(String prefix) throws Exception;
	XNode xgetNode(String absPath) throws Exception;
	XNode xgetNodeByIdentifier(String id) throws Exception;
	XProperty xgetProperty(String absPath) throws Exception;
	XRepository xgetRepository() throws Exception;
	XRetentionManager xgetRetentionManager() throws Exception;
	XNode xgetRootNode() throws Exception;
	String xgetUserID() throws Exception;
	XValueFactory xgetValueFactory() throws Exception;
	XWorkspace xgetWorkspace() throws Exception;
	boolean xhasCapability(String methodName, XObject target, XObject[] arguments) throws Exception;
	boolean xhasPendingChanges() throws Exception;
	boolean xhasPermission(String absPath, String actions) throws Exception;
	XSession ximpersonate(XCredentials credentials) throws Exception;
	boolean xisLive() throws Exception;
	boolean xitemExists(String absPath) throws Exception;
	void xlogout() throws Exception;
	void xmove(String srcAbsPath, String destAbsPath) throws Exception;
	boolean xnodeExists(String absPath) throws Exception;
	boolean xpropertyExists(String absPath) throws Exception;
	void xrefresh(boolean keepChanges) throws Exception;
	void xremoveItem(String absPath) throws Exception;
	void xsave() throws Exception;
	void xsetNamespacePrefix(String prefix, String uri) throws Exception;
}
