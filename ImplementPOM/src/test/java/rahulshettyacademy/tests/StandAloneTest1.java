package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy1.pageobjects.LandingPage;

public class StandAloneTest1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();  //Chromedriver will automatically downloaded in backend
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Add implicit wait on global level
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage=new LandingPage(driver);
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("sameer0908@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Samerande123@");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));  //All product stored in list
	    //Now iterate and find for which product title is displaying.
		WebElement prod=products.stream().filter(product->      //If we want whole WebElement use filter 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);       //Stream will helps us to itterate through each and every item in the products
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();   //here we use prod.
		//Make sure product is added message is showing and we have to wait until loading operation is completed for that message
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//we have to wait till that animating icon disappears class of that- ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		//Now we will again apply stream to iterate
		Boolean match=cartProducts.stream().anyMatch(cartProduct->   //If we want to check just condition matches use anyMatch
		cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		//CheckOut
		driver.findElement(By.cssSelector(".totalRow button")).click();  //Parent child 
	   
		//AutoSuggestive Dropdown 
		//But lets here use Actions class
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")),"india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();   //Using CSS selector
		       //(//button[contains(@class,'ta-item')])[2]--xpath using regular expression
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btnn.action__submit.ng-star-inserted")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".action__submit")).click();  //For Submit 
		
		
		
		//Use Assert to check actual Thank you message message is there or not
		
		String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	    Assert.assertEquals(confirmMessage,"THANKYOU FOR THE ORDER.");
	    
	    driver.close();
	}

}
