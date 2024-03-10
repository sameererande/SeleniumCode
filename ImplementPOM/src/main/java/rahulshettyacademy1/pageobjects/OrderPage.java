package rahulshettyacademy1.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	@FindBy(css="tr td:nth-child(3)")
	 private List<WebElement> productNames;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement checkoutele;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	//Boolean match=cartProducts.stream().anyMatch(cartProduct->
	//cartProduct.getText().equalsIgnoreCase(productName));
			
	public boolean VerifyOrderDisplay(String productName) {
		// TODO Auto-generated method stub
		Boolean match=productNames.stream().anyMatch(product ->
		product.getText().equalsIgnoreCase(productName));
		return match;	
	}
	


}
