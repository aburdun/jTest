package pages.tests;

import org.openqa.selenium.WebDriver;

import core.components.Table;

import core.elements.Button;
import core.elements.CheckBox;
import core.elements.DropDown;

public class TestPage {
	
	private WebDriver browser;
	
	public Button submitButton;
	public CheckBox android, iOS, windows;
	public DropDown gender;
	public Table tableView;
	
	public TestPage(WebDriver browser){
		this.browser = browser;
		setOjects();
	}
	
	private void setOjects(){
		submitButton = new Button(browser, "id", "submit");
		android	= new CheckBox(browser, "id", "android");
		iOS	= new CheckBox(browser, "id", "iOS");
		windows	= new CheckBox(browser, "id", "windows");
		gender = new DropDown(browser, "name", "gender");
		tableView = new Table(browser);
	}
}
