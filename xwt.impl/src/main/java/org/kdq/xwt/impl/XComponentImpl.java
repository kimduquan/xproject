package org.kdq.xwt.impl;

import java.awt.Component;

import org.kdq.xwt.XComponent;

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
