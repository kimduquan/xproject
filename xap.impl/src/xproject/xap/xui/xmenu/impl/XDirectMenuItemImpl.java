package xproject.xap.xui.xmenu.impl;

import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;

import xproject.xap.xui.xmenu.XDirectMenuItem;

public class XDirectMenuItemImpl extends XMenuElementImpl implements XDirectMenuItem {

	private MDirectMenuItem mmenuItem;
	
	protected XDirectMenuItemImpl(MDirectMenuItem mmenuItem) {
		super(mmenuItem);
		// TODO Auto-generated constructor stub
		this.mmenuItem = mmenuItem;
	}
	
	public void xsetContributionURI(String uri) throws Exception
	{
		this.mmenuItem.setContributionURI(uri);
	}
	
	public String xgetContributionURI() throws Exception
	{
		return this.mmenuItem.getContributionURI();
	}

	public static XDirectMenuItem xnew(MDirectMenuItem item)
	{
		return new XDirectMenuItemImpl(item);
	}
}
