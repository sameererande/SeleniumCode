package Test;

import org.testng.annotations.Test;

public class day4 {
   //Lets assume we have car loan application so we have login module 
	//Lets we have 3 type of Test cases 
	@Test
	public void WebloginHomeLoan()
	{
	
		//Selenium code to login to webAppplication
		System.out.println("WebloginHome");
    }
	@Test(groups= {"Smoke"})
	public void MobileloginHomeLogin()
	{
		//Appium
		System.out.println("HomeloginCar");
	}
	@Test(dependsOnMethods= {"WebloginHomeLoan"})
	public void APILoginHomeLoan()
	{
		//Rest API Automation
		System.out.println("LoginAPIHome");
	}
	@Test(enabled=false)       //if enabled =false it will not execute
	public void EnabledTest()
	{
	System.out.println("Enabled");	
	}
	@Test(timeOut=4000)   //Wait till 40 sec
	public void Timeout()
	{
		System.out.println("This is timeout");
		
	}
	
}
