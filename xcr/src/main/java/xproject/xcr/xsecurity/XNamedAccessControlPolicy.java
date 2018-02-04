package xproject.xcr.xsecurity;

import xproject.xrmi.XRemote;

public interface XNamedAccessControlPolicy extends XAccessControlPolicy, XRemote {
	String xgetName() throws Exception;
}
