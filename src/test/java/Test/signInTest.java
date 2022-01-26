package Test;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.SignInPage;

import static base.Base.driver;

public class signInTest extends BaseTest{
		
	@Test(priority=2, description="Verifying the successful login and objects in SignIn page")
	public void verifyLogin() throws IOException, InterruptedException, ParseException{
		LandingPage land=new LandingPage(driver);
		HomePage home=new HomePage(driver);
		SignInPage sign=new SignInPage(driver);
		
		land.verifyLandingPage();
		land.ClickEnterTheStore();
		home.verifyHomePage();
		sign.verifyLoginAndClickSignOut("DDT");
	}
}