package xproject.xcr;

import java.util.Map;

import xproject.xrmi.XRemote;

public interface XRepositoryFactory extends XRemote {

	XRepository xgetRepository(Map<String, String> parameters) throws Exception;
}
