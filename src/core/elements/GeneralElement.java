package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.MultiBrowser;

public class GeneralElement {
	public WebDriver browser;
	public String elementLocator;
	public String elementIdentifier;
	private WebElement generalElement;
	
	public GeneralElement(WebDriver browser, String elementLocator, String elementIdentifier) {
		this.browser = browser;
		this.elementLocator = elementLocator;
		this.elementIdentifier = elementIdentifier;
	}
	
	public GeneralElement(WebDriver browser, WebElement generalElement) {
		this.browser = browser;
		setGeneralObject(generalElement);
	}
	
	public void click(){
		generalElement.click();
		MultiBrowser.waitWhileLoading(browser);
	}
	
	private void setGeneralObject(WebElement generalElement){
		this.generalElement = generalElement;
	}
	
	protected WebElement getGeneralObject() {
		return generalElement;
	}
	
	protected void setObject(){
		if (elementIdentifier != null)
			setGeneralElement();
	}
	
	private void setGeneralElement(){
		switch (elementLocator) {
			case "xpath":
				generalElement = browser.findElement(By.xpath(elementIdentifier));
				break;
			case "id":
				generalElement = browser.findElement(By.id(elementIdentifier));
				break;
			case "name":
				generalElement = browser.findElement(By.name(elementIdentifier));
				break;
			case "class":
				generalElement = browser.findElement(By.className(elementIdentifier));
				break;
			case "css":
				generalElement = browser.findElement(By.cssSelector(elementIdentifier));
				break;
			case "tag":
				generalElement = browser.findElement(By.tagName(elementIdentifier));
				break;
			case "partialLink":
				generalElement = browser.findElement(By.partialLinkText(elementIdentifier));
				break;
			default:
				//TBD
				break;
		}
	}
}
