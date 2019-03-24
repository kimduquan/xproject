package xproject.xdriver;

import xproject.xdriver.impl.request.XCapabilities;
import xproject.xrmi.XRemote;

public class XCapabilitiesInfo implements XRemote {
	public XCapabilities capabilities;

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		capabilities = null;
		finalize();
	}
}
