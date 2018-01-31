package xproject.xcr;

import xproject.xrmi.XRemote;

public interface XNodeType extends XRemote {

	boolean xcanAddChildNode(String childNodeName) throws Exception;
	boolean xcanAddChildNode(String childNodeName, String nodeTypeName) throws Exception;
	boolean xcanRemoveNode(String nodeName) throws Exception;
	boolean xcanRemoveProperty(String propertyName) throws Exception;
	XNodeType[] xgetDeclaredSupertypes() throws Exception;
	XNodeType[] xgetSupertypes() throws Exception;
	boolean xisNodeType(String nodeTypeName) throws Exception;
}
