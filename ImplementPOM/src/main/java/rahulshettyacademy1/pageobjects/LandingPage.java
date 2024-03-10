package rahulshettyacademy1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
    
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		//initialization
				this.driver=driver;
				PageFactory.initElements(driver, this);
	}
	//WebElement userEmails= driver.findElement(By.cssSelector("#userEmail"));
	//PageFactory-- simplified way
	@FindBy(css="#userEmail")  //here we are sending locator and value in this annotation
	WebElement userEmail;
	
	@FindBy(css="#userPassword")
	WebElement passwordEle;
	
	
	@FindBy(id="login")
	WebElement submit;
	
	//Write page factory for incorrect username and pass
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	public String getErrorMessage()
	{
		waitForWebElementToApperar(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
