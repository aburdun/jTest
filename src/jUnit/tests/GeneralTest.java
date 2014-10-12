package jUnit.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.tests.TestPage;

public class GeneralTest extends BaseTest{
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
//		testPage.gender.verifyNumberOfOptionsIs(5);
//		testPage.gender.verifyNumberOfOptionsIs(4);
		testPage.gender.verifyAllOptionsAreInOrder("(please select);male;female");
		testPage.gender.verifyOptionExists("male");
		testPage.gender.verifyOptionDoesNotExist("not");
		testPage.gender.selectOption("male");
		
		testPage.gender.verifySelectedOptionIs("male");
		
		testPage.tableView.verifyNumberOfRowsIs(2);
		testPage.tableView.verifyAllTableColumnsAre("ID;First Name;Completed;Salary");
		testPage.tableView.checkCheckboxFromRowWithValueUnderColumn("14000", "Salary");
		testPage.tableView.unCheckCheckboxFromRowWithValueUnderColumn("14000", "Salary");
		
		testPage.genderRadio.verifyExists();
		testPage.genderRadio.verifyNumberOfOptionsIs(2);
		testPage.genderRadio.selectOption("female");
		testPage.genderRadio.verifyOptionIsSelected("female");
		testPage.genderRadio.verifyOptionIsNotSelected("male");
		
//		testPage.submitButton.verifyTextIs("Login");
		testPage.submitButton.verifyTextIs("Submit");
		testPage.submitButton.click();
		testPage.submitButton.verifyExists();
		testPage.cancelButton.verifyNotExists();
		
		firefox.close();
		
		tearDown(); //temp
	}
}
