package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.utils.AssertUtils.*;

public class Button extends GeneralElement{
	
	WebElement button;
	
	public Button(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
	}
	
	public Button(WebDriver browser, WebElement generalObject) {
		super(browser, generalObject);
	}
	
	public void verifyTextIs(String buttonText){
		setElement();
		String assertMessage = "\nVerify text from button is '" + buttonText + "'.\n";
		String actualButtonText = button.getAttribute("value");
		isTrue(assertMessage + "Failed. Text from button is '" + actualButtonText + "'.\n", buttonText.equals(actualButtonText));
	}
	
	private void setElement(){
		super.setObject();
		button = getGeneralObject();
	}
}
