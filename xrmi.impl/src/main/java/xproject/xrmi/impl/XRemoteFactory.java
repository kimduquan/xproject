package xproject.xrmi.impl;

import xproject.xlang.impl.XFactory;
import xproject.xrmi.xregistry.XRegistry;

public interface XRemoteFactory extends XFactory {

	XRegistry xRegistry();
}
