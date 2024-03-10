import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locator2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name="rahul";
		//we can copy most of codes from locator class
		System.setProperty("webdriver.chrome.driver","C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String password=getpassword(driver);   //as we created driver object in 16th line that object we are sending here and then control goes to method
		//we can directly place value of password in line 22
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //it is applicable for every line to wait for 5 sec
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
        //we want to show login successful message
		Thread.sleep(1000); //we already use implicit wait then why we need to use thread.sleep() because there is 2 <p> tag as implicit wait is used to when something is not exist in page and we are waiting to show off 
		//and implicit wait comes into picture when tagname p is not appearing so here no use of that
		System.out.println(driver.findElement(By.tagName("p")).getText());  //we use tagname because p is there on page and here we want to add assertion to check the text is correct or not
		// to do that make sure we have testng dependency in pom.xml as it is framework but remove scope line from that dependencies
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in."); //assertion
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");//get using css selector
        // Another way of writing using xpath is as following
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();   //here we use * in place of button
        driver.close();
        
            
                                                                               
        
		
	}
	
	
	//let we want to take password automatically from reset button as let's password is changing frequently for that we are creating one method
	public static String getpassword(WebDriver driver) throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");	//driver showing error so we need to write webDriver Driver inside()
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();	
		String passwordText=driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String [] passwordArray=passwordText.split("'");
		//0th index-Please use temporary password 
		//1st index-rahulshettyacademy' to Login.
		String [] passwordArray2=passwordArray[1].split("'");
		String password=passwordArray2[0];
		return password;
		//now we can call this method in main block by creating object of class or change method to static
	}

}
