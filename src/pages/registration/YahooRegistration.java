package pages.registration;

import org.openqa.selenium.WebDriver;

import core.components.RadioGroup;
import core.elements.Button;
import core.elements.CustomDropDownY;
import core.elements.DropDown;
import core.elements.Edit;
import core.utils.MessageCollector;
import core.utils.SearchType;

public class YahooRegistration {
	
	private WebDriver browser;
	public MessageCollector collector;
	
	public Edit firstName, lastName, username, password, mobileNumber, recoveryNumber, relationship;
	public DropDown language, month, day, year;
	public RadioGroup gender;
	public Button submit;
	public CustomDropDownY codeForPhone1, codeForPhone2;
	
	
	public YahooRegistration(WebDriver browser, MessageCollector collector){
		this.browser = browser;
		this.collector = collector;
		setOjects();
	}
	
	private void setOjects(){
		language = new DropDown(browser, "id", "country-lang", collector);
		month = new DropDown(browser, "id", "month", collector);
		day = new DropDown(browser, "id", "day", collector);
		year = new DropDown(browser, "id", "year", collector);
		firstName = new Edit (browser, "name", "firstname", collector);
		lastName = new Edit (browser, "name", "secondname", collector);
		username = new Edit (browser, "name", "yahooid", collector);
		password = new Edit (browser, "name", "password", collector);
		mobileNumber = new Edit (browser, "id", "mobile", collector);
		recoveryNumber = new Edit (browser, "id", "mobile-rec", collector);
		relationship = new Edit (browser, "id", "relationship", collector);
		gender = new RadioGroup(browser, "xpath", "//div[@role='radiogroup']", collector);
		submit = new Button(browser, SearchType.XPATH, "//input[@value='Create Account']", collector);
		codeForPhone1 = new CustomDropDownY(browser, SearchType.ID, "selected-country-code-1", collector);
		codeForPhone2 = new CustomDropDownY(browser, SearchType.ID, "selected-country-code-2", collector);
	}
	
	public void registerAccountUsing (	String fName, 
										String lName, 
										String uName, 
										String pass, 
										String countryCode,
										String mobile,
										String m,
										String d,
										String y,
										String gen){
		firstName.setText(fName);
		lastName.setText(lName);
		username.setText(uName);
		password.setText(pass);
		codeForPhone1.clickArrowAndSelectOption(countryCode);
		mobileNumber.setText(mobile);	
		month.selectOption(m);
		day.selectOption(d);
		year.selectOption(y);	
		gender.selectOption(gen);
		submit.click();
	}
	
	public void verifyRegistrationFailed (){
		submit.verifyExists();
	}
}
