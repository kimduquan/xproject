package xproject.xcr.xnodetype.impl;

import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeTypeDefinition;
import javax.jcr.nodetype.PropertyDefinition;

import xproject.xcr.impl.XCRImpl;
import xproject.xcr.impl.XFactory;
import xproject.xcr.xnodetype.XNodeDefinition;
import xproject.xcr.xnodetype.XNodeTypeDefinition;
import xproject.xcr.xnodetype.XPropertyDefinition;

public class XNodeTypeDefinitionImpl<R extends XNodeTypeDefinition, V extends NodeTypeDefinition> extends XCRImpl<R, V>
		implements XNodeTypeDefinition {

	protected XNodeTypeDefinitionImpl(V nodeTypeDefinition, XFactory factory) {
		super(nodeTypeDefinition, factory);
		// TODO Auto-generated constructor stub
	}

	public XNodeDefinition[] xgetDeclaredChildNodeDefinitions() throws Exception {
		// TODO Auto-generated method stub
		NodeDefinition[] nodeDefinitions = x().getDeclaredChildNodeDefinitions();
		XNodeDefinition[] xnodeDefinitions = new XNodeDefinition[nodeDefinitions.length];
		x(nodeDefinitions, xnodeDefinitions);
		return xnodeDefinitions;
	}

	public XPropertyDefinition[] xgetDeclaredPropertyDefinitions() throws Exception {
		// TODO Auto-generated method stub
		PropertyDefinition[] propertyDefinitions = x().getDeclaredPropertyDefinitions();
		XPropertyDefinition[] xpropertyDefinitions = new XPropertyDefinition[propertyDefinitions.length];
		x(propertyDefinitions, xpropertyDefinitions);
		return xpropertyDefinitions;
	}

	public String[] xgetDeclaredSupertypeNames() throws Exception {
		// TODO Auto-generated method stub
		return x().getDeclaredSupertypeNames();
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return x().getName();
	}

	public String xgetPrimaryItemName() throws Exception {
		// TODO Auto-generated method stub
		return x().getPrimaryItemName();
	}

	public boolean xhasOrderableChildNodes() throws Exception {
		// TODO Auto-generated method stub
		return x().hasOrderableChildNodes();
	}

	public boolean xisAbstract() throws Exception {
		// TODO Auto-generated method stub
		return x().isAbstract();
	}

	public boolean xisMixin() throws Exception {
		// TODO Auto-generated method stub
		return x().isMixin();
	}

	public boolean xisQueryable() throws Exception {
		// TODO Auto-generated method stub
		return x().isQueryable();
	}

}
