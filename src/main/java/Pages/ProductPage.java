package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class ProductPage extends Base{
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='SidebarContent']//child::a[1]")
	WebElement Fish;
	
	@FindBy(xpath="//*[contains(text(),'FI-SW-01')]")
	WebElement angelFish;
	
	@FindBy(xpath="//*[contains(text(),'EST-1')]")
	WebElement largeAngelFish;
	
	@FindBy(className="Button")
	WebElement addToCart;
	
	@FindBy(xpath="//*[contains(text(),'Proceed to Checkout')]")
	WebElement checkOut;
	
	@FindBy(name="newOrder")
	WebElement Continue;
	
	@FindBy(xpath="//*[contains(text(),'Confirm')]")
	WebElement confirm;
	
	@FindBy(xpath="//div[@id='Catalog']//following::tr[1]")
	WebElement orderID;
	
	public ProductPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	public void purchaseLargeAngleFish() {
		Fish.click();
		angelFish.click();
		largeAngelFish.click();
		addToCart.click();
		checkOut.click();
		Continue.click();
		confirm.click();
		verifyOrderID();
	}
	public void verifyOrderID() {
		String order=orderID.getText();
		log.info(order);
		Assert.assertTrue(orderID.isDisplayed());
	}
}
