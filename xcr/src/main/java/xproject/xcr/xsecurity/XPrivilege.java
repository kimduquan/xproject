package xproject.xcr.xsecurity;

import xproject.xrmi.XRemote;

public interface XPrivilege extends XRemote {
	XPrivilege[] xgetAggregatePrivileges() throws Exception;
	XPrivilege[] xgetDeclaredAggregatePrivileges() throws Exception;
	String xgetName() throws Exception;
	boolean xisAbstract() throws Exception;
	boolean xisAggregate() throws Exception;
}
