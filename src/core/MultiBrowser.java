package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {
	public WebDriver browser;
	
	public MultiBrowser(){
		browser = new FirefoxDriver();
	}
}
