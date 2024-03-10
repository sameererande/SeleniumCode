package rahulshettyacademy1.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	//List<WebElement> cartProducts=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
	@FindBy(xpath="//*[@class='cartSection']/h3")
	 private List<WebElement> cartProducts;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement checkoutele;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	//Boolean match=cartProducts.stream().anyMatch(cartProduct->
	//cartProduct.getText().equalsIgnoreCase(productName));
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match=cartProducts.stream().anyMatch(product ->
		product.getText().equalsIgnoreCase(productName));
		return match;	
	}
	
	public CheckoutPage goToCheckout() throws InterruptedException
	{
		checkoutele.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		return new CheckoutPage(driver);
		
	}

}
