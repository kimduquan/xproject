package org.kdq.xswing.impl;

import java.awt.Component;

import org.kdq.xswing.XComponent;

public class XComponentImpl implements XComponent {

	private Component component = null;
	
	protected XComponentImpl(Component comp)
	{
		component = comp;
	}

	protected Component xget()
	{
		return component;
	}
}
