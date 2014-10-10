package core.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.utils.TestAction;
import static core.utils.AssertUtils.*;

public class DropDown extends GeneralElement{
	
	private static final String XPATH_FOR_DROPDOWN_OPTION = ".//option";
	
	WebElement dropdown;
	
	public DropDown(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
	}
	
	public void verifyNumberOfOptionsIs(int expectedNumberOfOptions){
		String assertMessage = "Verify number of option is '" + expectedNumberOfOptions + "'.\n";
		setElement();
		isEqual(assertMessage + "Failed. Expected '" + expectedNumberOfOptions + "' options, but there are '" +  getAllOptionElements().size() + "'.", expectedNumberOfOptions, getAllOptionElements().size(), TestAction.CONTINUE);
	}
	
	public void verifyAllOptionsAreInOrder(String expectedOptions){
		setElement();
		String[] expectedOptionsList = expectedOptions.split(";");
		List<String> actualOptionsList = getAllOptionValues();
		isEqual("", expectedOptionsList.length, actualOptionsList.size(), TestAction.CONTINUE);
		isTrue("", actualOptionsList.equals(Arrays.asList(expectedOptionsList)), TestAction.CONTINUE);
		
		for (String expectedOption : expectedOptionsList)
			isTrue("", actualOptionsList.contains(expectedOption), TestAction.CONTINUE);;
	}
	
	public void verifyOptionExist(String optionValue){
		setElement();
		isTrue("", getAllOptionValues().contains(optionValue), TestAction.CONTINUE);
	}
	
	public void verifyOptionNotExist(String optionValue){
		setElement();
		isFalse("", getAllOptionValues().contains(optionValue), TestAction.CONTINUE);
	}
	
	public void selectOption(String optionValue){
		setElement();
		verifyOptionExist(optionValue);
		new Select(dropdown).selectByVisibleText(optionValue);
	}
	
	public void verifySelectedOptionIs(String optionValue){
		setElement();
		WebElement selectedElement = new Select(dropdown).getFirstSelectedOption();
		isTrue("", optionValue.equals(selectedElement.getText()), TestAction.CONTINUE);
	}
	
	
	//PRIVATE METHODS
	
	private void setElement(){
		super.setObject();
		dropdown = getGeneralObject();
	}
	
	private List<WebElement> getAllOptionElements (){
		List<WebElement> allOptionsElements = dropdown.findElements(By.xpath(XPATH_FOR_DROPDOWN_OPTION));
		
		return allOptionsElements;
	}
	
	private List<String> getAllOptionValues(){
		List<String> allOptionsValues = new ArrayList<String>();
		for (WebElement option : getAllOptionElements())
			allOptionsValues.add(option.getText());
		
		return allOptionsValues;
	}
}
