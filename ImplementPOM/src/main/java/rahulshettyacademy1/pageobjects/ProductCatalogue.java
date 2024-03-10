package rahulshettyacademy1.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	// Above Step can be written as follow
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	
	@FindBy(css = ".ng-animating")         //PageFactory
	WebElement spinner;

	// Lets start with our action methods

	By productsBy = By.cssSelector(".mb-3");

	public List<WebElement> getProductList() {     //get product list
		waitForElementToApperar(productsBy); // here we can't use page factory it is for driver.findElement construction
		return products;
	}
	//Action Class
	public WebElement getProductByName(String productName)
	{
		WebElement prod=products.stream().filter(product->      
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	    return prod;
	}
	//Actual Method for 
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToApperar(toastMessage);
		waitForElementToDisappear(spinner);
	}
}
