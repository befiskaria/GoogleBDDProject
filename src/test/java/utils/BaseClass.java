package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataDriven.ExcelReaderHM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	private static BaseClass baseReference;
	// using properties method to connect with Config.properties class
	// using static we can access from different classes
	// Fetching Properties and saving in Config variable
	public static Properties Config = new Properties();
	public static String screenshotdir=System.getProperty("user.dir")+"/screenshots/";
	public static WebDriver driver;
	public BaseClass() {
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\Config.Properties");
			Config.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}

	// Step 2: Store common commands that will be used by child classes
	public static void openPage(String url) {
		driver.get(url);
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void launchBrowser() throws Exception {
		String browserName=ExcelReaderHM.getValue("Browser");
		//String browserName=Config.getProperty("Browser");
		if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.webpageTimeout, TimeUnit.SECONDS);

		if (baseReference == null) {

			baseReference = new BaseClass();
		}
	}

	public static void tearDown() {

		if (driver != null) {
			driver.quit();
		}

		baseReference = null;
	}
}
