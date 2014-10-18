package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.MessageCollector;
import core.utils.TestAction;
import static core.utils.AssertUtils.*;

public class CheckBox extends GeneralElement{
	
	WebElement checkbox;
	
	public CheckBox(WebDriver browser, String elementLocator, String elementIdentifier, MessageCollector collector) {
		super(browser, elementLocator, elementIdentifier, collector);
	}
	
	public CheckBox(WebDriver browser, WebElement generalObject, MessageCollector collector) {
		super(browser, generalObject, collector);
	}
	
	public void verifyCheckboxIsChecked(){
		setElement();
		isTrue("", checkbox.isSelected(), TestAction.CONTINUE, browser, collector);
	}
	
	public void verifyCheckboxIsNotChecked(){
		setElement();
		isFalse("", checkbox.isSelected(), TestAction.CONTINUE, browser, collector);
	}
	
	public void verifyCheckboxIsEnabled(){
		setElement();
		isTrue("", checkbox.isEnabled(), TestAction.CONTINUE, browser, collector);
	}
	
	public void verifyCheckboxIsDisabled(){
		setElement();
		isFalse(" ", checkbox.isEnabled(), TestAction.CONTINUE, browser, collector);
	}
	
	public void check(){
		setElement();
		isFalse("", checkbox.isSelected(), TestAction.CONTINUE, browser, collector);
		checkbox.click();
	}
	
	public void unCheck(){
		setElement();
		isTrue("", checkbox.isSelected(), TestAction.CONTINUE, browser, collector);
		checkbox.click();
	}
	
	private void setElement(){
		super.setObject();
		checkbox = super.getGeneralObject();
	}
}
