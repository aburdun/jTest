package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.MessageCollector;
import core.utils.TestAction;
import static core.utils.AssertUtils.*;

public class Button extends GeneralElement{
	
	WebElement button;
	
	public Button(WebDriver browser, String elementLocator, String elementIdentifier, MessageCollector collector) {
		super(browser, elementLocator, elementIdentifier, collector);
	}
	
	public Button(WebDriver browser, WebElement generalObject, MessageCollector collector) {
		super(browser, generalObject, collector);
	}
	
	public void verifyTextIs (String buttonText){
		setElement();
		String assertMessage = "Verify text from button is '" + buttonText + "'.\n";
		String actualButtonText = button.getAttribute("value");
		isTrue(assertMessage + "Failed. Text from button is '" + actualButtonText + "'.", buttonText.equals(actualButtonText), TestAction.CONTINUE, browser, collector);
	}
	
	private void setElement(){
		super.setObject();
		button = getGeneralObject();
	}
	
	
}
