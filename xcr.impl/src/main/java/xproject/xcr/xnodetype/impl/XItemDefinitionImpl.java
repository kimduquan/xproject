package xproject.xcr.xnodetype.impl;

import javax.jcr.nodetype.ItemDefinition;

import xproject.xcr.impl.XCRImpl;
import xproject.xcr.impl.XFactory;
import xproject.xcr.xnodetype.XItemDefinition;
import xproject.xcr.xnodetype.XNodeType;

public class XItemDefinitionImpl<R extends XItemDefinition, Value extends ItemDefinition> extends XCRImpl<R, Value> implements XItemDefinition {

	protected XItemDefinitionImpl(Value itemDefinition, XFactory factory) {
		super(itemDefinition, factory);
		// TODO Auto-generated constructor stub
	}

	public XNodeType xgetDeclaringNodeType() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeType(x().getDeclaringNodeType());
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return x().getName();
	}

	public int xgetOnParentVersion() throws Exception {
		// TODO Auto-generated method stub
		return x().getOnParentVersion();
	}

	public boolean xisAutoCreated() throws Exception {
		// TODO Auto-generated method stub
		return x().isAutoCreated();
	}

	public boolean xisMandatory() throws Exception {
		// TODO Auto-generated method stub
		return x().isMandatory();
	}

	public boolean xisProtected() throws Exception {
		// TODO Auto-generated method stub
		return x().isProtected();
	}

}
