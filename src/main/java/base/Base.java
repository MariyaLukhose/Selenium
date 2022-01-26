package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.simple.parser.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.gson.Gson;
import java.util.logging.*; 

public class Base {
	public static WebDriver driver=null;
	public static Properties prop;
	public static Logger log;
	private String absPath;
	
	//Initializing the variables in the constructor
	public Base(WebDriver driver) {
		Base.driver=driver;
		absPath=new File("").getAbsolutePath()+"/src/main/resources/utility/";
		prop=new Properties();
		try {
			log= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
			FileInputStream conf = new FileInputStream(absPath+"config.properties");
			prop.load(conf);
			FileInputStream asert=new FileInputStream(absPath+"Assertion.properties");
			prop.load(asert);
			FileInputStream path=new FileInputStream(absPath+"path.properties");
			prop.load(path);
			FileInputStream search=new FileInputStream(absPath+"Data.properties");
			prop.load(search);
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
        }
	}
	
	//Launching browser and opening the URL 
	public void set(String browser) throws IOException{
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(prop.getProperty("firefoxKey"), prop.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		log.info("Browser Launched");
		driver.get(prop.getProperty("baseUrl"));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    log.info("URL Launched");
	}
	public JSONArray JSONReader(String FilePath) throws IOException, ParseException {
		Object inputFileData = new JSONParser().parse(new FileReader(FilePath));
		String dataString = new Gson().toJson(inputFileData);
		// Converting jsonString to JsonArray
		JSONArray dataArray = new JSONArray(dataString);
		return dataArray;
	}
	//Returning the driver instance
	public WebDriver getDriver() {
	    return driver;
	}
	//Closing all driver instances
	public void tearDown() {
		driver.quit();
	}
}