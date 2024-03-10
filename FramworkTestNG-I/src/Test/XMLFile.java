package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XMLFile {

@Test(groups= {"Smoke"})
public void PersonalLoan()
{
	System.out.println("Loan");
}
@BeforeTest          //Means before test we have some prerequites ,whatever method we are defining here 
 public  void prerequiste()   //That will execute first before any test belonging to that folder
 {
	 //Before executing any class file from test folder this particular annotation will executed
	//We can write all database cleaning operations here or delete the data
	System.out.println("I will execute first");
 }
}
