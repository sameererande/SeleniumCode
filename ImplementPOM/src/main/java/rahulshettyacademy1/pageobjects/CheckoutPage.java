package rahulshettyacademy1.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// a.sendKeys(driver.findElement(By.cssSelector(".form-group
	// input")),"india").build().perform();
	@FindBy(css = ".form-group input")
	WebElement country;
	// Page Factory for actionm submit
	// driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css = ".action__submit")
	WebElement submit;

	// Selecting 2nd item India
	// driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	// Fow ElementToApperar
	By results = By.cssSelector(".ta-results");

	// Based upon above 3 PageFactory element we have to write Actions. lets create
	// action method and add 4 lines of code

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToApperar(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public ConfirmationPage submitOrder()
	{
		submit.click();   //This will written confirmation Page object
		return new ConfirmationPage(driver);    //confirmationPage object
		
	}
}
