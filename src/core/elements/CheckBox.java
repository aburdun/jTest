package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static core.utils.AssertUtils.*;

public class CheckBox extends GeneralElement{
	
	WebElement checkbox;
	
	public CheckBox(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
	}
	
	public CheckBox(WebDriver browser, WebElement generalObject) {
		super(browser, generalObject);
	}
	
	public void verifyCheckboxIsChecked(){
		setElement();
		isTrue("", checkbox.isSelected());
	}
	
	public void verifyCheckboxIsNotChecked(){
		setElement();
		isFalse("", checkbox.isSelected());
	}
	
	public void verifyCheckboxIsEnabled(){
		setElement();
		isTrue("", checkbox.isEnabled());
	}
	
	public void verifyCheckboxIsDisabled(){
		setElement();
		isFalse(" ", checkbox.isEnabled());
	}
	
	public void check(){
		setElement();
		isFalse("", checkbox.isSelected());
		checkbox.click();
	}
	
	public void unCheck(){
		setElement();
		isTrue("", checkbox.isSelected());
		checkbox.click();
	}
	
	private void setElement(){
		super.setObject();
		checkbox = super.getGeneralObject();
	}
}
