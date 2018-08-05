package xproject.xscript.impl.model;

import java.util.HashMap;
import java.util.Map;

import xproject.xlang.XClass;
import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xlang.XObject;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
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
	
	private boolean isReturn;
	private boolean isFinal;
	
	private XParameters xend;
	private XCommandFactory xcommandFactory;
	private int xbindingsScope;
	private Map<String, XClass> xclasses;
	
	protected XEval(XCommandFactory commandFactory, XFactory factory, XClassLoader classLoader, String end, int bindingsScope)
	{
		super(null, null);
		xfactory = factory;
		this.end = end;
		xclassLoader = classLoader;
		isReturn = false;
		isFinal = false;
		xcommandFactory = commandFactory;
		xbindingsScope = bindingsScope;
		xclasses = new HashMap<String, XClass>();
	}
	
	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		xfactory = null;
		end = null;
		xclassLoader = null;
		xcommandFactory = null;
		xclasses.clear();
		xclasses = null;
		super.xfinalize();
	}

	@Override
	public void xrun() throws Exception {
		// TODO Auto-generated method stub
		xeval(this, end);
	}
	
	public String xscript()
	{
		return xscript;
	}
	
	public XScriptContext xscriptContext()
	{
		return xscriptContext;
	}
	
	public XBindings xbindings() throws Exception
	{
		if(xbindings == null)
		{
			xbindings = xscriptContext.xgetBindings(xbindingsScope);
		}
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
	
	public XCommandFactory xcommandFactory()
	{
		return xcommandFactory;
	}
	
	public static XEval xnew(XEval eval, String end) throws Exception
	{
		XEval xeval = new XEval(eval.xcommandFactory, eval.xfactory, eval.xclassLoader, end, eval.xbindingsScope + 1);
		xeval.xbindings = eval.xbindings;
		xeval.xscanner = eval.xscanner;
		xeval.xscript = eval.xscript;
		xeval.xscriptContext = eval.xscriptContext;
		xeval.xclasses = eval.xclasses;
		return xeval;
	}
	
	public XParameters xend()
	{
		return xend;
	}

	@Override
	protected boolean xisBlock() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean xisReturn()
	{
		return isReturn;
	}
	
	public void xreturn(XObject xobject) throws Exception
	{
		isReturn = true;
		xreturn = xobject;
	}
	
	public boolean xisFinal()
	{
		return isFinal;
	}
	
	public void xfinal() throws Exception
	{
		isFinal = true;
	}
	
	protected XEval xeval()
	{
		return this;
	}
	
	public Map<String, XClass> xclasses()
	{
		return xclasses;
	}
}
