package core.elements;

import static core.utils.AssertUtils.isNotNull;
import static core.utils.AssertUtils.isNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.MultiBrowser;
import core.utils.TestAction;

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
		setObject();
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
		generalElement = MultiBrowser.getElement(browser, elementLocator, elementIdentifier);
		isNotNull	(
					"\n"
					+ "Failed. The element could not be found page!\n"
					+ "Searched for: [" + elementLocator + ":" + elementIdentifier + "]\n"
					, generalElement
					, TestAction.STOP
					);
	}
	
	public void verifyExists(){
		String assertMessage = "Verify element exists.\n";
		isNotNull(assertMessage + "Failed. Element does not exists on page.\n", getGeneralObject(), TestAction.CONTINUE);
	}
	
	public void verifyNotExists(){
		String assertMessage = "Verify element does not exist.\n";
		isNull(assertMessage + "Failed. Element exists on page.\n", getGeneralObject(), TestAction.CONTINUE);
	}

}
