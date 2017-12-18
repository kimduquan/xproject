package xproject.xlang.xreflect;

import xproject.xrmi.XRemote;

public interface XModifier extends XRemote {
	boolean xisStatic() throws Exception;
	boolean xisPublic() throws Exception;
	boolean xisAbstract() throws Exception;
}
