package xproject.xscript.impl.model;

import xproject.xrmi.XRemote;
import xproject.xscript.impl.XConstants;

public class XCommandFactory implements XRemote {

	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}

	public XCommand xcommand(String method, XEval xeval, XParameters xparameters) throws Exception
	{
		XCommand xcommand = null;
		if(method.equals(XConstants.IMPORT))
		{
			xcommand = new XImport(xparameters, xeval);
		}
		else if(method.equals(XConstants.NEW))
		{
			xcommand = new XNew(xparameters, xeval);
		}
		else if(method.equals(XConstants.TRY))
		{
			xcommand = new XTry(xparameters, xeval);
		}
		else if(method.equals(XConstants.IF))
		{
			xcommand = new XIf(xparameters, xeval);
		}
		else if(method.equals(XConstants.SUPER))
		{
			xcommand = new XSuper(xparameters, xeval);
		}
		else if(method.equals(XConstants.DO))
		{
			xcommand = new XDo(xparameters, xeval);
		}
		else if(method.equals(XConstants.FOR))
		{
			xcommand = new XFor(xparameters, xeval);
		}
		else if(method.equals(XConstants.GOTO))
		{
			xcommand = new XGoto(xparameters, xeval);
		}
		else if(method.equals(XConstants.WHILE))
		{
			xcommand = new XWhile(xparameters, xeval);
		}
		else if(method.equals(XConstants.THROW))
		{
			xcommand = new XThrow(xparameters, xeval);
		}
		else if(method.equals(XConstants.SYNCHRONIZED))
		{
			xcommand = new XSynchronized(xparameters, xeval);
		}
		else if(method.equals(XConstants.COMMENT_LINE))
		{
			xcommand = new XComment(xparameters, xeval);
		}
		else if(method.equals(XConstants.COMMENT_BLOCK))
		{
			xcommand = new XCommentBlock(xparameters, xeval);
		}
		else if(method.equals(XConstants.LAMBDA))
		{
			xcommand = new XLambda(xparameters, xeval);
		}
		else if(method.equals(XConstants.ASSERT))
		{
			xcommand = new XAssert(xparameters, xeval);
		}
		else
			xcommand = new XInvoke(xparameters, xeval);
		return xcommand;
	}
}
