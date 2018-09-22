package xproject.xarchitecture.impl;

import xproject.xarchitecture.XRMIAgent;
import xproject.xrmi.xregistry.XRegistry;

public class XRMIAgentImpl implements XRMIAgent {

	protected XRMIAgentImpl()
	{
		
	}
	
	public void xstart() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void xstop() throws Exception {
		// TODO Auto-generated method stub

	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		this.finalize();
	}

	public XRegistry xregistry() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static XRMIAgent xnew()
	{
		return new XRMIAgentImpl();
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return XRMIAgent.Name;
	}
}
