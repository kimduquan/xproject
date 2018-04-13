package xproject.xio.impl;

import java.io.Writer;

import xproject.xio.XWriter;
import xproject.xrmi.XRemote;

public interface XIOFactory extends XRemote {

	XWriter xWriter(Writer writer) throws Exception;
}
