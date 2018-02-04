package xproject.xcr.xnodetype;

import xproject.xrmi.XRemote;

public interface XNodeTypeDefinition extends XRemote {
	XNodeDefinition[] xgetDeclaredChildNodeDefinitions() throws Exception;
	XPropertyDefinition[] xgetDeclaredPropertyDefinitions() throws Exception;
	String[] xgetDeclaredSupertypeNames() throws Exception;
	String xgetName() throws Exception;
	String xgetPrimaryItemName() throws Exception;
	boolean xhasOrderableChildNodes() throws Exception;
	boolean xisAbstract() throws Exception;
	boolean xisMixin() throws Exception;
	boolean xisQueryable() throws Exception;
}
