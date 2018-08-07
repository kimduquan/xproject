package xproject.xscript.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import xproject.xlang.XClassLoader;
import xproject.xlang.XFactory;
import xproject.xlang.impl.XClassLoaderImpl;
import xproject.xlang.impl.XFactoryImpl;
import xproject.xscript.XBindings;
import xproject.xscript.impl.XBindingsImpl;
import xproject.xscript.impl.model.XCommandFactory;
import xproject.xscript.impl.model.XScriptEngineModel;
import xproject.xutil.XScanner;
import xproject.xutil.impl.XScannerImpl;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.edge.driver", "D:\\installed\\MSWebdriver\\MicrosoftWebDriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://www.google.com");
        WebElement input = driver.findElementById("lst-ib");
        assert(input != null);
        input.sendKeys("abc");
        WebElement button = driver.findElementByName("btnK");
        assert(button != null);
        button.click();
        try
        {
            WebElement abc = driver.findElementByPartialLinkText("ABC.com");
        }
        catch(Exception ex)
        {
        	
        }
        driver.close();*/
        
        XFactory xfactory = XFactoryImpl.xnew();
        try {
			xfactory.xref(xfactory);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
