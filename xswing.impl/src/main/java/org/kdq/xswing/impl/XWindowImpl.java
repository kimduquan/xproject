package org.kdq.xswing.impl;

import java.awt.Window;

import org.kdq.xswing.XWindow;

public class XWindowImpl extends XContainerImpl implements XWindow {

	private Window window = null;
	
	protected XWindowImpl(Window window)
	{
		super(window);
		this.window = window;
	}

	public void xsetVisible(boolean b) {
		// TODO Auto-generated method stub
		window.setVisible(b);
	}

}
