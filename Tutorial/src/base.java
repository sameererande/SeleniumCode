import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Let we want to add cucumber into cart
		//  //button[text()='ADD TO CART']  if we use this xpath 30 elements are matching so how to do that?
		//so let first go to identity cucumber product and then will go inside and identify button
		//so identify full block
		//   h4.product-name by using this css selector also 30 elements matching so we need to iterate over and find the index of cucumber
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			String name=products.get(i).getText();
			if(name.contains("Cucumber"))
			{
				//Click on add cart
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();  //findElements
				
				break; 
				
				//Let we want to add brocolli also so writing repeatative code is bade practice so we can declare the expected array at top and then pass the product in block
			}
		}
	}

}
