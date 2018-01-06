package xproject.xap.xui.impl.xmenu;

import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;

import xproject.xap.xui.xmenu.XDirectMenuItem;

public class XDirectMenuItemImpl extends XMenuElementImpl implements XDirectMenuItem {

	protected XDirectMenuItemImpl(MDirectMenuItem mmenuItem) {
		super(mmenuItem);
		// TODO Auto-generated constructor stub
	}

	public static XDirectMenuItem xnew(MDirectMenuItem item)
	{
		return new XDirectMenuItemImpl(item);
	}
}
