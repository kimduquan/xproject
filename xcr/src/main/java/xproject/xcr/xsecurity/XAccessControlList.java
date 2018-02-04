package xproject.xcr.xsecurity;

import xproject.xrmi.XRemote;
import xproject.xsecurity.XPrincipal;

public interface XAccessControlList extends XAccessControlPolicy, XRemote {
	boolean xaddAccessControlEntry(XPrincipal principal, XPrivilege[] privileges) throws Exception;
	XAccessControlEntry[] xgetAccessControlEntries() throws Exception;
	void xremoveAccessControlEntry(XAccessControlEntry ace) throws Exception;
}
