package pages.login;

import org.openqa.selenium.WebDriver;

import core.components.RadioGroup;
import core.components.Table;
import core.elements.Button;
import core.elements.CheckBox;
import core.elements.DropDown;
import core.utils.MessageCollector;
import core.utils.SearchType;

public class TestPage { //temp
	
	private WebDriver browser;
	
	public Button submitButton, cancelButton;
	public CheckBox android, iOS, windows;
	public DropDown gender;
	public Table tableView;
	public RadioGroup genderRadio;
	public MessageCollector collector;
	
	public TestPage(WebDriver browser, MessageCollector collector){
		this.browser = browser;
		this.collector = collector;
		setOjects();
	}
	
	private void setOjects(){
		submitButton = new Button(browser, SearchType.ID, "submit", collector);
		cancelButton = new Button(browser, SearchType.ID, "cancel", collector);
		android	= new CheckBox(browser, SearchType.ID, "android", collector);
		iOS	= new CheckBox(browser, SearchType.ID, "iOS", collector);
		windows	= new CheckBox(browser, SearchType.ID, "windows", collector);
		gender = new DropDown(browser, SearchType.NAME, "gender", collector);
		tableView = new Table(browser, SearchType.NAME, "employees", collector);
		genderRadio = new RadioGroup(browser, SearchType.ID, "genderRadio", collector);
	}
}
