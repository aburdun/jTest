package jUnit.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.tests.TestPage;

public class GeneralTest {
	public static void main(String[] args){
		WebDriver firefox = new FirefoxDriver();
		firefox.get("file:///E:/TestingFramework/jTest/src/jUnit/html/testPage.html");
		
		TestPage testPage = new TestPage (firefox);
		
		testPage.android.verifyCheckboxIsNotChecked();
		testPage.android.verifyCheckboxIsEnabled();;
		testPage.iOS.verifyCheckboxIsChecked();
		testPage.windows.verifyCheckboxIsNotChecked();
		testPage.windows.verifyCheckboxIsDisabled();
		
		testPage.gender.verifyNumberOfOptionsIs(3);
		testPage.gender.verifyAllOptionsAre("(please select);male;female");
		testPage.gender.verifyOptionExist("male");
		testPage.gender.selectOption("male");
		
		testPage.gender.verifySelectedOptionIs("male");
		
		testPage.submitButton.click();
		
		firefox.close();
	}

}
