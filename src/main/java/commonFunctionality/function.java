package commonFunctionality;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class function {
	WebDriver driver;
	public static void AssertEquals(String actual, String expected) {
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actual, expected);
	}
}
