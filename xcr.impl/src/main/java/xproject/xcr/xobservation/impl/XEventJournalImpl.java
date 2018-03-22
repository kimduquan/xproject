package xproject.xcr.xobservation.impl;

import javax.jcr.observation.EventJournal;

import xproject.xcr.impl.XFactory;
import xproject.xcr.xobservation.XEventJournal;

public class XEventJournalImpl extends XEventIteratorImpl<XEventJournal, EventJournal> implements XEventJournal {

	protected XEventJournalImpl(EventJournal eventJournal, XFactory factory) {
		super(eventJournal, factory);
		// TODO Auto-generated constructor stub
	}

	public void xskipTo(long date) throws Exception {
		// TODO Auto-generated method stub
		x().skipTo(date);
	}

}
