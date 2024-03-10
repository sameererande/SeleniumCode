import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
		// From and To dropdowns are called Dynamic dropdown because To dropdown option is loaded only after we select city from  From dropdown
		//We are calling it dynamic dropdown because when we first time obtain chennai city xpath and then again refresh page and then search for xpath in chropath/selectorhub it is showing zero matching but when we open From Dropdown and then search x path it is showing 1matching let's here we select bengaluru and if we open To dropdown and again search chennai xpath it is showing two matching
		// so giving two match in To dropdown is problem it will not select chennai from To dropdown as it is 2 matching so it is searching for 1st matching xpath but From we select bengaluru
		//so test will fails in this case when two notes are found we need to explicitly tell selenium to click on 2nd path not on 1st xpath
		// in that case we need to wrap our To dropdown xpath in () and need to tell index also  like //(a[@value='MAA'])[2]
		
		//so we need to give () around xpath and then index
		System.setProperty("webdriver.chrome.driver","C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		////a[@value='MAA'] - xpath for chennai
		// //a[@value='BLR']  - xpath for bengaluru
     	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();  //click on from dropdown
     	driver.findElement(By.xpath("//a[@value='BLR']")).click();   //select bengaluru
     	Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();  // as To dropdown option is open by default but it will take 2 sec so we need to give thread.sleep
//        
		
		//some clients not like to use indexes inside code so how we will handle this dynamic dropdown
		//so let's see another way to do it so let's write xpath to parent to child traverse
        // parentxpath childxpath    as here we using parent node direct so no 2 matching finding so no need to use index here
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();  //there is space between parentnode and childnode
		
	}
}

