package core.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.general.GeneralObject;

public class CheckBox extends GeneralObject{
	
	WebElement checkbox;
	
	public CheckBox(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
		checkbox = super.getGeneralObject();
	}
	
	public CheckBox(WebDriver browser, WebElement generalObject) {
		super(browser, generalObject);
		checkbox = super.getGeneralObject();
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
	
	public void check(){
		Assert.assertFalse(checkbox.isSelected());
		checkbox.click();
	}
	
	public void unCheck(){
		Assert.assertTrue(checkbox.isSelected());
		checkbox.click();
	}
}
