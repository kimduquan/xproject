package xproject.xscript.impl.model;

import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xrmi.XRemote;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.impl.XConstants;
import xproject.xutil.XScanner;

public class XEval implements XRemote {

	private XFactory xfactory;
	private String end;
	private XClassLoader xclassLoader;
	
	public XEval(XFactory factory, XClassLoader classLoader, String endLine)
	{
		xfactory = factory;
		end = endLine;
		xclassLoader = classLoader;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xfactory = null;
		end = null;
		xclassLoader = null;
		finalize();
	}
	
	protected void xinvoke(XParameters xparameters) throws Exception
	{
		try(XAutoCloseableImpl<XClassParameter> xclass = new XAutoCloseableImpl<XClassParameter>( new XClassParameter(xparameters)))
		{
			try(XAutoCloseableImpl<XThisParameter> xthis = new XAutoCloseableImpl<XThisParameter>( new XThisParameter(xparameters)))
			{
				try(XAutoCloseableImpl<XMethodParameter> xmethod = new XAutoCloseableImpl<XMethodParameter>( new XMethodParameter(xparameters, xclass.x(), xthis.x())))
				{
					if(xmethod.x().xmethod() != null)
					{
						XObject xobject = xmethod.x().xmethod().xinvoke(xthis.x().xthis(), xparameters.xparameters());
						try(XAutoCloseableImpl<XReturnParameter> xreturn = new XAutoCloseableImpl<XReturnParameter>( new XReturnParameter(xparameters)))
						{
							xreturn.x().xreturn(xobject);
						}
					}
				}
			}
		}
	}
	
	public XObject xeval(String xscript, XScriptContext xscriptContext, XBindings xbindings, XScanner xscanner) throws Exception
	{
		XObject xobject = null;
		boolean bEnd = false;
		boolean bReturn = false;
		while(xscanner.xhasNextLine() && bEnd == false && bReturn == false)
		{
			try(XAutoCloseableImpl<XScanner> current = new XAutoCloseableImpl<XScanner>(xscanner.xnextLine()))
			{
				try(XAutoCloseableImpl<XParameters> xparameters = new XAutoCloseableImpl<XParameters>(new XParameters(current.x(), xfactory, xbindings, xclassLoader)))
				{
					String method = xparameters.x().xmethod();
					if(method.isEmpty() == false)
					{
						if(method.equals(end))
						{
							if(xeval(xparameters.x()) == false)
							{
								xinvoke(xparameters.x());
							}
							bEnd = true;
						}
						else if(method.equals(XConstants.RETURN))
						{
							try(XAutoCloseableImpl<XReturn> xreturn = new XAutoCloseableImpl<XReturn>(new XReturn(xparameters.x())))
							{
								xobject = xreturn.x().xreturn();
							}
							bReturn = true;
						}
						else if(xeval(xparameters.x()) == false)
						{
							xinvoke(xparameters.x());
						}
					}
				}
			}
		}
		return xobject;
	}
	
	protected boolean xeval(XParameters xparameters) throws Exception
	{
		if(xparameters.xmethod().equals(XConstants.IMPORT))
		{
			try(XAutoCloseableImpl<XImport> ximport = new XAutoCloseableImpl<XImport>(new XImport(xparameters)))
			{
				ximport.x().ximport();
			}
		}
		return false;
	}
}
