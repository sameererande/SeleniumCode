package rahulshettyacademy1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	//Now lets write action method here
	
	public String getConfirmationMessage()
	{
		return confirmationMessage.getText();
	}

}


