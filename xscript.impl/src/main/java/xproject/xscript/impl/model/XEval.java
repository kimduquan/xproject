package xproject.xscript.impl.model;

import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.impl.XConstants;
import xproject.xutil.XScanner;

public class XEval extends XCommand {

	private XFactory xfactory;
	private String end;
	private XClassLoader xclassLoader;
	
	private String xscript;
	private XScriptContext xscriptContext;
	private XBindings xbindings;
	private XScanner xscanner;
	
	private XObject xreturn;
	
	private XParameters xparameters;
	
	public XEval(XFactory factory, XClassLoader classLoader, String endLine)
	{
		super(null);
		xfactory = factory;
		end = endLine;
		xclassLoader = classLoader;
		xparameters = null;
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xfactory = null;
		end = null;
		xclassLoader = null;
		xparameters = null;
		super.xfinalize();
	}
	
	protected XCommand xcommand(String method)
	{
		XCommand xcommand = null;
		if(method.equals(XConstants.IMPORT))
		{
			xcommand = new XImport(xparameters);
		}
		else if(method.equals(XConstants.NEW))
		{
			xcommand = new XNew(xparameters);
		}
		else if(method.equals(XConstants.TRY))
		{
			xcommand = new XTry(xparameters);
		}
		else if(method.equals(XConstants.IF))
		{
			xcommand = new XIf(xparameters);
		}
		else if(method.equals(XConstants.SUPER))
		{
			xcommand = new XSuper(xparameters);
		}
		else if(method.equals(XConstants.DO))
		{
			xcommand = new XDo(xparameters);
		}
		else if(method.equals(XConstants.FOR))
		{
			xcommand = new XFor(xparameters);
		}
		else if(method.equals(XConstants.GOTO))
		{
			xcommand = new XGoto(xparameters);
		}
		else if(method.equals(XConstants.WHILE))
		{
			xcommand = new XWhile(xparameters);
		}
		else if(method.equals(XConstants.THROW))
		{
			xcommand = new XThrow(xparameters);
		}
		else if(method.equals(XConstants.SYNCHRONIZED))
		{
			xcommand = new XSynchronized(xparameters);
		}
		else if(method.equals(XConstants.COMMENT_LINE))
		{
			xcommand = new XComment(xparameters);
		}
		else if(method.equals(XConstants.COMMENT_BLOCK))
		{
			xcommand = new XCommentBlock(xparameters);
		}
		else if(method.equals(XConstants.LAMBDA))
		{
			xcommand = new XLambda(xparameters);
		}
		else if(method.equals(XConstants.ASSERT))
		{
			xcommand = new XAssert(xparameters);
		}
		else
			xcommand = new XInvoke(xparameters);
		return xcommand;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		boolean bEnd = false;
		boolean bReturn = false;
		while(xscanner.xhasNextLine() && bEnd == false && bReturn == false)
		{
			try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xscanner.xnextLine()))
			{
				try(XParameters parameters = new XParameters(current.x(), xfactory, xbindings, xclassLoader))
				{
					String method = parameters.xmethod();
					if(method.isEmpty() == false)
					{
						try(XCommand xcommand = xcommand(method))
						{
							xcommand.xrun();
						}
						if(method.equals(end))
						{
							bEnd = true;
						}
						else if(method.equals(XConstants.RETURN))
						{
							bReturn = true;
						}
					}
				}
			}
		}
	}
	
	public void xscript(String script)
	{
		xscript = script;
	}
	
	public void xscriptContext(XScriptContext scriptContext)
	{
		xscriptContext = scriptContext;
	}
	
	public void xbindings(XBindings bindings)
	{
		xbindings = bindings;
	}
	
	public void xscanner(XScanner scanner)
	{
		xscanner = scanner;
	}
	
	public XObject xreturn()
	{
		return xreturn;
	}
}
