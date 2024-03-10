package rahulshettyacademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy1.pageobjects.CartPage;
import rahulshettyacademy1.pageobjects.CheckoutPage;
import rahulshettyacademy1.pageobjects.ConfirmationPage;
import rahulshettyacademy1.pageobjects.LandingPage;
import rahulshettyacademy1.pageobjects.ProductCatalogue;

public class StepDefinationImpl extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=lauchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogue=landingPage.loginApplication(username,password);
	}
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException
	{
		List <WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) throws InterruptedException
	{	
       cartPage=productCatalogue.goToCartPage();
		
		Boolean match= cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);	
    	//CheckOut
	    checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		
		 confirmationPage=checkoutPage.submitOrder();
	}
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage=confirmationPage.getConfirmationMessage();
	    Assert.assertEquals(confirmMessage,string);
	    driver.close();
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	    driver.close();
	}
	
}
