import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Framestest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//driver.findElement(By.id("draggable")).click(); // Drag me to my target 
		//Test is fails but why because the entire box is in frames we need to tell selenium this so how to tell 
		//selenium that go into frame and handle it for this there is a method and see iframe on html inspect so we need to switch this iframe but how to switch it
		//To switch it we have 3 options 
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));   //here we use 3rd option frame(webelement)
		// 1st option is use index in frame method suppose we have 3 frame and want to go to 2nd frame then give index of 1 but not follow this because if developer added new code in html it create error
		// If ther is frame in application it will start with iframe tag so we can use tagname to find frames use findElements and size() method to get count
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.findElement(By.id("draggable")).click();
		
		//Test case run but no action is there i.e no drag and dropp
		//Drag and drop is achievable by using action class
		//Lets create Action class
		
		Actions a=new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();    //here we use drag and drop method and here we need to provide webelement inside method
		
		// once this frame work is done and we want to perform any operation outside frame webdriver not switch it automatically
		driver.switchTo().defaultContent();  //It is comes to normal operation.This step is must
		
	}

}
