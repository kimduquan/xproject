package xproject.xarchitecture.impl;

import xproject.xarchitecture.XAgent;
import xproject.xarchitecture.XContainer;
import xproject.xarchitecture.XRMIAgent;

public class XContainerImpl implements XContainer {

	private Process process;
	private String name;
	private XRMIAgent xrmi;
	
	protected  XContainerImpl(String name) throws Exception
	{
		process = null;
		this.name = name;
		xrmi = null;
	}
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		
	}

	public void xmain(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public XContainer xcontainer(String name) throws Exception {
		// TODO Auto-generated method stub
		return new XContainerImpl(name);
	}

	public XAgent xagent(String name) throws Exception {
		// TODO Auto-generated method stub
		if(name.equals(XRMIAgent.Name))
		{
			if(xrmi == null)
				xrmi = XRMIAgentImpl.xnew();
			return xrmi;
		}
	}

	
}
