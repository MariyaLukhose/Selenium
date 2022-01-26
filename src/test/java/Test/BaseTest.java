package Test;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import base.Base;
import static base.Base.driver;

public class BaseTest {
	public Base ob;
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) throws IOException {
		ob=new Base(driver);
		ob.set(browser);
	}
	@AfterClass
	public void tearDown() {
		ob.tearDown();
	}
}
