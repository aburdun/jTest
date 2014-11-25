package tests.suites.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.login.GoogleLogin;
import tests.utils.BaseTest;
import core.utils.MessageCollector;

public class VerifyLoginIsSuccessfulWithValidCredentials extends BaseTest{
	
	@Test
	public void test_LoginWithValidUsernameAndPassword() throws Exception  {
		WebDriver firefox = getDriver();
		firefox.get("http://mail.google.com");
		GoogleLogin googleLogin = new GoogleLogin (firefox, collector);
		
//		googleLogin.loginAs("usr", "pass");
		
		googleLogin.username.setText("valid_user");
		googleLogin.password.setText("valid_password");
		googleLogin.keepMeLogged.verifyCheckboxIsChecked();
		googleLogin.keepMeLogged.unCheck();
		googleLogin.signIn.verifyTextIs("Sign in");
		googleLogin.signIn.click();
		
		MessageCollector.collectMessages(collector);
	}

}
