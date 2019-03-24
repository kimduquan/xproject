package xproject.xdriver.test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			RemoteWebDriver remote = new RemoteWebDriver(new URL("http://localhost:9998"), DesiredCapabilities.edge());
			remote.manage().timeouts();
			remote.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			remote.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
			remote.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
			remote.navigate().to("http://www.google.com");
			remote.getCurrentUrl();
			remote.navigate().back();
			remote.navigate().forward();
			remote.navigate().refresh();
			remote.getTitle();
			remote.getWindowHandle();
			remote.close();
			remote.switchTo().window("window-1");
			remote.getWindowHandles();
			remote.switchTo().frame(1);
			remote.switchTo().parentFrame();
			remote.manage().window().getPosition();
			remote.manage().window().setSize(new Dimension(0, 0));
			remote.manage().window().maximize();
			remote.manage().window().fullscreen();
			WebElement ele = remote.switchTo().activeElement();
			remote.findElement(By.className("className"));
			remote.findElements(By.cssSelector("cssSelector"));
			ele.findElement(By.id("id"));
			ele.findElements(By.linkText("linkText"));
			remote.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
