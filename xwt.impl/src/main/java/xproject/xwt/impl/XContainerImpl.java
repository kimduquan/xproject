package xproject.xwt.impl;

import java.awt.Container;

import xproject.xwt.XComponent;
import xproject.xwt.XContainer;

public class XContainerImpl extends XComponentImpl implements XContainer {

	private Container container = null;
	
	protected XContainerImpl(Container cont) {
		super(cont);
		// TODO Auto-generated constructor stub
		container = cont;
	}

	public void xadd(XComponent comp) {
		// TODO Auto-generated method stub
		if(comp instanceof XComponentImpl)
		{
			container.add(((XComponentImpl)comp).xget());
		}
	}

}
