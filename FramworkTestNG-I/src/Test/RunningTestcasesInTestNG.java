package Test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RunningTestcasesInTestNG {


		// TODO Auto-generated method stub

		//If we incorporate TestNG framework in TestNG library into your testcases so we donot depend upon java
		//compiler testNG itself act as java compiler and execute all testcases in that case we didn't need main block.
		//TestNG is depend upon Java in backend but from fronend we didn't need to write all
		//Java things.so lets delete main block and try with testng
		//The simple way to do it with TestNG is 
		//Create one method first ,TestNG needs all its teststep execution in a method
	    //If we print anything inside method this will also not execute because we are 
	//not given enough information. first we need to write @Test annotation before method and import TestNG library and then run 
	
	//Whatever methods follows @Test annotation will treated as Testcase by testng and run the program
    @AfterTest
    public void lastexecution()
    {
    	System.out.println("I will execute at last");
    	
    }
	
	@Parameters({"URL","APIKey/username"})
	@Test	
	public void Demo(String uname, String key)
	{
		System.out.println("hello"); 
		System.out.println(uname);
		System.out.println(key);
	}
	//whenever we write @Test annotation testNG treate it as testcase but when we create 
	//Annotation 
	@Test
	public void SecondTest()
	{
		System.out.println("Bye");
		Assert.assertTrue(false);
	}
	//We can define multiple tests from single class
	//We can triggle all test cases from xml file and that is heart of TestNG
	
	@AfterSuite
	public void afsuite()
	{
		System.out.println("I am the last");
	}

}
