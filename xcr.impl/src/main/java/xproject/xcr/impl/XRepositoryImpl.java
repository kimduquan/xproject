package xproject.xcr.impl;

import javax.jcr.Credentials;
import javax.jcr.Repository;
import javax.jcr.Value;

import xproject.xcr.XCredentials;
import xproject.xcr.XRepository;
import xproject.xcr.XSession;
import xproject.xcr.XValue;

public class XRepositoryImpl extends XCRImpl<XRepository, Repository> implements XRepository {

	protected XRepositoryImpl(Repository repository, XFactory factory) {
		super(repository, factory);
		// TODO Auto-generated constructor stub
	}

	public String xgetDescriptor(String key) throws Exception {
		// TODO Auto-generated method stub
		return x().getDescriptor(key);
	}

	public String[] xgetDescriptorKeys() throws Exception {
		// TODO Auto-generated method stub
		return x().getDescriptorKeys();
	}

	public XValue xgetDescriptorValue(String key) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xValue(x().getDescriptorValue(key));
	}

	public XValue[] xgetDescriptorValues(String key) throws Exception {
		// TODO Auto-generated method stub
		Value[] values = x().getDescriptorValues(key);
		XValue[] xvalues = new XValue[values.length];
		x(values, xvalues);
		return xvalues;
	}

	public boolean xisSingleValueDescriptor(String key) throws Exception {
		// TODO Auto-generated method stub
		return x().isSingleValueDescriptor(key);
	}

	public boolean xisStandardDescriptor(String key) throws Exception {
		// TODO Auto-generated method stub
		return x().isStandardDescriptor(key);
	}

	public XSession xlogin() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xSession(x().login());
	}

	public XSession xlogin(XCredentials credentials) throws Exception {
		// TODO Auto-generated method stub
		Credentials c = x(credentials);
		return xfactory().xSession(x().login(c));
	}

	public XSession xlogin(XCredentials credentials, String workspaceName) throws Exception {
		// TODO Auto-generated method stub
		Credentials c = x(credentials);
		return xfactory().xSession(x().login(c, workspaceName));
	}

	public XSession xlogin(String workspaceName) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xSession(x().login(workspaceName));
	}

}
