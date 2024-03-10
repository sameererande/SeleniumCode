package Inheritance;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class ParentClass {

		// TODO Auto-generated method stub
   //Inheritance means we can acquire the properties of parent class.
		//When we want to access methods, variable declared in parent class into another class we need to use keyword 
		//extends and then provide class name from where we want to acess.
		
	public void doThis()
	{
		System.out.println("I am here");
	}
	@BeforeMethod     //In child class this method is also inherited and run also
	public void beforeRun()
	{
		System.out.println("Run me first");
	}
	@AfterMethod
	public void afterRun()
	{
		System.out.println("Run me last");
	}
	

}
