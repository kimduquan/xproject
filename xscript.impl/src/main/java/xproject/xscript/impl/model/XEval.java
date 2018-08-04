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
	
	private boolean isReturn;
	private boolean isFinal;
	private boolean isEnd;
	
	private XCommand xend;
	
	protected XEval(XFactory factory, XClassLoader classLoader, String end)
	{
		super(null, null);
		xfactory = factory;
		this.end = end;
		xclassLoader = classLoader;
		xparameters = null;
		isReturn = false;
		isFinal = false;
		isEnd = false;
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
			xcommand = new XImport(xparameters, this);
		}
		else if(method.equals(XConstants.NEW))
		{
			xcommand = new XNew(xparameters, this);
		}
		else if(method.equals(XConstants.TRY))
		{
			xcommand = new XTry(xparameters, this);
		}
		else if(method.equals(XConstants.IF))
		{
			xcommand = new XIf(xparameters, this);
		}
		else if(method.equals(XConstants.SUPER))
		{
			xcommand = new XSuper(xparameters, this);
		}
		else if(method.equals(XConstants.DO))
		{
			xcommand = new XDo(xparameters, this);
		}
		else if(method.equals(XConstants.FOR))
		{
			xcommand = new XFor(xparameters, this);
		}
		else if(method.equals(XConstants.GOTO))
		{
			xcommand = new XGoto(xparameters, this);
		}
		else if(method.equals(XConstants.WHILE))
		{
			xcommand = new XWhile(xparameters, this);
		}
		else if(method.equals(XConstants.THROW))
		{
			xcommand = new XThrow(xparameters, this);
		}
		else if(method.equals(XConstants.SYNCHRONIZED))
		{
			xcommand = new XSynchronized(xparameters, this);
		}
		else if(method.equals(XConstants.COMMENT_LINE))
		{
			xcommand = new XComment(xparameters, this);
		}
		else if(method.equals(XConstants.COMMENT_BLOCK))
		{
			xcommand = new XCommentBlock(xparameters, this);
		}
		else if(method.equals(XConstants.LAMBDA))
		{
			xcommand = new XLambda(xparameters, this);
		}
		else if(method.equals(XConstants.ASSERT))
		{
			xcommand = new XAssert(xparameters, this);
		}
		else
			xcommand = new XInvoke(xparameters, this);
		return xcommand;
	}
	
	private void setFinal()
	{
		isFinal = true;
	}
	
	private void setReturn()
	{
		isReturn = true;
		if(xeval() != null)
		{
			xeval().setReturn();
		}
	}
	
	private void setEnd()
	{
		isEnd = true;
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		while(xscanner.xhasNextLine() && isFinal == false && isReturn == false && isEnd == false)
		{
			try(XAutoCloseable<XScanner> current = new XAutoCloseable<XScanner>(xscanner.xnextLine()))
			{
				try(XParameters parameters = new XParameters(current.x(), this, null))
				{
					String method = parameters.xmethod();
					if(method.isEmpty() == false)
					{
						if(method.equals(end))
						{
							setEnd();
						}
						else if(method.equals(XConstants.RETURN))
						{
							try(XCommand xcommand = xcommand(method))
							{
								xcommand.xrun();
							}
							setReturn();
						}
						else if(method.equals(XConstants.FINAL))
						{
							try(XCommand xcommand = xcommand(method))
							{
								xcommand.xrun();
							}
							setFinal();
						}
						else
						{
							try(XCommand xcommand = xcommand(method))
							{
								xcommand.xrun();
							}
						}
					}
				}
			}
		}
	}
	
	public String xscript()
	{
		return xscript;
	}
	
	public XScriptContext xscriptContext()
	{
		return xscriptContext;
	}
	
	public XBindings xbindings()
	{
		return xbindings;
	}
	
	public XScanner xscanner()
	{
		return xscanner;
	}
	
	public XObject xreturn()
	{
		return xreturn;
	}
	
	public XFactory xfactory()
	{
		return xfactory;
	}
	
	public XClassLoader xclassLoader()
	{
		return xclassLoader;
	}
	
	public XParameters xgoto(String end) throws Exception
	{
		return null;
	}
	
	public static XEval xnew(XEval eval, String end) throws Exception
	{
		XEval xeval = new XEval(eval.xfactory, eval.xclassLoader, end);
		xeval.xbindings = eval.xbindings;
		xeval.xscanner = eval.xscanner;
		xeval.xscript = eval.xscript;
		xeval.xscriptContext = eval.xscriptContext;
		return xeval;
	}
	
	public XCommand xend()
	{
		return xend;
	}
}
