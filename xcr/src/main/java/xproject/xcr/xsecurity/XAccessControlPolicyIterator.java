package xproject.xcr.xsecurity;

import xproject.xcr.XRangeIterator;
import xproject.xrmi.XRemote;

public interface XAccessControlPolicyIterator extends XRemote, XRangeIterator {
	XAccessControlPolicy xnextAccessControlPolicy() throws Exception;
}
