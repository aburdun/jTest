package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Edit extends GeneralElement{
	
	WebElement edit;
	
	public Edit(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
		edit = getGeneralObject();
	}
	
	public void setText(String text){
		edit.sendKeys(text);
	}
}
