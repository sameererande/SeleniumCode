import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluentwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Fluent wait finds the web element repeatedly at regular intervals of time until the timeout or till the object gets found
		//Unlinke webdriver wait we need to build customized wait methods based on condition
		//Fluent wait is not actively monitering element
		//We need to build customized wait methods based on condition in Fluent wait but in explicit wait it is already there
		//Fluent wait comes under explicit wait 
		// WebDriverWait= 10 seconds
		//FluentWait= 10 seconds ,polling 2 sec, after every 2 sec it check object is found or not 
		// In real time most of time we are using webdriver wait
		//e.g In E commerce website credit card details and submit for first 5 sec we are getting message of your card is accepted and after 10 sec get message of your order is being processes and then we will get confirmation page
		// in first 3 sec we got  card accepted message  and next 7 sec we get order is processed so they told us to automate but both accepted and processsed have same html properties, when we use xpath first one is accepted that's reason we put polling=4 sec and use 
		// fluent wait . it first check for 0th sec, then 4 sec, then 8 sec so on
		//Disadvantage- code is complex to write
		
		//Both webDriverWait and FluentWait are classes implement Wait interface
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();   //ChromeDriver is class which implementing WebDriver interface
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div[id='start'] button")).click(); // Start 
		
		//So FluentWait is also class which is implimenting wait interface
		 Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class) ; //we need to tell driver is werbdriver so we use <WebDriver>
		 
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		    public WebElement apply(WebDriver driver) {
		     // return driver.findElement(By.cssSelector("div[id='finish'] h4")); // This is static element which is already present on page so even we run test is failing it is telling that it is present on page but not displaying on front screen not in visble mode
		      //so we need to tell system that wait until element is visible and then return webelement
		      if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed())  //We need to wait untill Hello World! text is displayed
		      {
		    	  return driver.findElement(By.cssSelector("div[id='finish'] h4"));  
		      }
		      else
		    	  return null;
		
		    }
		 });   //So here we made customized method
		 System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
	}



		
	}

