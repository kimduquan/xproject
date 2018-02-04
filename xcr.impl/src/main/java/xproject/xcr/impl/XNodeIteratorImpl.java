package xproject.xcr.impl;

import javax.jcr.NodeIterator;

import xproject.xcr.XNode;
import xproject.xcr.XNodeIterator;
import xproject.xrmi.XRemote;

public class XNodeIteratorImpl extends XRangeIteratorImpl<XNodeIterator, NodeIterator> implements XNodeIterator {

	protected XNodeIteratorImpl(NodeIterator iterator, XFactory factory) {
		super(iterator, factory);
	}

	public XRemote xnext() throws Exception {
		// TODO Auto-generated method stub
		return xnextNode();
	}

	public XNode xnextNode() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().nextNode());
	}
}
