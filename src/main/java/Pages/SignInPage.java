package Pages;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class SignInPage extends Base{
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='Catalog']//child::p[1]")
	WebElement signInText;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='signon']")
	WebElement login;
	
	@FindBy(xpath="//div[@id='WelcomeContent']")
	WebElement welcome;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void verifySignInText() throws IOException {
		HomePage home=new HomePage(driver);
		home.clickSignIn();
		String expected=prop.getProperty("signInText");
		String actual=signInText.getText();
		Assert.assertEquals(actual, expected);
	}
	public void verifyLoginAndClickSignOut(String value) throws IOException, ParseException{
		JSONArray dataArray = JSONReader(prop.getProperty("loginFilePath"));
		HomePage home=new HomePage(driver);
		SignOutPage out=new SignOutPage(driver);   
	    for (int i = 0; i < dataArray.length(); i++) {
			JSONObject object = dataArray.getJSONObject(i);
			home.clickSignIn();	
			sendUsername(object.getString("username"));
			sendPassword(object.getString("password"));
		    login.click(); 
		    verifyLoginPage();
			//Data driven testing if value is "DDT"
			if(value=="NotDDT")
				break;
			else
				out.clickSignOut();
		}
	}
	public void sendUsername(String name) {
		username.clear();
	    username.sendKeys(name);
	}
	public void sendPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	public void verifyLoginPage() {
		String expected=welcome.getText();
		String actual=prop.getProperty("loginMsg");
		Assert.assertTrue(expected.contains(actual));
	}
}