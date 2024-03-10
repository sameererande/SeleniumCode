import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
   //we are using flight booking link for every dropdown now
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //static dropdown-options in dropdown are fixed 
		//any dropdown have tag select then there is special class in selenium mostly select dropdown are static
		System.setProperty("webdriver.chrome.driver","C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//dropdown with select tag
		WebElement staticDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByIndex(3);//select by index
		System.out.println(dropdown.getFirstSelectedOption().getText());  //Extract text of webElement
		dropdown.selectByVisibleText("AED");  //select AED
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");     //here selectByValue is value attribute in doms
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}
