package xproject.xcr.xnodetype;

import xproject.xrmi.XRemote;

public interface XNodeDefinition extends XItemDefinition, XRemote {
	boolean xallowsSameNameSiblings() throws Exception;
	XNodeType xgetDefaultPrimaryType() throws Exception;
	String xgetDefaultPrimaryTypeName() throws Exception;
	String[] xgetRequiredPrimaryTypeNames() throws Exception;
	XNodeType[] xgetRequiredPrimaryTypes() throws Exception;
}
