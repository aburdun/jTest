package core.components;

import static core.utils.AssertUtils.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.elements.GeneralElement;
import core.utils.TestAction;

public class RadioGroup extends GeneralElement {
	
	private static final String XPATH_FOR_OPTION = ".//input[@type='radio']";

	private WebElement radiogroup;

	public RadioGroup(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
	}
	
	public void verifyNumberOfOptionsIs(int expectedNumberOfOptions){
		setElement();
		int actualNumberOfOptions = getAllOptions().size();
		isEqual("", actualNumberOfOptions, expectedNumberOfOptions, TestAction.CONTINUE);
	}
	
	public void selectOption(String optionName){
		super.setObject();
		WebElement optionElement = getOptionByName(optionName);
		isNotNull("Object is null.", optionElement, TestAction.CONTINUE);
		optionElement.click();;
	}
	
	public void verifyOptionIsSelected(String optionName){
		super.setObject();
		WebElement optionElement = getOptionByName(optionName);
		isTrue("", optionElement.isSelected(), TestAction.CONTINUE);
	}
	
	public void verifyOptionIsNotSelected(String optionName){
		super.setObject();
		WebElement optionElement = getOptionByName(optionName);
		isFalse("", optionElement.isSelected(), TestAction.CONTINUE);
	}
	
	private List<WebElement> getAllOptions(){
		List<WebElement> listOfOptions = radiogroup.findElements(By.xpath(XPATH_FOR_OPTION));
		return listOfOptions;
	}
	
	private WebElement getOptionByName(String optionName){
		List<WebElement> listOfOptions = getAllOptions();
		for (WebElement option : listOfOptions){
			if (option.getAttribute("value").equals(optionName))
				return option;
		}
		return null;
	}
	
	private void setElement(){
		super.setObject();
		radiogroup = getGeneralObject();
	}
}