package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.TestComponent.Retry;
import rahulshettyacademy1.pageobjects.CartPage;
import rahulshettyacademy1.pageobjects.CheckoutPage;
import rahulshettyacademy1.pageobjects.ConfirmationPage;
import rahulshettyacademy1.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	    @Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	    public void loginErrorValidation() throws IOException, InterruptedException
	    {    	
		String productName="ZARA COAT 3";
		landingPage.loginApplication("samer0908@gmail.com","Samerane123@");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());   
	}
	    @Test
	    public void productErrorValidation() throws IOException, InterruptedException
	    {
		String productName="ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("sameer0908@gmail.com","Samerande123@");
		List <WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match= cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);	
	    
	    
	}    

}
