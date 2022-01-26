package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class SignOutPage extends Base{
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Sign Out')]")
	WebElement signOut;
	
	public SignOutPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickSignOut() {
		signOut.click();
		
	}
}
