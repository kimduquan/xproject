package xproject.xcr.xnodetype.impl;

import javax.jcr.nodetype.NodeDefinitionTemplate;

import xproject.xcr.impl.XFactory;
import xproject.xcr.xnodetype.XNodeDefinitionTemplate;

public class XNodeDefinitionTemplateImpl extends XNodeDefinitionImpl<XNodeDefinitionTemplate, NodeDefinitionTemplate> implements XNodeDefinitionTemplate {

	protected XNodeDefinitionTemplateImpl(NodeDefinitionTemplate nodeDefinitionTemplate, XFactory factory) {
		super(nodeDefinitionTemplate, factory);
		// TODO Auto-generated constructor stub
	}

	public void xsetAutoCreated(boolean autoCreated) throws Exception {
		// TODO Auto-generated method stub
		x().setAutoCreated(autoCreated);
	}

	public void xsetDefaultPrimaryTypeName(String name) throws Exception {
		// TODO Auto-generated method stub
		x().setDefaultPrimaryTypeName(name);
	}

	public void xsetMandatory(boolean mandatory) throws Exception {
		// TODO Auto-generated method stub
		x().setMandatory(mandatory);
	}

	public void xsetName(String name) throws Exception {
		// TODO Auto-generated method stub
		x().setName(name);
	}

	public void xsetOnParentVersion(int opv) throws Exception {
		// TODO Auto-generated method stub
		x().setOnParentVersion(opv);
	}

	public void xsetProtected(boolean protectedStatus) throws Exception {
		// TODO Auto-generated method stub
		x().setProtected(protectedStatus);
	}

	public void xsetRequiredPrimaryTypeNames(String[] names) throws Exception {
		// TODO Auto-generated method stub
		x().setRequiredPrimaryTypeNames(names);
	}

	public void xsetSameNameSiblings(boolean allowSameNameSiblings) throws Exception {
		// TODO Auto-generated method stub
		x().setSameNameSiblings(allowSameNameSiblings);
	}

}
