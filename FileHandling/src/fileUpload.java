import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\samee\\Grid\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("#browse")).click();
		//Here we need to call the .exe file
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\samee\\Downloads\\AutoIT\\fileupload.exe");
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(null))
		
	}
	

}