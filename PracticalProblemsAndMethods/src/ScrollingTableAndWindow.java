import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingTableAndWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//If the page part is not in visible mode when open and need to sroll we need to write
		//Scrolling script and then perform operation
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//By default selenium is not providing any scrolling technique so we need to write Javascript which help to scroll down
		//First we need to initialize Javascript executer object
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");   //Here we have to write script for scroll
		//If we want to run javascript on browser we can do it from console using window.scrollBy(0,500)
		// and hit enter give coordinate by seeing scroll
		Thread.sleep(3000);
		
		//But what we want to scroll down inside Web Table Fixed Header Table for that we need to call dom object
		//document.querySelector(".tableFixHead").scrollTop=5000    same like driver.findElement in selenium 
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Q.Let we want to find the locator of 4th column and sum all values it is showing td in html so its too generic so how to find css for that
		
		List <WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); //Store all this elements in list
	    int sum=0;
		for(int i=0;i<values.size();i++)
	    {
	    	sum=sum+Integer.parseInt(values.get(i).getText());       //we want sum so we need to convert the text to integer using parseInt
	    
	    	
	    }
		System.out.println(sum);
	   //Q. Now we want to compare actual sum with given sum given on webpage
		String[] str=driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
	     int total=Integer.parseInt(str[1].trim());
	     Assert.assertEquals(total, sum);
	  
	}

}
