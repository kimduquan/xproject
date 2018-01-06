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

}
