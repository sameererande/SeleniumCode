import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Entered form and select movie/fight enter when we click on search page is loading for few 3-4 sec and we want to select first option
		//With selenium we write code for search button when search is completed selenium immedietly goes for first option selection but page is loading for 3 sec result are not yet displaced
		//so webdriver will throw an error so need to tell webdriver to wait so this is called synchronization
		// 4 waits are there
		//1)Implicit wait-we actually define wait time globally
		//eg. Wait for 3 number of second before you throw exception
		// Advantages- we can define it globally so that if we have 100 steps in application then between each and every step there is time of 3 sec
		//  Let use 3 sec of wait and our application load in 2 sec that means it will not wait for 3 sec it will listen to DOM(html code)
		//  It will not wait for entrirely 3 sec once result is available then it will come out of wait
		// Disadvantages- Let we have plan of 100 test cases and it instance with single driver object in framework and we give 3 sec wait
		//  now there is condition that when I do scenerio 1000 of results will returned so means in single webbrowser 1000 of flights/hotels will retrieved
		// when we search for hotel in new york we hardly get 50-100 but when I search for hotels in united state my result will 1000. to fetch 1000 result from database
		// our system takes 15 seconds to load so what will do in this scenrio?
		// we can't use 15 sec wait to load because every city result written in 3 sec because lets say if there is glitch in website and city takes 10-13 sec to refresh result that case our script passes
		//so glitch is error but due to we increase wait to 15 sec we are not catching this error so this is bug so there is time wastage also 
		// so to solve this problem we are using explicit wait
		
		// 2) Explicit wait- 
		//In explicit wait we can target specific element and say wait 15 sec so this 15 sec wait is applicable to that specific locator only
		//If all scenerio takes 3 sec wait to load but 2-3 scenrio takes 15 sec wait for that 2-3 scenrio we will use explicit wait
		
		// Combination of both implicit and explicit wait is ideal combination in real life problem
		
		
		// 3) Thread.sleep()- we can halt execution ,let it take 3 sec to load it will pass the script for 3 sec
		// It is part of Java not selenium . if result are loaded in 2 sec then also it will wait for 3 sec it is not listen to DOM as implicit wait is listening to DOM
		// It is not preferring as it is waiting even after script pass
		
		//
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  //This wait is applied to each and every step
		
		
		
		String[] itemsneeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000); //
		addItems(driver,itemsneeded);  //This is utility
		//The method we want to call in main method we first need to create object of class and from that object we can call
		//but here we create static method so no need to object creation
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();  //As text is static so we use text in xpath
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		//Test not run showing no such element found exception so we need to wait we can use implicit and explicit wait also
		//before reaching this page this test run so it is showing error so using implicit wait we are telling to wait for 5 sec globally
		// for click on apply
		//When we click on Apply this is taking some time so implicit wait should apply here also lets see
		driver.findElement(By.cssSelector("button.promoBtn")).click(); //So it is working fine with implicit wait
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText()); //Code Applied Text
		
		
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