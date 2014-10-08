package core.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralObject {
	public WebDriver browser;
	public String elementLocator;
	public String elementIdentifier;
	private WebElement generalObject;
	
	public GeneralObject(WebDriver browser, String elementLocator, String elementIdentifier) {
		this.browser = browser;
		this.elementLocator = elementLocator;
		this.elementIdentifier = elementIdentifier;
		setGeneralObject();
	}
	
	public GeneralObject(WebDriver browser, WebElement generalObject) {
		this.browser = browser;
		setGeneralObject(generalObject);
	}
	
	private void setGeneralObject(){
		switch (elementLocator) {
			case "xpath":
				generalObject = browser.findElement(By.xpath(elementIdentifier));
				break;
			case "id":
				generalObject = browser.findElement(By.id(elementIdentifier));
				break;
			case "name":
				generalObject = browser.findElement(By.name(elementIdentifier));
				break;
			case "class":
				generalObject = browser.findElement(By.className(elementIdentifier));
				break;
			case "css":
				generalObject = browser.findElement(By.cssSelector(elementIdentifier));
				break;
			case "tag":
				generalObject = browser.findElement(By.tagName(elementIdentifier));
				break;
			case "partialLink":
				generalObject = browser.findElement(By.partialLinkText(elementIdentifier));
				break;
			default:
				//TBD
				break;
		}
	}
	
	private void setGeneralObject(WebElement generalObject){
		this.generalObject = generalObject;
	}
	
	protected WebElement getGeneralObject() {
		return generalObject;
	}
	
	public void click(){
		generalObject.click();
		MultiBrowser.waitWhileLoading(browser);
	}
}
