package xproject.xap.impl;

import java.util.Map;

import org.eclipse.e4.ui.model.application.MApplicationElement;

import xproject.xap.XApplicationElement;

public class XApplicationElementImpl implements XApplicationElement {

	private MApplicationElement melement;
	
	protected XApplicationElementImpl(MApplicationElement element)
	{
		melement = element;
	}
	
	public Map<String, Object> xgetTransientData() throws Exception {
		// TODO Auto-generated method stub
		return melement.getTransientData();
	}

	@Override
	public String xgetContributorURI() throws Exception {
		// TODO Auto-generated method stub
		return melement.getContributorURI();
	}

	@Override
	public void xsetContributorURI(String value) throws Exception {
		// TODO Auto-generated method stub
		melement.setContributorURI(value);
	}

	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		melement = null;
		finalize();
	}

}
