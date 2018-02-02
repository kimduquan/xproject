package xproject.xcr.impl;

import javax.jcr.NodeIterator;

import xproject.xcr.XNode;
import xproject.xrmi.XRemote;

public class XNodeIteratorImpl extends XRangeIteratorImpl {

	private NodeIterator iterator;
	private XFactory xfactory;
	
	protected XNodeIteratorImpl(NodeIterator it, XFactory factory) {
		super(it);
		// TODO Auto-generated constructor stub
		iterator = it;
		xfactory = factory;
	}

	public XRemote xnext() throws Exception {
		// TODO Auto-generated method stub
		return xnextNode();
	}

	public XNode xnextNode() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNode(iterator.nextNode());
	}
}
