import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base2witharray {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
			//Brocolli - 1 Kg  to split it we will use split method

			String[] name=products.get(i).getText().split("-");  //we need to format it to get actual vegetable name and pass it to if condition to check with array
			String formattedName=name[0].trim();
			//Check wheather name you extracted is present in array or not
			//convert array into arraylist for easy search,in runtime we are converting array to arraylist as array consume less memory
			List itemsNeededList=Arrays.asList(itemsneeded);
			
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			//in arraylist we cannot use break because when we click on brocolli first and use break we directly come out of for block so it will not iterate for cucumber
			// but if we not use break iteration will go on for 30 time so how to solve this?
				//so we will declare one more variable j
				//if j=3 then break
				
				if(j==3)
				{
					break;
					
					//In debugging mode code run correctly but we run it normally instead of cucumber tomato is added why?
					//
			
			}
			
			
			
		}
	}

	}
}

