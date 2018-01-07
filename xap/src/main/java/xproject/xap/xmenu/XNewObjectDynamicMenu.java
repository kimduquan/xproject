package xproject.xap.xmenu;

import java.util.List;

import xproject.xap.xui.xmenu.XDirectMenuItem;
import xproject.xap.xui.xmenu.XMenu;
import xproject.xap.xui.xmenu.XMenuElement;
import xproject.xap.xui.xmenu.XMenuFactory;
import xproject.xlang.XClass;
import xproject.xlang.xreflect.XConstructor;
import xproject.xrmi.XRemote;
import xproject.xrmi.xregistry.XRegistry;

public abstract class XNewObjectDynamicMenu implements XDynamicMenu {

	abstract protected XRegistry xregistry();
	abstract protected XMenuFactory xmenuFactory();
	abstract protected String xgetContributionURI();
	
	public void xaboutToShow(List<XMenuElement> items) throws Exception {
		// TODO Auto-generated method stub
		XMenuFactory xfactory = xmenuFactory();
		XRegistry xregistry = xregistry();
		
		for(String cls : xregistry.xlist())
		{
			XRemote xremote = xregistry.xlookup(cls);
			if(xremote instanceof XClass)
			{
				XClass xclass = (XClass) xremote;
				if(xclass.xgetModifiers().xisAbstract() == false)
				{
					XConstructor[] xconstructors = xclass.xgetConstructors();
					if(xconstructors.length > 0)
					{
						if(xconstructors.length == 1)
						{
							XDirectMenuItem xmenuItem = xfactory.xcreateDirectMenuItem();
							xmenuItem.xsetLabel(xclass.xgetSimpleName());
							xmenuItem.xsetContributionURI(this.xgetContributionURI());
							xmenuItem.xsetContributorURI(this.xgetContributionURI());
							items.add(xmenuItem);
							xmenuItem.xgetTransientData().put("XConstructor", xconstructors[0]);
						}
						else
						{
							XMenu xmenu = xfactory.xcreateMenu();
							xmenu.xsetLabel(xclass.xgetSimpleName());
							items.add(xmenu);
							for(XConstructor xconstructor : xconstructors)
							{
								XDirectMenuItem xmenuItem = xfactory.xcreateDirectMenuItem();
								xmenuItem.xsetLabel(xclass.xgetSimpleName());
								xmenuItem.xsetContributionURI(this.xgetContributionURI());
								xmenuItem.xsetContributorURI(this.xgetContributionURI());
								xmenu.xgetChildren().xadd(xmenuItem);
								xmenuItem.xgetTransientData().put("XConstructor", xconstructor);
							}
						}
					}
				}
			}
		}
	}

	public void xaboutToHide(List<XMenuElement> items) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
