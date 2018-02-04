package xproject.xcr.observation;

import xproject.xrmi.XRemote;

public interface XObservationManager extends XRemote {
	void xaddEventListener(XEventListener listener, int eventTypes, String absPath, boolean isDeep, String[] uuid, String[] nodeTypeName, boolean noLocal) throws Exception;
	XEventJournal xgetEventJournal() throws Exception;
	XEventJournal xgetEventJournal(int eventTypes, String absPath, boolean isDeep, String[] uuid, String[] nodeTypeName) throws Exception;
	XEventListenerIterator xgetRegisteredEventListeners() throws Exception;
	void xremoveEventListener(XEventListener listener) throws Exception;
	void xsetUserData(String userData) throws Exception;
}
