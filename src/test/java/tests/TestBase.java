package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase  extends AbstractTestNGCucumberTests {

	public static WebDriver driver ;
	@Parameters (("browser"))
	@BeforeSuite
	public void startDriver(@org.testng.annotations.Optional("chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
			driver = new ChromeDriver() ;
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/drivers/firefox.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+ "/drivers/operadriver.exe");
			driver = new OperaDriver() ;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com");

	}


	// taking screenshot
	@AfterMethod
	public void takingScreenShot(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE )
		{
			System.out.println("Failed");
			System.out.println("Taking screenshot");
			Helper.CaptureScreenShoot(driver, result.getName());

		}
	}
	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}

}
