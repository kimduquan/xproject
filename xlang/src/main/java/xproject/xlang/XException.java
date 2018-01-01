package xproject.xlang;

import xproject.xrmi.XRemote;

public interface XException extends XRemote {

	String xgetMessage() throws Exception;
}
