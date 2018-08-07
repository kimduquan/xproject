package xproject.xscript.test;

import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xlang.impl.XClassLoaderImpl;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xscript.XBindings;
import xproject.xscript.XScriptContext;
import xproject.xscript.impl.XBindingsImpl;
import xproject.xscript.impl.XScriptContextImpl;
import xproject.xscript.impl.model.XCommandFactory;
import xproject.xscript.impl.model.XScriptEngineModel;
import xproject.xutil.XScanner;
import xproject.xutil.impl.XScannerImpl;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	/*System.setProperty("webdriver.edge.driver", "D:\\installed\\MS Webdriver\\MicrosoftWebDriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://www.google.com");
        driver.close();*/
        
        XFactory xfactory = XFactoryImpl.xnew();
        XCommandFactory xcommandFactory = new XCommandFactory();
        XClassLoader xclassLoader = XClassLoaderImpl.xnew(ClassLoader.getSystemClassLoader(), xfactory);
        XScriptEngineModel engine = new XScriptEngineModel(xfactory, xcommandFactory, xclassLoader);
        XScanner xscanner = XScannerImpl.xnew("File", "test.xs");
        XBindings xbindingsEngine = XBindingsImpl.xnew();
        XBindings xbindingsGlobal = XBindingsImpl.xnew();
        XBindings xbindings = XBindingsImpl.xnew();
        try {
			engine.xeval(xscanner, xbindings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
