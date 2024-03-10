import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Explicitwait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));  //Explicit wait
	
		
		
		String[] itemsneeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000); //
		addItems(driver,itemsneeded);  //This is utility
		//The method we want to call in main method we first need to create object of class and from that object we can call
		//but here we create static method so no need to object creation
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();  //As text is static so we use text in xpath
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click(); 
		//Explicit wait
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));  //By.cssSelector("") Locator
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText()); //Code Applied Text
		//Explicit wait comes with 2 types- 1)With webdriver wait 2)fluent wait
		// We use explicit wait to target specific elements
		
		//Advantages of Explicit Wait- It only applied whenever requires and targetted Element
		// Disadvantages- More Code
		
		
	}
	//Lets create a method and wrapped code inside it
	public static void addItems(WebDriver driver,String[] itemsneeded) {

		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			

			String[] name=products.get(i).getText().split("-");   
			String formattedName=name[0].trim();
		
			List itemsNeededList=Arrays.asList(itemsneeded);
			
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //earlier we use Add to cart text and text chaged after add to cart so here we use parent node and child node
				
				//if(j==3)  //j=3 is size of array
					if(j==itemsneeded.length)  //instead of hardcore we use length function to find size of array
				{
					break;
				}
	}


	}

	}

}
