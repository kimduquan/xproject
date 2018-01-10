package xproject.xface.xviewers;

import xproject.xrmi.XRemote;

public interface XTreeViewer extends XRemote {

	void xsetLabelProvider(XLabelProvider provider) throws Exception;
	void xsetContentProvider(XContentProvider provider) throws Exception;
}
