package org.kdq.xwt.xreflect.impl;

import java.awt.Frame;

import org.kdq.xwt.impl.XFrameImpl;
import org.kdq.xwt.xreflect.XMethodToolBar;
import org.kdq.xwt.xreflect.XObjectPanel;
import org.kdq.xwt.xreflect.XObjectTree;
import org.kdq.xwt.xreflect.XReflectFrame;

public class XReflectFrameImpl extends XFrameImpl implements XReflectFrame {

	private XObjectTree objectTree = null;
	private XMethodToolBar methodToolBar = null;
	private XObjectPanel objectPanel = null;
	
	protected XReflectFrameImpl(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	public XObjectTree xgetObjectTree() {
		// TODO Auto-generated method stub
		return objectTree;
	}

	public XMethodToolBar xgetMethodToolBar() {
		// TODO Auto-generated method stub
		return methodToolBar;
	}

	public XObjectPanel xgetObjectPanel() {
		// TODO Auto-generated method stub
		return objectPanel;
	}

	public void xsetObjectTree(XObjectTree tree) {
		// TODO Auto-generated method stub
		objectTree = tree;
	}

	public void xsetMethodToolBar(XMethodToolBar toolBar) {
		// TODO Auto-generated method stub
		methodToolBar = toolBar;
	}

	public void xsetObjectPanel(XObjectPanel panel) {
		// TODO Auto-generated method stub
		objectPanel = panel;
	}
}
