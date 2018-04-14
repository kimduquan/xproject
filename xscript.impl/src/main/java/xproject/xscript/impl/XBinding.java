package xproject.xscript.impl;

import xproject.xlang.XClass;
import xproject.xlang.XFactory;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xunit.xrunner.XRunnerFactory;

public interface XBinding extends XRemote 
{
	XBindings xbindings() throws Exception;
	void ximport(String key, XClass xclass) throws Exception;
	XClass xgetClass(String key) throws Exception;
	XClass[] xgetClasses() throws Exception;
	boolean xhasClass(String key) throws Exception;
	XFactory xfactory() throws Exception;
	XRunnerFactory xrunnerFactory() throws Exception;
}
