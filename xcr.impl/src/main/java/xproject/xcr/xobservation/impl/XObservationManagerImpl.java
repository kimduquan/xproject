package xproject.xcr.xobservation.impl;

import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

import xproject.xcr.impl.XCRImpl;
import xproject.xcr.impl.XFactory;
import xproject.xcr.xobservation.XEventJournal;
import xproject.xcr.xobservation.XEventListener;
import xproject.xcr.xobservation.XEventListenerIterator;
import xproject.xcr.xobservation.XObservationManager;

public class XObservationManagerImpl extends XCRImpl<XObservationManager, ObservationManager>
		implements XObservationManager {

	protected XObservationManagerImpl(ObservationManager observationManager, XFactory factory) {
		super(observationManager, factory);
		// TODO Auto-generated constructor stub
	}

	public void xaddEventListener(XEventListener listener, int eventTypes, String absPath, boolean isDeep,
			String[] uuid, String[] nodeTypeName, boolean noLocal) throws Exception {
		// TODO Auto-generated method stub
		EventListener eventListener = x(listener);
		x().addEventListener(eventListener, eventTypes, absPath, isDeep, uuid, nodeTypeName, noLocal);
	}

	public XEventJournal xgetEventJournal() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xEventJournal(x().getEventJournal());
	}

	public XEventJournal xgetEventJournal(int eventTypes, String absPath, boolean isDeep, String[] uuid,
			String[] nodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xEventJournal(x().getEventJournal(eventTypes, absPath, isDeep, uuid, nodeTypeName));
	}

	public XEventListenerIterator xgetRegisteredEventListeners() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xEventListenerIterator(x().getRegisteredEventListeners());
	}

	public void xremoveEventListener(XEventListener listener) throws Exception {
		// TODO Auto-generated method stub
		EventListener eventListener = x(listener);
		x().removeEventListener(eventListener);
	}

	public void xsetUserData(String userData) throws Exception {
		// TODO Auto-generated method stub
		x().setUserData(userData);
	}

}
