package xproject.xface.xviewers;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xwt.xgraphics.XImage;

public interface XLabelProvider extends XRemote {

	XImage xgetImage(XObject element) throws Exception;
	String xgetText(XObject element) throws Exception;
}
