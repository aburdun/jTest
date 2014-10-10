package pages.tests;

import org.openqa.selenium.WebDriver;

import core.components.Table;
import core.elements.Button;
import core.elements.CheckBox;
import core.elements.DropDown;
import core.utils.SearchType;

public class TestPage { //temp
	
	private WebDriver browser;
	
	public Button submitButton, cancelButton;
	public CheckBox android, iOS, windows;
	public DropDown gender;
	public Table tableView;
	
	public TestPage(WebDriver browser){
		this.browser = browser;
		setOjects();
	}
	
	private void setOjects(){
		submitButton = new Button(browser, SearchType.ID, "submit");
		cancelButton = new Button(browser, SearchType.ID, "cancel");
		android	= new CheckBox(browser, SearchType.ID, "android");
		iOS	= new CheckBox(browser, SearchType.ID, "iOS");
		windows	= new CheckBox(browser, SearchType.ID, "windows");
		gender = new DropDown(browser, SearchType.NAME, "gender");
		tableView = new Table(browser);
	}
}
