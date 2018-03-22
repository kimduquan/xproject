package xproject.xcr.xobservation.impl;

import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

import xproject.xcr.impl.XCRImpl;
import xproject.xcr.xobservation.XEventIterator;
import xproject.xcr.xobservation.XEventListener;

public class XEventListenerImpl extends XCRImpl<XEventListener, EventListener> implements XEventListener {

	protected XEventListenerImpl(EventListener eventListener) {
		super(eventListener);
		// TODO Auto-generated constructor stub
	}

	public void xonEvent(XEventIterator events) throws Exception {
		// TODO Auto-generated method stub
		EventIterator it = x(events);
		x().onEvent(it);
	}

}
