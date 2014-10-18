package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.MessageCollector;

public class Edit extends GeneralElement{
	
	WebElement edit;
	
	public Edit(WebDriver browser, String elementLocator, String elementIdentifier, MessageCollector collector) {
		super(browser, elementLocator, elementIdentifier, collector);
	}
	
	public void setText(String text){
		setElement();
		edit.sendKeys(text);
	}
	
	private void setElement(){
		super.setObject();
		edit = getGeneralObject();
	}
}
