package xproject.xcr.impl;

import javax.jcr.Credentials;

import xproject.xcr.XCredentials;

public class XCredentialsImpl extends XCRImpl<XCredentials, Credentials> implements XCredentials {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected XCredentialsImpl(Credentials credentials) {
		super(credentials);
		// TODO Auto-generated constructor stub
	}
}
