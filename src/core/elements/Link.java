package core.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.MessageCollector;

public class Link extends GeneralElement{
	
	WebElement link;
	
	public Link(WebDriver browser, String elementLocator, String elementIdentifier, MessageCollector collector) {
		super(browser, elementLocator, elementIdentifier, collector);
	}
	
	public Link(WebDriver browser, WebElement generalObject, MessageCollector collector) {
		super(browser, generalObject, collector);
	}
}
