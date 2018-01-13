package xproject.xrmi;

import java.rmi.Remote;

public interface XRemote extends Remote {

	void xfinalize() throws Throwable;
}
