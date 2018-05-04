package xproject.xcr.xnodetype.impl;

import javax.jcr.Value;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;

import xproject.xcr.XValue;
import xproject.xcr.impl.XFactory;
import xproject.xcr.xnodetype.XNodeDefinition;
import xproject.xcr.xnodetype.XNodeType;
import xproject.xcr.xnodetype.XNodeTypeIterator;
import xproject.xcr.xnodetype.XPropertyDefinition;

public class XNodeTypeImpl extends XNodeTypeDefinitionImpl<XNodeType, NodeType> implements XNodeType {

	protected XNodeTypeImpl(NodeType nodeType, XFactory factory) {
		super(nodeType, factory);
		// TODO Auto-generated constructor stub
	}

	public boolean xcanAddChildNode(String childNodeName) throws Exception {
		// TODO Auto-generated method stub
		return x().canAddChildNode(childNodeName);
	}

	public boolean xcanAddChildNode(String childNodeName, String nodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		return x().canAddChildNode(childNodeName, nodeTypeName);
	}

	public boolean xcanRemoveNode(String nodeName) throws Exception {
		// TODO Auto-generated method stub
		return x().canRemoveNode(nodeName);
	}

	public boolean xcanRemoveProperty(String propertyName) throws Exception {
		// TODO Auto-generated method stub
		return x().canRemoveProperty(propertyName);
	}

	public boolean xcanSetProperty(String propertyName, XValue value) throws Exception {
		// TODO Auto-generated method stub
		Value v = x(value);
		return x().canSetProperty(propertyName, v);
	}

	public boolean xcanSetProperty(String propertyName, XValue[] values) throws Exception {
		// TODO Auto-generated method stub
		Value[] v = new Value[values.length];
		x(v, values);
		return x().canSetProperty(propertyName, v);
	}

	public XNodeDefinition[] xgetChildNodeDefinitions() throws Exception {
		// TODO Auto-generated method stub
		NodeDefinition[] nodeDefinitions = x().getChildNodeDefinitions();
		XNodeDefinition[] xnodeDefinitions = new XNodeDefinition[nodeDefinitions.length];
		x(nodeDefinitions, xnodeDefinitions);
		return xnodeDefinitions;
	}

	public XNodeTypeIterator xgetDeclaredSubtypes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XPropertyDefinition[] xgetPropertyDefinitions() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNodeTypeIterator xgetSubtypes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XNodeType[] xgetSupertypes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean xisNodeType(String nodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		return x().isNodeType(nodeTypeName);
	}

	
}
