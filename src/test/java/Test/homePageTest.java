package Test;

import java.io.IOException;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LandingPage;

import static base.Base.driver;

public class homePageTest extends BaseTest{
	
	@Test(priority=1, description="Verifying the successful entry to HomePage and objects in it")
	public void verifyHomePage() throws IOException {
		LandingPage land=new LandingPage(driver);
		HomePage home=new HomePage(driver);
		land.verifyLandingPage();
		land.ClickEnterTheStore();
		home.clickAndVerifyLogo();
		home.verifySearchBoxAndButton();
		home.returnToHomePage();
	}
}
