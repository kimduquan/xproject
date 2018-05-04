package xproject.xcr.xnodetype.impl;

import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;

import xproject.xcr.impl.XFactory;
import xproject.xcr.xnodetype.XNodeDefinition;
import xproject.xcr.xnodetype.XNodeType;

public class XNodeDefinitionImpl<R extends XNodeDefinition, Value extends NodeDefinition> extends XItemDefinitionImpl<R, Value> implements XNodeDefinition {

	protected XNodeDefinitionImpl(Value nodeDefinition, XFactory factory) {
		super(nodeDefinition, factory);
		// TODO Auto-generated constructor stub
	}

	public boolean xallowsSameNameSiblings() throws Exception {
		// TODO Auto-generated method stub
		return x().allowsSameNameSiblings();
	}

	public XNodeType xgetDefaultPrimaryType() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeType(x().getDefaultPrimaryType());
	}

	public String xgetDefaultPrimaryTypeName() throws Exception {
		// TODO Auto-generated method stub
		return x().getDefaultPrimaryTypeName();
	}

	public String[] xgetRequiredPrimaryTypeNames() throws Exception {
		// TODO Auto-generated method stub
		return x().getRequiredPrimaryTypeNames();
	}

	public XNodeType[] xgetRequiredPrimaryTypes() throws Exception {
		// TODO Auto-generated method stub
		NodeType[] nodeTypes = x().getRequiredPrimaryTypes();
		XNodeType[] xnodeTypes = new XNodeType[nodeTypes.length];
		x(nodeTypes, xnodeTypes);
		return xnodeTypes;
	}

}
