import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalenderUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Suppose we want to select today's date
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		//Once we land on website we will provide month name and date name,whatever we provide this test case should go and click on that
		//Lets target first on selecting date and then month
		// January 23
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='form-field-travel_comp_date']")).click();
		//driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click(); 
		//Now we want to select day Apr 9 in this  case we will use css in this website classname is common for all 30 days so what to do now
		
		List<WebElement> dates=driver.findElements(By.className("flatpickr-day"));   //here we tell go and find all classname and put them all in list and iterate it
		// and check item is Apr 9 if it is click on 

		for(int i=0;i<driver.findElements(By.className("flatpickr-day ")).size();i++)
		{
			String text=driver.findElements(By.className("flatpickr-day ")).get(i).getText();
		    if(text.equalsIgnoreCase("9"))
		    {
		    	driver.findElements(By.className("flatpickr-day ")).get(i).click();
		    	break;
		    }
		
		}
		
	}

}
