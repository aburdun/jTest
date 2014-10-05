package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
public final String XPATH_FOR_BUTTON = "//button[contains(@id, '<<buttonID>>')]";
	
	public WebDriver browser;
	public String buttonLocator;
	WebElement button;
	
	public Button(WebDriver browser, String buttonLocator) {
		this.browser = browser;
		this.buttonLocator = buttonLocator;
		setObject();
	}
	
	public void setObject(){
		this.button = browser.findElement(By.xpath(XPATH_FOR_BUTTON.replace("<<buttonID>>", buttonLocator)));
	}
	
	public void click(){
		button.click();
	}
	
	public String getText(){
		return button.getText();
	}
}
