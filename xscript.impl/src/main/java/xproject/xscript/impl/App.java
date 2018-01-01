package xproject.xscript.impl;

import xproject.util.XScanner;
import xproject.util.impl.XScannerImpl;
import xproject.xlang.impl.XFactory;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xscript.XScriptContext;
import xproject.xscript.XScriptEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        XScanner scanner = XScannerImpl.xnew("InputStream", "System.in");
        XScriptContext context = XScriptContextImpl.xnew();
        XFactory xfactory = XFactoryImpl.xnew();
        XScriptEngine engine = XScriptEngineImpl.xnew(xfactory);
        try {
			engine.xeval(scanner, context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
