import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FixingProblemsWithInconsistentLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//first time we click on add to cart for brocolli it changed to added then 0 index started from next vegetable so
        //in debug mode it is run slowly takes 5-6 sec so it came back to add cart mode
		//so that is reseaon do not believe on text while add in locator text can change in any time
		//so we need to replace locator
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int j=0;
		
		String[] itemsneeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000); //
		//Let we want to add cucumber into cart
		//  //button[text()='ADD TO CART']  if we use this xpath 30 elements are matching so how to do that?
		//so let first go to identity cucumber product and then will go inside and identify button
		//so identify full block
		//   h4.product-name by using this css selector also 30 elements matching so we need to iterate over and find the index of cucumber
		
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
					
					//In debugging mode code run correctly but we run it normally instead of cucumber tomato is added why?
					
					
					//why can't we directly give size of array instead of giving hardcore number
				}
			}
	}

}
}
