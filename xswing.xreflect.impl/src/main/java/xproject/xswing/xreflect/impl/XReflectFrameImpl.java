package xproject.xswing.xreflect.impl;

import javax.swing.JFrame;

import xproject.xswing.impl.XFrameImpl;
import xproject.xswing.xreflect.XMethodToolBar;
import xproject.xswing.xreflect.XObjectPanel;
import xproject.xswing.xreflect.XObjectTree;
import xproject.xswing.xreflect.XReflectFrame;

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
