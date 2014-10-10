package jUnit.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.tests.GoogleLogin;

public class TestGoogleLogin extends BaseTest{
	public static void main(String[] args){
		WebDriver firefox = new FirefoxDriver();
		firefox.get("http://mail.google.com");
		GoogleLogin googleLogin = new GoogleLogin (firefox);
		
//		googleLogin.loginAs("usr", "pass");
		
		googleLogin.username.setText("usr");
		googleLogin.password.setText("pass");
		googleLogin.keepMeLogged.verifyCheckboxIsChecked();
		googleLogin.keepMeLogged.unCheck();
		googleLogin.signIn.verifyTextIs("Sign in");
		googleLogin.signIn.click();
	
		firefox.close();
		
		tearDown();
	}

}
