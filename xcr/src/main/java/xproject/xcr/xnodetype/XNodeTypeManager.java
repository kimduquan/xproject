package xproject.xcr.xnodetype;

import xproject.xrmi.XRemote;

public interface XNodeTypeManager extends XRemote {
	XNodeDefinitionTemplate xcreateNodeDefinitionTemplate() throws Exception;
	XNodeTypeTemplate xcreateNodeTypeTemplate() throws Exception;
	XNodeTypeTemplate xcreateNodeTypeTemplate(XNodeTypeDefinition ntd) throws Exception;
	XPropertyDefinitionTemplate xcreatePropertyDefinitionTemplate() throws Exception;
	XNodeTypeIterator xgetAllNodeTypes() throws Exception;
	XNodeTypeIterator xgetMixinNodeTypes() throws Exception;
	XNodeType xgetNodeType(String nodeTypeName) throws Exception;
	XNodeTypeIterator xgetPrimaryNodeTypes() throws Exception;
	boolean xhasNodeType(String name) throws Exception;
	XNodeType xregisterNodeType(XNodeTypeDefinition ntd, boolean allowUpdate) throws Exception;
	XNodeTypeIterator xregisterNodeTypes(XNodeTypeDefinition[] ntds, boolean allowUpdate) throws Exception;
	void xunregisterNodeType(String name) throws Exception;
	void xunregisterNodeTypes(String[] names) throws Exception;
}
