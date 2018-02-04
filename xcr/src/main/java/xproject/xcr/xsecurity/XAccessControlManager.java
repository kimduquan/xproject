package xproject.xcr.xsecurity;

import xproject.xrmi.XRemote;

public interface XAccessControlManager extends XRemote {
	XAccessControlPolicyIterator xgetApplicablePolicies(String absPath) throws Exception;
	XAccessControlPolicy[] xgetEffectivePolicies(String absPath) throws Exception;
	XAccessControlPolicy[] xgetPolicies(String absPath) throws Exception;
	XPrivilege[] xgetPrivileges(String absPath) throws Exception;
	XPrivilege[] xgetSupportedPrivileges(String absPath) throws Exception;
	boolean xhasPrivileges(String absPath, XPrivilege[] privileges) throws Exception;
	XPrivilege xprivilegeFromName(String privilegeName) throws Exception;
	void xremovePolicy(String absPath, XAccessControlPolicy policy) throws Exception;
	void xsetPolicy(String absPath, XAccessControlPolicy policy) throws Exception;
}
