import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//1.Let we want to count the link count on the page
		System.out.println(driver.findElements(By.tagName("a")).size());  //This will give count
		
		//2. Get the count of link in the footer section
		//We need to limit the scope of webDriver to that footer section i.e we need to create subset/minidriver of driver so we get
		//we get count of particular section. First we need to minimize the scope of global driver object
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));       //we need to create new webelement for this to minimize scope of global driver
		// now footerdriver places role of actual driver for this subsection, act as driver for this section
		System.out.println(footerdriver.findElements(By.tagName("a")).size()); //Get count of link in footersection
		
		
		//3. I wannt link count of first column from footer section
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		// 4. Click on each link in column and check if the pages are opening
		//Now if we assume that this page is dynamic because if product added then count is changing so that why we use a tag
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			//columndriver.findElements(By.tagName("a")).get(i).click();  //we use get(i) because that only link it will take
			
			//But still this test fails because it will open 1st link in same tab and then we try to open 2nd link but that link is not on page 
			//so we have to either tell to press back button and ask to click on 2nd link so here we need to add back button step
		   //but suppose we have 100 links here and if we want to handle all of them for every link we have to click navigate to that page and then press back button
			//but it will eat at least 30 sec for each and every link so it is not good practice to do instead of that there is optimize way to do that
			// press control and click link it will open in seperate tab
		
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);  //It will open each link in new tab
			
			//Now we want to get each title of 4 windows so we need to switch to child window
			// First we need to switch the driver to each specific childs window ang get title so lets 
			Thread.sleep(5000);
		}  //Opens all the tabs
		
			Set<String> abc=driver.getWindowHandles();   //we have to use set as datatype
			Iterator<String>it=abc.iterator();  //here we need to use Iterator return type                                      //here we have to iterate over each window so lets use iterator
			while(it.hasNext())    //it.hasNext()- tells us next index is present or not, if it present go inside block and moves to next index using it.next()
			{
				driver.switchTo().window(it.next());   //it.next is window ID
				System.out.println(driver.getTitle());
			}
		}
		
		
	}


