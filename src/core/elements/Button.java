package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import core.general.GeneralObject;

public class Button extends GeneralObject{
	
	WebElement button;
	
	public Button(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
		button = getGeneralObject();
	}
	
	public void verifyTextIs(String buttonText){
		String actualButtonText = button.getAttribute("value");
		Assert.assertTrue(buttonText.equals(actualButtonText));
	}
}
