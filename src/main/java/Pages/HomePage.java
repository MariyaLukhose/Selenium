package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class HomePage extends Base{
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='LogoContent']//child::a")
	WebElement logo;
	
	@FindBy(xpath="//input[@name='keyword']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@name='searchProducts']")
	WebElement searchButton;
	
	@FindBy(xpath="//*[contains(text(),'Goldfish')]")
	WebElement goldFish;
	
	@FindBy(xpath="//*[contains(text(),'Sign In')]")
	WebElement signIn;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	//Verifying when clicking Logo returns to the Home Page
	public void clickAndVerifyLogo() {
		String expected=driver.getWindowHandle();
		returnToHomePage();
		String actual=driver.getWindowHandle();
		Assert.assertEquals(actual,expected);
	}
	//Verify the Search button and search Box by sending a vale
	public void verifySearchBoxAndButton(){
		String expected=prop.getProperty("search");
		searchBox.sendKeys(expected);
		String actual=searchBox.getAttribute("value");
		Assert.assertEquals(actual,expected);
		searchButton.click();
		Assert.assertTrue(goldFish.isDisplayed());
	}
	//Clicking the logo image
	public void returnToHomePage() {
		logo.click();
	}
	//Clicking Sign In button
	public void clickSignIn() {
		signIn.click();
	}
	//All verifications for HomePage
	public void verifyHomePage() {
		clickAndVerifyLogo();
		verifySearchBoxAndButton();
		returnToHomePage();
	}
}