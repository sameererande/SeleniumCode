package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
   //Lets assume we have car loan application so we have login module 
	//Lets we have 3 type of Test cases 
	
	@BeforeClass
	public void beforeclas()
	{
		System.out.println("Before executing any method in the class");
		
	}
	@Parameters({"URL"})
	@Test
	public void WebloginCarLoan(String urlname)
	{
	
		//Selenium code to login to webAppplication
		System.out.println("WebloginCar");
		System.out.println(urlname);
    }
	@BeforeMethod   //Before test is depend on testng xml file while beforemethod and beforeclass
	//is specific to class file and it is execute before every and every @Test method
	public void beforeevery()
	{
		System.out.println("I will execute before every test method in day3 class");
	}
	@AfterMethod
	public void afterevery()
	{
		System.out.println("I will execute after every test method in day3 class");
	}
	@Test(groups= {"Smoke"})
	public void MobileloginCarLogin()
	{
		//Appium
		System.out.println("MobileloginCar");
	}
	@Test
	public void MobileSigninCarLogin()
	{
		//Appium
		System.out.println("MobileSignIn");
	}
	@Test
	public void MobileSignoutCarLogin()
	{
		//Appium
		System.out.println("MobileSignOut");
	}
	@BeforeSuite
	public void BFsuite()
	{
		System.out.println("I am no.1");
	}
	@Test(dataProvider="getData")
	public void APILoginCarLoan(String username,String password)
	{
		//Rest API Automation
		System.out.println("LoginAPIHome");
		System.out.println(username);
		System.out.println(password);
	}
	@AfterClass
	public void afteclass()
	{
		System.out.println("After executing all methods in the class");
	}
	@DataProvider
	public Object[][] getData()
	{
		//1st combination-username password, good credit history
		//2nd-username password, no credit history
		//3rd- fraudelent credit history
		Object[][] data=new Object[3][2];    //multidimentional object array, 3 rows 2 values
	   //1st set
		data[0][0]="firstsetusername";
	    data[0][1]="firstpassword";
	    //columns in the row are nothing but values for that particular combination(row)
	    
	    //2nd set, no credit history
	    data[1][0]="secondsetusername";
	    data[1][1]="secondpassword";
	    
	    //3rd set
	    data[2][0]="thirdsetusername";
	    data[2][1]="thirdpassword";
	    
	    return data;
	    
	}
	@Test
	public void CarInsurance()
	{
		System.out.println("car insurance ended");
	}
}
