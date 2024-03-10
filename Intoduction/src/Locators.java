import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//implicit wait- tell us to wait for 5 sec or 10 sec so that object will show
   
		System.setProperty("webdriver.chrome.driver","C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //it is applicable for every line to wait for 5 sec
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahulshetty@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		//Capturing incorrect username and password message
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); //this is failing due to timeout issue for this we need to use thread.sleep or waits
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);  //for reset button it was showing interupted exception so we use thread.sleep() and when we use this main method give this exception. this wait for waiting for object to get in stable state
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();   //clear email ID using xpath
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");  //by using nth child in css selector
		//another way of xpath using parent tag only - //parenttagname/childtagname
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9881220420");
		//Reset login button using css selector
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();	
		//using parent child tagname for css selector
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); //click go to login using (xpath tagname parentname childname and index)
		Thread.sleep(1000);  // as frame is shifting from left to right so to get it in stable state we use thread.sleep()
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*=pass")).sendKeys("rahulshettyacademy"); //here we are using regular expression cssselector(*) for dynamical object
		driver.findElement(By.id("chkboxOne")).click();  //check a checkbox
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //regular expression using xpath for dynamically changing object(see syntax carefully we are using contain here)
		
		
	}

}
