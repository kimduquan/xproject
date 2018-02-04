package xproject.xcr.xnodetype;

import xproject.xcr.XValue;
import xproject.xrmi.XRemote;

public interface XNodeType extends XNodeTypeDefinition, XRemote {

	boolean xcanAddChildNode(String childNodeName) throws Exception;
	boolean xcanAddChildNode(String childNodeName, String nodeTypeName) throws Exception;
	boolean xcanRemoveNode(String nodeName) throws Exception;
	boolean xcanRemoveProperty(String propertyName) throws Exception;
	boolean xcanSetProperty(String propertyName, XValue value) throws Exception;
	boolean xcanSetProperty(String propertyName, XValue[] values) throws Exception;
	XNodeDefinition[] xgetChildNodeDefinitions() throws Exception;
	XNodeTypeIterator xgetDeclaredSubtypes() throws Exception;
	XPropertyDefinition[] xgetPropertyDefinitions() throws Exception;
	XNodeTypeIterator xgetSubtypes() throws Exception;
	XNodeType[] xgetSupertypes() throws Exception;
	boolean xisNodeType(String nodeTypeName) throws Exception;
}
