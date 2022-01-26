package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class LandingPage extends Base{
	WebDriver driver;
	
	@FindBy(linkText="Enter the Store")
	WebElement enterStore;
	
	@FindBy(xpath="//div[@id='Content']//following::sub")
	WebElement copyright;
	
	@FindBy(xpath="//div[@id='Content']//following::h2")
	WebElement header;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	//Verifying the title of the Landing Page
	public void verifyTitle() {  
		String actual=prop.getProperty("title");
		String expected=driver.getTitle();
		Assert.assertEquals(actual, expected, "Title is not as expected");		
	}
	//Verifying the link and copyright
	public void verifyCopyrightAndEnterStore() {
		String actual=prop.getProperty("copyright");
		String expected=copyright.getText();
		Assert.assertEquals(actual, expected, "Link is not as expected");
		Assert.assertTrue(enterStore.isDisplayed());
	}
	//Verifying the header
	public void verifyHeader() {
		String actual=prop.getProperty("LandingPageHeader");
		String expected=header.getText();
		Assert.assertEquals(actual, expected);
	}
	//Clicking the link
	public void ClickEnterTheStore(){
		enterStore.click();
	}
	public void verifyLandingPage() {
		verifyTitle();	
		verifyHeader();
		verifyCopyrightAndEnterStore();
	}
}