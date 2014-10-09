package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static core.utils.AssertUtils.*;

public class CheckBox extends GeneralElement{
	
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
		isTrue("", checkbox.isSelected());
	}
	
	public void verifyCheckboxIsNotChecked(){
		isFalse("", checkbox.isSelected());
	}
	
	public void verifyCheckboxIsEnabled(){
		isTrue("", checkbox.isEnabled());
	}
	
	public void verifyCheckboxIsDisabled(){
		isFalse(" ", checkbox.isEnabled());
	}
	
	public void check(){
		isFalse("", checkbox.isSelected());
		checkbox.click();
	}
	
	public void unCheck(){
		isTrue("", checkbox.isSelected());
		checkbox.click();
	}
}
