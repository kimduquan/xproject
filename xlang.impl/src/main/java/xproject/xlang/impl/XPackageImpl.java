package xproject.xlang.impl;

import xproject.xlang.XPackage;

public class XPackageImpl implements XPackage {

	private Package xpackage;
	
	protected XPackageImpl(Package pkg) {
		xpackage = pkg;
	}

	public String xgetName() {
		// TODO Auto-generated method stub
		return xpackage.getName();
	}

	public static XPackage xnew(Package pkg)
	{
		return new XPackageImpl(pkg);
	}
}
