package Test;

import static base.Base.driver;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.ProductPage;
import Pages.SignInPage;
import Pages.SignOutPage;

public class productTest extends BaseTest{
	
	@Test(priority=3, description="Verify user is able to purchase product & receive order ID successfully")
	public void verifyPurchaseAndOrderID() throws IOException, InterruptedException, ParseException{
		LandingPage land=new LandingPage(driver);
		HomePage home=new HomePage(driver);
		SignInPage sign=new SignInPage(driver);
		ProductPage pro=new ProductPage(driver);
		SignOutPage out=new SignOutPage(driver); 
		
		land.verifyLandingPage();
		land.ClickEnterTheStore();
		home.verifyHomePage();
		sign.verifyLoginAndClickSignOut("NotDDT");
		pro.purchaseLargeAngleFish();
		pro.verifyOrderID();
		out.clickSignOut();
	}
}
