package xproject.xdriver;

import xproject.xlang.XObject;
import xproject.xrmi.XRemote;

public interface XCoordinates extends XRemote {

	XObject xgetAuxiliary() throws Exception;
	XPoint xinViewPort() throws Exception;
	XPoint xonPage() throws Exception;
	XPoint xonScreen() throws Exception;
}
