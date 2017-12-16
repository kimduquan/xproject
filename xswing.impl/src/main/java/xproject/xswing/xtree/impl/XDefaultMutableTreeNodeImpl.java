package xproject.xswing.xtree.impl;

import javax.swing.tree.DefaultMutableTreeNode;

import xproject.xlang.XObject;
import org.kdq.xswing.xtree.XMutableTreeNode;

public class XDefaultMutableTreeNodeImpl implements XMutableTreeNode {

	private DefaultMutableTreeNode treeNode;
	
	public XDefaultMutableTreeNodeImpl()
	{
		treeNode = new DefaultMutableTreeNode();
	}
	
	public XDefaultMutableTreeNodeImpl(XObject obj)
	{
		treeNode = new DefaultMutableTreeNode(obj);
	}
	
	public XDefaultMutableTreeNodeImpl(XObject obj, boolean allowsChildren)
	{
		treeNode = new DefaultMutableTreeNode(obj, allowsChildren);
	}
}
