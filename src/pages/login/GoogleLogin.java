package pages.login;

import org.openqa.selenium.WebDriver;

import core.elements.Button;
import core.elements.CheckBox;
import core.elements.Edit;
import core.utils.MessageCollector;

public class GoogleLogin {
	
	private WebDriver browser;
	
	public Edit username, password;
	public CheckBox keepMeLogged;
	public Button signIn;
	public MessageCollector collector;
	
	public GoogleLogin(WebDriver browser, MessageCollector collector){
		this.browser = browser;
		this.collector = collector;
		setOjects();
	}
	
	private void setOjects(){
		username = new Edit (browser, "id", "Email", collector);
		password = new Edit (browser, "name", "Passwd", collector);
		keepMeLogged = new CheckBox (browser, "id", "PersistentCookie", collector);
		signIn = new Button (browser, "name", "signIn", collector);
	}
	
	public void loginAs(String user, String pwd){
		username.setText(user);
		password.setText(pwd);
		keepMeLogged.unCheck();
		signIn.click();
	}
}
