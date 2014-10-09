package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static core.utils.AssertUtils.*;

public class Button extends GeneralElement{
	
	WebElement button;
	
	public Button(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
		button = getGeneralObject();
	}
	
	public void verifyTextIs(String buttonText){
		String assertMessage = "\nVerify text from button is '" + buttonText + "'.\n";
		String actualButtonText = button.getAttribute("value");
		isTrue(assertMessage + "Failed. Text from button is '" + actualButtonText + "'.\n", buttonText.equals(actualButtonText));
	}
}
