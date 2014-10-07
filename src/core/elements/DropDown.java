package core.elements;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.general.GeneralObject;

public class DropDown extends GeneralObject{
	private static final String XPATCH_FOR_DROPDOWN_OPTION = ".//option";
	
	WebElement dropdown;
	
	public DropDown(WebDriver browser, String elementLocator, String elementIdentifier) {
		super(browser, elementLocator, elementIdentifier);
		dropdown = getGeneralObject();
	}
	
	public void verifyNumberOfOptionsIs(int expectedNumberOfOptions){
		Assert.assertEquals(expectedNumberOfOptions, getAllOptionElements().size());
	}
	
	public void verifyAllOptionsAre(String expectedOptions){
		String[] expectedOptionsList = expectedOptions.split(";");
		List<String> actualOptionsList = getAllOptionValues();
		Assert.assertEquals(expectedOptionsList.length, actualOptionsList.size());
		
		for (String expectedOption : expectedOptionsList) {
			Assert.assertTrue(actualOptionsList.contains(expectedOption));;
		}
	}
	
	public void verifyOptionExist(String optionValue){
		Assert.assertTrue(getAllOptionValues().contains(optionValue));
	}
	
	public void verifyOptionNotExist(String optionValue){
		Assert.assertFalse(getAllOptionValues().contains(optionValue));
	}
	
	public void selectOption(String optionValue){
		verifyOptionExist(optionValue);
		new Select(dropdown).selectByVisibleText(optionValue);
	}
	
	public void verifySelectedOptionIs(String optionValue){
		WebElement selectedElement = new Select(dropdown).getFirstSelectedOption();
		Assert.assertTrue(optionValue.equals(selectedElement.getText()));
	}
	
	
	//PRIVATE METHODS
	
	private List<WebElement> getAllOptionElements (){
		List<WebElement> allOptionsElements = dropdown.findElements(By.xpath(XPATCH_FOR_DROPDOWN_OPTION));
		
		return allOptionsElements;
	}
	
	private List<String> getAllOptionValues(){
		List<String> allOptionsValues = new ArrayList<String>();
		for (WebElement option : getAllOptionElements())
			allOptionsValues.add(option.getText());
		
		return allOptionsValues;
	}
}
