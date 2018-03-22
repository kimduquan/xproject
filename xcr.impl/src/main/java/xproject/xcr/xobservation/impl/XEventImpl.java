package xproject.xcr.xobservation.impl;

import java.util.Map;

import javax.jcr.observation.Event;

import xproject.xcr.impl.XCRImpl;
import xproject.xcr.xobservation.XEvent;

public class XEventImpl extends XCRImpl<XEvent, Event> implements XEvent {

	protected XEventImpl(Event event) {
		super(event);
		// TODO Auto-generated constructor stub
	}

	public long xgetDate() throws Exception {
		// TODO Auto-generated method stub
		return x().getDate();
	}

	public String xgetIdentifier() throws Exception {
		// TODO Auto-generated method stub
		return x().getIdentifier();
	}

	public Map<?, ?> xgetInfo() throws Exception {
		// TODO Auto-generated method stub
		return x().getInfo();
	}

	public String xgetPath() throws Exception {
		// TODO Auto-generated method stub
		return x().getPath();
	}

	public int xgetType() throws Exception {
		// TODO Auto-generated method stub
		return x().getType();
	}

	public String xgetUserData() throws Exception {
		// TODO Auto-generated method stub
		return x().getUserData();
	}

	public String xgetUserID() throws Exception {
		// TODO Auto-generated method stub
		return x().getUserID();
	}

}
