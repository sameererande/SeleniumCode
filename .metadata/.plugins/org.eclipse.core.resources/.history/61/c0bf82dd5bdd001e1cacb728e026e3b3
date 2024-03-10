import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\samee\\Grid\\chromedriver.exe");
	
		WebDriver driver=new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/");
		driver.get("http:admin:admin@the-internet.herokuapp.com/");
		//(http://Username:Password@SiteURL
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		//driver.findElement(By.linkText("Basic Auth")).click();
		//After this windows authentication popup will open
	}

}
