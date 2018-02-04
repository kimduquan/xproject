package xproject.xcr.xversion;

import java.util.Calendar;

import xproject.xcr.XNode;
import xproject.xrmi.XRemote;

public interface XVersion extends XNode, XRemote {
	XVersionHistory xgetContainingHistory() throws Exception;
	Calendar xgetCreated() throws Exception;
	XNode xgetFrozenNode() throws Exception;
	XVersion xgetLinearPredecessor() throws Exception;
	XVersion xgetLinearSuccessor() throws Exception;
	XVersion[] xgetPredecessors() throws Exception;
	XVersion[] xgetSuccessors() throws Exception;
}
