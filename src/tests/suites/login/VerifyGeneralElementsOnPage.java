package tests.suites.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.login.TestPage;
import tests.utils.BaseTest;
import core.utils.MessageCollector;
 
public class VerifyGeneralElementsOnPage extends BaseTest{
	
	@Test
	public void test_CheckboxSelectUnselect() {
		WebDriver firefox = getDriver();
		TestPage testPage = new TestPage (firefox, collector);
		firefox.get("file:///E:/TestingFramework/jTest/src/html/testPage.html");
		
		testPage.android.verifyCheckboxIsNotChecked();
		testPage.android.verifyCheckboxIsEnabled();;
		testPage.iOS.verifyCheckboxIsChecked();
		testPage.windows.verifyCheckboxIsNotChecked();
		testPage.windows.verifyCheckboxIsDisabled();
		
		MessageCollector.collectMessages(collector);
	}
	
	@Test
	public void test_DropDownFunctionality() {
		WebDriver firefox = getDriver();
		TestPage testPage = new TestPage (firefox, collector);
		firefox.get("file:///E:/TestingFramework/jTest/src/html/testPage.html");
		
		testPage.gender.verifyNumberOfOptionsIs(3);
		testPage.gender.verifyAllOptionsAreInOrder("(please select);male;female");
		testPage.gender.verifyOptionExists("male");
		testPage.gender.verifyOptionDoesNotExist("not");
		testPage.gender.selectOption("male");
		testPage.gender.verifySelectedOptionIs("male");
		
		MessageCollector.collectMessages(collector);
	}
	
	@Test
	public void test_TableViewFunctionality() {
		WebDriver firefox = getDriver();
		TestPage testPage = new TestPage (firefox, collector);	
		firefox.get("file:///E:/TestingFramework/jTest/src/html/testPage.html");
		
		testPage.tableView.verifyNumberOfRowsIs(2);
		testPage.tableView.verifyAllTableColumnsAre("ID;First Name;Completed;Salary");
		testPage.tableView.checkCheckboxFromRowWithValueUnderColumn("14000", "Salary");
		testPage.tableView.unCheckCheckboxFromRowWithValueUnderColumn("14000", "Salary");
		
		MessageCollector.collectMessages(collector);
	}
	
	@Test
	public void test_RadioButtonsFunctionality() {
		WebDriver firefox = getDriver();
		TestPage testPage = new TestPage (firefox, collector);	
		firefox.get("file:///E:/TestingFramework/jTest/src/html/testPage.html");
			
		testPage.genderRadio.verifyExists();
		testPage.genderRadio.verifyNumberOfOptionsIs(2);
		testPage.genderRadio.selectOption("female");
		testPage.genderRadio.verifyOptionIsSelected("female");
		testPage.genderRadio.verifyOptionIsNotSelected("male");
		
		MessageCollector.collectMessages(collector);
	}
	
	@Test
	public void test_SubmitFunctionality() {
		WebDriver firefox = getDriver();
		TestPage testPage = new TestPage (firefox, collector);	
		firefox.get("file:///E:/TestingFramework/jTest/src/html/testPage.html");
		
		testPage.submitButton.verifyTextIs("Submit");
		testPage.submitButton.click();
		testPage.submitButton.verifyExists();
		testPage.cancelButton.verifyNotExists();
		
		MessageCollector.collectMessages(collector);
	}
}