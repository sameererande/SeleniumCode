import java.lang.StackWalker.Option;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown {
//country- it autosuggest country name based on our input
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/samee/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Ind"); // country step
		Thread.sleep(3000); // wait 3 sec so options related to Ind will display
		// Our next goal is select India but we don't know what is the order of sequence
		// so we need to get all options suggested should grab them and and iterate
		// through each and every option present in list and find desired
		// so we should write generic xpath or css which should extract all item present
		// in list

		// here we want to find all the items have the locators so we are using
		// findElements and return type of findElements is List<WebElement> and we get
		// that when we type driver.findElements
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // here 3 matching
																										// elements are
																										// there and we
																										// want to get
																										// all
		// we catch this in options variable
		// now our goal is to iterate over each and every option and see if it matches
		// with our requirement and we are using enhance for loop

		for (WebElement option : options) // every time when loop iterates we pick one option and that option stored in
											// the (option) variable
		{
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break; // as our goal is completed break the loop
			}
		}
	}

}
