package tests.utils;

import java.net.MalformedURLException;
import java.net.URL;
 




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import core.utils.MessageCollector;
 
public class BaseTest {

    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    protected MessageCollector collector = new MessageCollector();;
 
    @BeforeMethod
    public void setUp() throws MalformedURLException {
    	collector.clearMessages();
        threadDriver = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities dc = new DesiredCapabilities();
        FirefoxProfile fp = new FirefoxProfile();
        dc.setCapability(FirefoxDriver.PROFILE, fp);
        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
    }
 
    public WebDriver getDriver() {
        return threadDriver.get();
    }
 
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
    
    
}
