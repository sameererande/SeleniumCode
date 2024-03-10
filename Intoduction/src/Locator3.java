import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty help us to invoke actual chrome browser
		//in recent release this step is optional ythere is new package in jar now called selenium manager
		System.setProperty("webdriver.chrome.driver","C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//we will see another way of identifying locators
		// Sibling-parent traverse(this is only possible in xpath not in css)
		//Absolute xpath- means starting from top(html) root of html and start with single slash(/)
		//relative xpath we can start with middle we need to give // here we mostly  use this because if absolute xpath is large and if something break in middle of hierarchy it will create problem
		// for moving from sibling to sibling no need to apply slash(/) for that we use /following-sibling::tagname[1]
		//  //header/div/button[1]/following-sibling::button[1]
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText()); //Login button clicking  parent to sibling-sibling
		//traversing back from child to parrent(
		//header/div/button[1]/parent::div/parent::header/a----it is coming to anchor tag 
		
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());  //child to parent tranverse for login 
		
		
	}

}
