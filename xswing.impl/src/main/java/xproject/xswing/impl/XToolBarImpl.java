package xproject.xswing.impl;

import javax.swing.JToolBar;

import org.kdq.xswing.XToolBar;

public class XToolBarImpl implements XToolBar {

	private JToolBar toolBar = null;
	
	public XToolBarImpl()
	{
		toolBar = new JToolBar();
	}
}
