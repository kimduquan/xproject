package xproject.xap.xui.impl;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

import xproject.xap.impl.XApplicationElementImpl;
import xproject.xap.xui.XUIElement;

public class XUIElementImpl extends XApplicationElementImpl implements XUIElement {
	
	private MUIElement melement;

	protected XUIElementImpl(MUIElement element)
	{
		super(element);
		melement = element;
	}
	
	public Object x() throws Exception {
		// TODO Auto-generated method stub
		return melement;
	}

}
