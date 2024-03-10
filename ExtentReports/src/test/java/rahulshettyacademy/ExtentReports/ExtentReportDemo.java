package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;

	@BeforeTest
	public void config()
	{
		//ExtentReports and ExtentSparkReporter
		String path=System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
	    extent=new ExtentReports();
	    //Now we have to attach report whatever we createst using ExtentSparkReporter.
	    extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Sameer Erande");   //This will define tester name
	    
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test=extent.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver","C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result do not match");
		
		extent.flush();   //mandatory stage
		
	}
}
