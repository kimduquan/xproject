package org.kdq.xwt.impl;

import java.awt.Window;

import org.kdq.xwt.XWindow;

public class XWindowImpl extends XContainerImpl implements XWindow {

	private Window window = null;
	
	protected XWindowImpl(Window wnd) {
		super(wnd);
		// TODO Auto-generated constructor stub
		window = wnd;
	}

	public void xsetVisible(boolean b) {
		// TODO Auto-generated method stub
		window.setVisible(b);
	}

}
