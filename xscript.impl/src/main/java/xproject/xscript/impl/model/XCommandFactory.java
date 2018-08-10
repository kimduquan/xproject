package xproject.xscript.impl.model;

import xproject.xrmi.XRemote;
import xproject.xscript.impl.XConstants;

public class XCommandFactory implements XRemote {

	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}

	public XCommand xcommand(String method, XEval xeval, XLine xline) throws Exception
	{
		XCommand xcommand = null;
		if(method.equals(XConstants.IMPORT))
		{
			xcommand = new XImport(xline, xeval);
		}
		else if(method.equals(XConstants.NEW))
		{
			xcommand = new XNew(xline, xeval);
		}
		else if(method.equals(XConstants.TRY))
		{
			xcommand = new XTry(xline, xeval);
		}
		else if(method.equals(XConstants.IF))
		{
			xcommand = new XIf(xline, xeval);
		}
		else if(method.equals(XConstants.SUPER))
		{
			xcommand = new XSuper(xline, xeval);
		}
		else if(method.equals(XConstants.DO))
		{
			xcommand = new XDo(xline, xeval);
		}
		else if(method.equals(XConstants.FOR))
		{
			xcommand = new XFor(xline, xeval);
		}
		else if(method.equals(XConstants.GOTO))
		{
			xcommand = new XGoto(xline, xeval);
		}
		else if(method.equals(XConstants.WHILE))
		{
			xcommand = new XWhile(xline, xeval);
		}
		else if(method.equals(XConstants.THROW))
		{
			xcommand = new XThrow(xline, xeval);
		}
		else if(method.equals(XConstants.SYNCHRONIZED))
		{
			xcommand = new XSynchronized(xline, xeval);
		}
		else if(method.equals(XConstants.COMMENT_LINE))
		{
			xcommand = new XComment(xline, xeval);
		}
		else if(method.equals(XConstants.COMMENT_BLOCK))
		{
			xcommand = new XCommentBlock(xline, xeval);
		}
		else if(method.equals(XConstants.LAMBDA))
		{
			xcommand = new XLambda(xline, xeval);
		}
		else if(method.equals(XConstants.ASSERT))
		{
			xcommand = new XAssert(xline, xeval);
		}
		else
			xcommand = new XInvoke(xline, xeval);
		return xcommand;
	}
}
