import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java_Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //class first name must be capital
		// first letter of variable must be small
		String name = "Rahul";
		// We cannot inspect alerts so there is other mechanism for that
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();

		// There are two type of alert just click on ok. and other one is click on Ok
		// and cancel button

		// now after that we are getting popup to work with it there is method to switch
		// from driver to switch
		// Let we want to grab text present on alert box
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// 2 type of alert=Confirm alerts
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		// Click on no
		driver.switchTo().alert().dismiss();
   
		
		//debugging code in eclipse
		//we can execute code step by step and see that go to code number right click and select toggle breakpoint
		// and to run as select as debug as , it is used to check where is code showing error
		// if we select any line for debug as run as debug that line will highlight with yellow color and to watch it step by step click on step over
		//now again next line highlight and when you click on step over it step will complete
		
		//To swich off debug mlode click on resume
		
		//if there is method and we want to go inside that method and debug it select step into
	}

}
