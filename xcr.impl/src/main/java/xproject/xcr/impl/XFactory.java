package xproject.xcr.impl;

import javax.jcr.Node;

import xproject.xcr.XNode;
import xproject.xrmi.XRemote;

public interface XFactory extends XRemote {

	XNode xNode(Node node) throws Exception;
}
