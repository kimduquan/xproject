package xproject.xap.xui.impl.xmenu;

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;

import xproject.xap.xui.XElementContainer;
import xproject.xap.xui.xmenu.XMenu;
import xproject.xap.xui.xmenu.XMenuElement;

public class XMenuImpl extends XMenuElementImpl implements XMenu {
	
	private MMenu mmenu;
	
	protected XMenuImpl(MMenu menu) {
		super(menu);
		this.mmenu = menu;
	}

	public static XMenu xnew(MMenu mmenu)
	{
		return new XMenuImpl(mmenu);
	}

	public void xadd(XMenuElement element) throws Exception
	{
		// TODO Auto-generated method stub
		mmenu.getChildren().add((MMenuElement) element.x());
	}

	public XElementContainer<XMenuElement> xgetChildren() throws Exception {
		// TODO Auto-generated method stub
		return this;
	}
}
