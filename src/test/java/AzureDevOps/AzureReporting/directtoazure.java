package AzureDevOps.AzureReporting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class directtoazure {
	public static WebDriver driver;
	public static ExtentReports Extent;
	public static ExtentSparkReporter Reporter;
	
	@Test
	public void automation1()
	{
		Extent = new ExtentReports();
		Reporter = new ExtentSparkReporter("index.html");
		Reporter.config().setTheme(Theme.DARK);
		Reporter.config().setDocumentTitle("Test Report for Direct automation script upload");
		Reporter.config().setReportName("Test Run -1.01");
		Extent.attachReporter(Reporter);
		ExtentTest test = Extent.createTest("automation1").assignAuthor("Tina").assignDevice("Windows - Chrome");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		test.info("Launching URL");
		driver.get("http://sampleapp.tricentis.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("nav_automobile")).click();
		test.pass("Clicked on Automobile link");
		try {
			Assert.assertEquals("Tricentis Vehicle Insurance", driver.getTitle());
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			test.fail(e.getMessage());
		}
		
		driver.quit();
		Extent.flush();
		
	}

}
