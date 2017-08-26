package org.kdq.xwt.xreflect.impl;

import java.awt.Container;

import org.kdq.xwt.impl.XTreeImpl;
import org.kdq.xwt.xreflect.XMethodPopupMenu;
import org.kdq.xwt.xreflect.XObjectTree;

public class XObjectTreeImpl extends XTreeImpl implements XObjectTree{

	private XMethodPopupMenu methodPopupMenu = null;
	
	protected XObjectTreeImpl(Container cont) {
		super(cont);
		// TODO Auto-generated constructor stub
	}

	public XMethodPopupMenu xgetMethodPopupMenu() {
		// TODO Auto-generated method stub
		return methodPopupMenu;
	}

	public void xsetMethodPopupMenu(XMethodPopupMenu popup)
	{
		methodPopupMenu = popup;
	}

}
