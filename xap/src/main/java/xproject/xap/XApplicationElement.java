package xproject.xap;

import java.util.Map;

import xproject.xrmi.XRemote;

public interface XApplicationElement extends XRemote {

	Map<String, Object> xgetTransientData() throws Exception;
	
	String xgetContributorURI() throws Exception;

	void xsetContributorURI(String value) throws Exception;
}
