package xproject.xdriver;

import xproject.xrmi.XRemote;

public interface XFileDetector extends XRemote {

	XFile xgetLocalFile(CharSequence... keys) throws Exception;
}
