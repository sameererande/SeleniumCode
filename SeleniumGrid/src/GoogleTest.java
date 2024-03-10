import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class GoogleTest {

	@Test 
	public void HomePageCheck() throws MalformedURLException, URISyntaxException
	{
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setBrowserName("chrome");
		//caps.setPlatform(Platform.); For which windows we need to select
		//caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		//There is another way to set Browser
		//caps.setCapability(CapabilityType.BROWSER_NAME,"chrome");
		WebDriver driver=new RemoteWebDriver(new URI("http://192.168.0.108:4444").toURL(),caps);  //we can use URL or URI 
		//URL  is depreciated one so we used URI
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("rahul shetty");
		driver.close();
		
		
		
	}
}
