package core.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.general.GeneralObject;

public class CheckBox extends GeneralObject{
	
	WebElement checkbox;
	
	public CheckBox(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
		checkbox = getGeneralObject();
	}
	
	public void verifyCheckboxIsChecked(){
		Assert.assertTrue(checkbox.isSelected());
	}
	
	public void verifyCheckboxIsNotChecked(){
		Assert.assertFalse(checkbox.isSelected());
	}
	
	public void verifyCheckboxIsEnabled(){
		Assert.assertTrue(checkbox.isEnabled());
	}
	
	public void verifyCheckboxIsDisabled(){
		Assert.assertFalse(checkbox.isEnabled());
	}
}
