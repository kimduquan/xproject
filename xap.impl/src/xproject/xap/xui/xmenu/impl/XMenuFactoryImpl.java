package xproject.xap.xui.xmenu.impl;

import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;

import xproject.xap.xui.xmenu.XDirectMenuItem;
import xproject.xap.xui.xmenu.XMenu;
import xproject.xap.xui.xmenu.XMenuFactory;

public class XMenuFactoryImpl implements XMenuFactory {

	protected XMenuFactoryImpl()
	{
	}
	
	public XDirectMenuItem xcreateDirectMenuItem() throws Exception {
		// TODO Auto-generated method stub
		return XDirectMenuItemImpl.xnew(MMenuFactory.INSTANCE.createDirectMenuItem());
	}

	private static XMenuFactory instance = null;
	
	public static XMenuFactory xinstance()
	{
		if(instance == null)
		{
			instance = new XMenuFactoryImpl();
		}
		return instance;
	}

	public XMenu xcreateMenu() throws Exception 
	{
		// TODO Auto-generated method stub
		return XMenuImpl.xnew(MMenuFactory.INSTANCE.createMenu());
	}
}
