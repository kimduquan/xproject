package xproject.xcr.impl;

import java.util.Map;

import javax.jcr.RepositoryFactory;

import xproject.xcr.XRepository;
import xproject.xcr.XRepositoryFactory;

public class XRepositoryFactoryImpl extends XCRImpl<XRepositoryFactory, RepositoryFactory> implements XRepositoryFactory {

	protected XRepositoryFactoryImpl(RepositoryFactory repositoryFactory, XFactory factory) {
		super(repositoryFactory, factory);
		// TODO Auto-generated constructor stub
	}

	public XRepository xgetRepository(Map<String, String> parameters) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xRepository(x().getRepository(parameters));
	}
}
