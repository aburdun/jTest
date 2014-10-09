package core.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static core.utils.AssertUtils.*;

public class DropDown extends GeneralElement{
	
	private static final String XPATH_FOR_DROPDOWN_OPTION = ".//option";
	
	WebElement dropdown;
	
	public DropDown(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
		dropdown = getGeneralObject();
	}
	
	public void verifyNumberOfOptionsIs(int expectedNumberOfOptions){
		isEqual("", expectedNumberOfOptions, getAllOptionElements().size());
	}
	
	public void verifyAllOptionsAreInOrder(String expectedOptions){
		String[] expectedOptionsList = expectedOptions.split(";");
		List<String> actualOptionsList = getAllOptionValues();
		isEqual("", expectedOptionsList.length, actualOptionsList.size());
		isTrue("", actualOptionsList.equals(Arrays.asList(expectedOptionsList)));
		
		for (String expectedOption : expectedOptionsList)
			isTrue("", actualOptionsList.contains(expectedOption));;
	}
	
	public void verifyOptionExist(String optionValue){
		isTrue("", getAllOptionValues().contains(optionValue));
	}
	
	public void verifyOptionNotExist(String optionValue){
		isFalse("", getAllOptionValues().contains(optionValue));
	}
	
	public void selectOption(String optionValue){
		verifyOptionExist(optionValue);
		new Select(dropdown).selectByVisibleText(optionValue);
	}
	
	public void verifySelectedOptionIs(String optionValue){
		WebElement selectedElement = new Select(dropdown).getFirstSelectedOption();
		isTrue("", optionValue.equals(selectedElement.getText()));
	}
	
	
	//PRIVATE METHODS
	
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
