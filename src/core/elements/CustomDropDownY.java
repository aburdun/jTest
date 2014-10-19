package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.MessageCollector;

public class CustomDropDownY extends GeneralElement {
	
	private static final String XPATH_ARROW = ".//span[contains(@class, 'arrow')]";
	private static final String XPATH_OPTION = ".//a[contains(text(),'<value>')]";
	
	WebElement customDropDown;
	
	public CustomDropDownY(WebDriver browser, String elementLocator, String elementIdentifier, MessageCollector collector) {
		super(browser, elementLocator, elementIdentifier, collector);
	}
	
	public CustomDropDownY(WebDriver browser, WebElement generalObject, MessageCollector collector) {
		super(browser, generalObject, collector);
	}
	
	public void clickArrowAndSelectOption(String optionName) {
		setElement();
		WebElement arrow = customDropDown.findElement(By.xpath(XPATH_ARROW));
		arrow.click();
		arrow.click();
		WebElement  optionToSelect = customDropDown.findElement(By.xpath(XPATH_OPTION.replace("<value>", optionName)));
		optionToSelect.click();		
	}
	
	private void setElement(){
		super.setObject();
		customDropDown = super.getGeneralObject();
	}
}
