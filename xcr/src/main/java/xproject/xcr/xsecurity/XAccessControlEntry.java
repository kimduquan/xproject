package xproject.xcr.xsecurity;

import xproject.xrmi.XRemote;
import xproject.xsecurity.XPrincipal;

public interface XAccessControlEntry extends XRemote {
	XPrincipal xgetPrincipal() throws Exception;
	XPrivilege[] xgetPrivileges() throws Exception;
}
