import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// pasengers dropdown
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		// let we want to select 5 adults so we want to click 3 times on + sign
		// driver.findElement(By.id("hrefIncAdt")).click(); //for 2nd adults
		// if we want add 5 adult we can repeat code but this is not ideal case so we
		// can use loop

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 4 times loop continue
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click(); // For Done
		// after selecting 5 adults let we want to see that text
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
	// we can use for loop also instead of while loop
	// for(int i=1;i<5;i++){
	//
	// }

}
