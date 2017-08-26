package org.kdq.xswing.impl;

import javax.swing.JTree;
import org.kdq.xswing.XTree;
import org.kdq.xswing.xtree.XTreeNode;

public class XTreeImpl implements XTree {

	private JTree tree = null;
	
	public XTreeImpl()
	{
		tree = new JTree();
	}
	
	public XTreeImpl(XTreeNode node)
	{
		
	}
}
