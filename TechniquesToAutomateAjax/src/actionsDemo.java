import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Let use Amazon.com site
		//on amazon site if we move mouse some field are automatically displayed no need to click on that field
		//If we have that validation in test scenerio then how we will automate that? this interaction done by action classs
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions a=new Actions(driver);    //we are creating action class and pass the driver object as argument
		
		//2) Now lets build composite action lets we want to search in capital letters
		 a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();    //Go to search box first we want yo click it() and then for capital letter keydown(), Keys.Shift hold shift button and then sendskeys and then to build it use build() and then perform()
		
		//3) Now lets our goal is to select the Hello text we enter generally we select it by double click
		//a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		 //1)Moves to specific element
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();    //move to specific element and after we use build() means step is ready to execute and by using perform() it will perform operation
		
		//4) Now performing step 1 we want to right click the element how to do that
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();
		
		
		//Instead of keydown() we can use clickAndHold() action
		// If we know coordinate by using moveByOffset we can move to target
	}

}
