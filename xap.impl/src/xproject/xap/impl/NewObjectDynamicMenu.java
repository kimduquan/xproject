 
package xproject.xap.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;

import xproject.xap.xmenu.XNewObjectDynamicMenu;
import xproject.xap.xui.impl.xmenu.XMenuFactoryImpl;
import xproject.xap.xui.xmenu.XMenuElement;
import xproject.xap.xui.xmenu.XMenuFactory;
import xproject.xrmi.xregistry.XRegistry;
import xproject.xrmi.xregistry.impl.XRegistryImpl;

public class NewObjectDynamicMenu extends XNewObjectDynamicMenu {
	@AboutToShow
	public void aboutToShow(List<MMenuElement> items) throws Exception {
		ArrayList<XMenuElement> xitems = new ArrayList<XMenuElement>();
		xaboutToShow(xitems);
		for(XMenuElement xitem : xitems)
		{
			items.add((MMenuElement) xitem.x());
		}
	}
	
	
	@AboutToHide
	public void aboutToHide(List<MMenuElement> items) throws Exception {
		
	}


	@Override
	protected XRegistry xregistry() {
		// TODO Auto-generated method stub
		return XRegistryImpl.xnew();
	}


	@Override
	protected XMenuFactory xmenuFactory() {
		// TODO Auto-generated method stub
		return XMenuFactoryImpl.xinstance();
	}
		
}