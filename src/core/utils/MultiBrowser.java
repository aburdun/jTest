package core.utils;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MultiBrowser {

	public static WebDriver browser;
	
	public MultiBrowser(WebDriver browser){
		MultiBrowser.browser = browser;
	}
	
	public static void waitWhileLoading(WebDriver driver) {
	    ExpectedCondition<Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(pageLoadCondition);
	}
	
	public static <T extends SearchContext> WebElement getElement(T parent, String elementLocator, String elementIdentifier){
		WebElement generalElement = null;
		try {
			Method method = By.class.getMethod(elementLocator, String.class);
			generalElement = parent.findElement((By) method.invoke(elementLocator, elementIdentifier));
		}
		catch (Exception e){
			e.getMessage();
		}
		return generalElement;
	}
}