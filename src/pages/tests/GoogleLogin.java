package pages.tests;

import org.openqa.selenium.WebDriver;

import core.elements.Button;
import core.elements.CheckBox;
import core.elements.Edit;

public class GoogleLogin {
	
	private WebDriver browser;
	
	public Edit username, password;
	public CheckBox keepMeLogged;
	public Button signIn;
	
	public GoogleLogin(WebDriver browser){
		this.browser = browser;
		setOjects();
	}
	
	private void setOjects(){
		username = new Edit (browser, "id", "Email");
		password = new Edit (browser, "name", "Passwd");
		keepMeLogged = new CheckBox (browser, "id", "PersistentCookie");
		signIn = new Button (browser, "name", "signIn");
	}
	
	public void loginAs(String user, String pwd){
		username.setText(user);
		password.setText(pwd);
		keepMeLogged.unCheck();
		signIn.click();
	}
}
