package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy1.pageobjects.CartPage;
import rahulshettyacademy1.pageobjects.CheckoutPage;
import rahulshettyacademy1.pageobjects.ConfirmationPage;
import rahulshettyacademy1.pageobjects.LandingPage;
import rahulshettyacademy1.pageobjects.OrderPage;
import rahulshettyacademy1.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	    String productName="ZARA COAT 3";
	    @Test(dataProvider="getData",groups= {"Purchase"})
	    public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException
	    {
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
		List <WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));

		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match= cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);	
    	//CheckOut
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmMessage=confirmationPage.getConfirmationMessage();
	    Assert.assertEquals(confirmMessage,"THANKYOU FOR THE ORDER.");
	    
	    
	}
	    //To verify Zara Coat 3 is displaying in orders page 
	    @Test(dependsOnMethods= {"submitOrder"})
	    public void orderHistoryTest()
	    {
	    	//"ZARA COAT 3";
			ProductCatalogue productCatalogue=landingPage.loginApplication("sameer0908@gmail.com","Samerande123@");
            OrderPage ordersPage=productCatalogue.goToOrderPage();
            Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
			
	    }
	    
	    
	    
	    
	    @DataProvider
	    public Object[][] getData() throws IOException
	    {
    
	    List<HashMap<String,String>>data=getJasonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
	    return new Object[][] {{data.get(0)},{data.get(1)}};
	    
	    }
	    
//    	HashMap<String,String> map=new HashMap<String,String>();
//    	map.put("email","sameer0908@gmail.com");
//    	map.put("password", "Samerande123@");
//    	map.put("product","ZARA COAT 3");
//    	
//    	HashMap<String,String> map1=new HashMap<String,String>();
//    	map1.put("email","shetty@gmail.com");
//    	map1.put("password", "Iamking@000");
//    	map1.put("product","ADIDAS ORIGINAL");
//    	return new Object[][] {{map},{map1}};
	    
	    
 
//	    @DataProvider
//	    public Object[][] getData()
//	    {  
//	    return new Object[][] {{"sameer0908@gmail.com","Samerande123@","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//
//	    }
}
