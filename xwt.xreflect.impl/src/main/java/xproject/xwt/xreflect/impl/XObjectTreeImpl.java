package xproject.xwt.xreflect.impl;

import java.awt.Container;

import xproject.xwt.impl.XTreeImpl;
import xproject.xwt.xreflect.XMethodPopupMenu;
import xproject.xwt.xreflect.XObjectTree;

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
