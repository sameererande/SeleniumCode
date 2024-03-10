import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //maximize windows
		driver.get("http://google.com");//in this method there is inbuild wait mechanism
		driver.navigate().to("https://rahulshettyacademy.com"); //navigate to new page
		driver.navigate().back();
		driver.navigate().forward();
	}

}
