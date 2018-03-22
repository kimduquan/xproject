package xproject.xcr.xobservation.impl;

import javax.jcr.observation.EventListenerIterator;

import xproject.xcr.impl.XFactory;
import xproject.xcr.impl.XRangeIteratorImpl;
import xproject.xcr.xobservation.XEventListener;
import xproject.xcr.xobservation.XEventListenerIterator;
import xproject.xrmi.XRemote;

public class XEventListenerIteratorImpl extends XRangeIteratorImpl<XEventListenerIterator, EventListenerIterator>
		implements XEventListenerIterator {

	protected XEventListenerIteratorImpl(EventListenerIterator iterator, XFactory factory) {
		super(iterator, factory);
		// TODO Auto-generated constructor stub
	}

	public XRemote xnext() throws Exception {
		// TODO Auto-generated method stub
		return xnextEventListener();
	}

	public XEventListener xnextEventListener() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xEventListener(x().nextEventListener());
	}

}
