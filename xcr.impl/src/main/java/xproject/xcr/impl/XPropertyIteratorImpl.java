package xproject.xcr.impl;

import javax.jcr.PropertyIterator;

import xproject.xcr.XProperty;
import xproject.xcr.XPropertyIterator;
import xproject.xrmi.XRemote;

public class XPropertyIteratorImpl extends XRangeIteratorImpl<XPropertyIterator, PropertyIterator> implements XPropertyIterator 
{
	protected XPropertyIteratorImpl(PropertyIterator iterator, XFactory factory) {
		super(iterator, factory);
	}

	public XProperty xnextProperty() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().nextProperty());
	}

	public XRemote xnext() throws Exception {
		// TODO Auto-generated method stub
		return xnextProperty();
	}
}
