package xproject.xcr.xnodetype;

import xproject.xcr.XRangeIterator;
import xproject.xrmi.XRemote;

public interface XNodeTypeIterator extends XRangeIterator, XRemote {
	XNodeType xnextNodeType() throws Exception;
}
