package xproject.xcr.impl;

import javax.jcr.PropertyIterator;

import xproject.xcr.XProperty;
import xproject.xcr.XPropertyIterator;
import xproject.xrmi.XRemote;

public class XPropertyIteratorImpl extends XRangeIteratorImpl implements XPropertyIterator 
{
	private PropertyIterator iterator;
	private XFactory xfactory;
	
	protected XPropertyIteratorImpl(PropertyIterator it, XFactory factory) {
		super(it);
		// TODO Auto-generated constructor stub
	}

	public XRemote xnext() throws Exception {
		// TODO Auto-generated method stub
		return xnextProperty();
	}

	public XProperty xnextProperty() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(iterator.nextProperty());
	}
}
