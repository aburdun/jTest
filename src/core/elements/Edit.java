package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Edit extends GeneralElement{
	
	WebElement edit;
	
	public Edit(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
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
