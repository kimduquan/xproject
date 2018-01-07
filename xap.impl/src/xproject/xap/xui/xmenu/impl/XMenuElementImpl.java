package xproject.xap.xui.xmenu.impl;

import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;

import xproject.xap.xui.impl.XUIElementImpl;
import xproject.xap.xui.xmenu.XMenuElement;

public class XMenuElementImpl extends XUIElementImpl implements XMenuElement {

	private MMenuElement mmenu;
	
	protected XMenuElementImpl(MMenuElement mmenu)
	{
		super(mmenu);
		this.mmenu = mmenu;
	}

	public String xgetLabel() throws Exception {
		// TODO Auto-generated method stub
		return this.mmenu.getLabel();
	}

	public void xsetLabel(String label) throws Exception {
		// TODO Auto-generated method stub
		this.mmenu.setLabel(label);
	}
}
