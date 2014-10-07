package jUnit.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.tests.GoogleLogin;

public class TestGoogleLogin {
	public static void main(String[] args){
		WebDriver firefox = new FirefoxDriver();
		firefox.get("http://mail.google.com");
		GoogleLogin googleLogin = new GoogleLogin (firefox);
		
		googleLogin.username.setText("andrei.burdun");
		googleLogin.password.setText("1 me pass");
		googleLogin.keepMeLogged.verifyCheckboxIsChecked();
		googleLogin.signIn.verifyTextIs("Sign in");
		googleLogin.signIn.click();
		
		firefox.close();
	}

}
