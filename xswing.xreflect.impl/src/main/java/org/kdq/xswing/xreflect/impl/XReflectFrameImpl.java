package org.kdq.xswing.xreflect.impl;

import javax.swing.JFrame;

import org.kdq.xswing.impl.XFrameImpl;
import org.kdq.xswing.xreflect.XMethodToolBar;
import org.kdq.xswing.xreflect.XObjectPanel;
import org.kdq.xswing.xreflect.XObjectTree;
import org.kdq.xswing.xreflect.XReflectFrame;

public class XReflectFrameImpl extends XFrameImpl implements XReflectFrame{

	private XObjectTree objectTree = null;
	private XMethodToolBar methodToolBar = null;
	private XObjectPanel objectPanel = null;
	
	public XReflectFrameImpl()
	{
		super(new JFrame());
	}

	public XObjectTree xgetObjectTree() {
		// TODO Auto-generated method stub
		return objectTree;
	}
	
	public void xsetObjectTree(XObjectTree tree)
	{
		objectTree = tree;
	}

	public XMethodToolBar xgetMethodToolBar() {
		// TODO Auto-generated method stub
		return methodToolBar;
	}
	
	public void xsetMethodToolBar(XMethodToolBar toolBar) {
		// TODO Auto-generated method stub
		methodToolBar = toolBar;
	}

	public XObjectPanel xgetObjectPanel() {
		// TODO Auto-generated method stub
		return objectPanel;
	}
	
	public void  xsetObjectPanel(XObjectPanel panel) {
		// TODO Auto-generated method stub
		objectPanel = panel;
	}
}
