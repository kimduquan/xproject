package xproject.xcr.xnodetype;

import xproject.xrmi.XRemote;

public interface XItemDefinition extends XRemote {
	XNodeType xgetDeclaringNodeType() throws Exception;
	String xgetName() throws Exception;
	int xgetOnParentVersion() throws Exception;
	boolean xisAutoCreated() throws Exception;
	boolean xisMandatory() throws Exception;
	boolean xisProtected() throws Exception;
}
