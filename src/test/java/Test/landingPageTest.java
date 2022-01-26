package Test;

import org.testng.annotations.Test;
import java.io.IOException;

import Pages.LandingPage;
import static base.Base.driver;

public class landingPageTest extends BaseTest{
	LandingPage lp;
	
	@Test(priority=0, description="Verifying the objects in the Landing Page")
	public void verifyLandingPage() throws InterruptedException, IOException{
		lp=new LandingPage(driver);
		lp.verifyTitle();
		lp.verifyHeader();
		lp.verifyCopyrightAndEnterStore();
	}
}
