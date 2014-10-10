package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.TestAction;
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
		isTrue("", checkbox.isSelected(), TestAction.CONTINUE);
	}
	
	public void verifyCheckboxIsNotChecked(){
		setElement();
		isFalse("", checkbox.isSelected(), TestAction.CONTINUE);
	}
	
	public void verifyCheckboxIsEnabled(){
		setElement();
		isTrue("", checkbox.isEnabled(), TestAction.CONTINUE);
	}
	
	public void verifyCheckboxIsDisabled(){
		setElement();
		isFalse(" ", checkbox.isEnabled(), TestAction.CONTINUE);
	}
	
	public void check(){
		setElement();
		isFalse("", checkbox.isSelected(), TestAction.CONTINUE);
		checkbox.click();
	}
	
	public void unCheck(){
		setElement();
		isTrue("", checkbox.isSelected(), TestAction.CONTINUE);
		checkbox.click();
	}
	
	private void setElement(){
		super.setObject();
		checkbox = super.getGeneralObject();
	}
}
