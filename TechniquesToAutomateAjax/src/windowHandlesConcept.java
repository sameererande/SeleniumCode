import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandlesConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		//By default when we land on this page we are not getting any username so to get this we clicked on top right link that willl open another
		//child window in that tab one email id is there so we need to grab that email id and come back to parent page 
		// Lets write a test script for this
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//Now it will open seperate tab now scope of our driver is in parent page only because using driver we invoke page using url it will not switch to new tab so we need to give knowledge to selenium so it will shift to parent to child browser
		//so how to do that for that we nned to see how many windows are open by selenium
		//so we can get id of those windows by using driver.getWindow handles
		
		Set<String> windows=driver.getWindowHandles();    //This will give ID of all windows open by our automation
	    //now to switch to child window we will use to switchTO
		Iterator<String> it=windows.iterator();
		String parentId=it.next();   //This help us to get next index of our set(0 index)
		String ChildId=it.next();                             //for child id do it for 1 more time
		driver.switchTo().window(ChildId);  //move window to childId
		
		//Step2 Extract text of paragraph
		//In css writing if space is there we are replacing it with dot
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
	
		// Step3) we will use string method to extract only email Id from text so let use to some debug techniques By typing in expression tab we will get details debug step run as debug select that debug step right click and watch
		driver.findElement(By.cssSelector("p.im-para.red")).getText();
		String emailId=driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        //Now we have to paste emailId in parent window email ID but before that switch to parent window
		driver.switchTo().window(parentId);
		
		driver.findElement(By.cssSelector("input#username")).sendKeys(emailId);
		
	}

}
