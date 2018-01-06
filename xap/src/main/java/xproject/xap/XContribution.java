package xproject.xap;

import xproject.xrmi.XRemote;

public interface XContribution extends XRemote {

	void xsetContributionURI(String uri) throws Exception;
	String xgetContributionURI() throws Exception;
}
