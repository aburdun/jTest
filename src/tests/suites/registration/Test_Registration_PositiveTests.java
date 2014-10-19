package tests.suites.registration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.registration.YahooRegistration;
import tests.utils.BaseTest;
import core.utils.MessageCollector;

public class Test_Registration_PositiveTests extends BaseTest {
	
	@Test
	public void createAccount_InvalidUsername() throws Exception  {
		
		WebDriver firefox = getDriver();
		firefox.get("https://au.edit.yahoo.com/registration");
		YahooRegistration regPage = new YahooRegistration (firefox, collector);
		
		regPage.registerAccountUsing("Ionela", "Popescu", "ipopescu", "thisIs4Test", "Romania", "754128654", "September", "13", "1987", "f");
		regPage.verifyRegistrationFailed();

		MessageCollector.collectMessages(collector);
		
	}
	
	@Test
	public void createAccount_InvalidPassword() throws Exception  {
		
		WebDriver firefox = getDriver();
		firefox.get("https://au.edit.yahoo.com/registration");
		YahooRegistration regPage = new YahooRegistration (firefox, collector);
		
		regPage.registerAccountUsing("Ionela", "Popescu", "ipopescu85s99", "popescu", "Romania", "754128654", "September", "13", "1987", "f");
		regPage.verifyRegistrationFailed();

		MessageCollector.collectMessages(collector);
		
	}
}
