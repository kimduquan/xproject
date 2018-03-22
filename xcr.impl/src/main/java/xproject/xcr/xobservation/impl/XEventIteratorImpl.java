package xproject.xcr.xobservation.impl;

import javax.jcr.observation.EventIterator;

import xproject.xcr.impl.XFactory;
import xproject.xcr.impl.XRangeIteratorImpl;
import xproject.xcr.xobservation.XEvent;
import xproject.xcr.xobservation.XEventIterator;
import xproject.xrmi.XRemote;

public class XEventIteratorImpl<R extends XEventIterator, Value extends EventIterator> extends XRangeIteratorImpl<R, Value>
		implements XEventIterator {

	protected XEventIteratorImpl(Value eventIterator, XFactory factory) {
		super(eventIterator, factory);
		// TODO Auto-generated constructor stub
	}

	public XRemote xnext() throws Exception {
		// TODO Auto-generated method stub
		return xnextEvent();
	}

	public XEvent xnextEvent() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xEvent(x().nextEvent());
	}
}
