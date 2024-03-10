package Inheritance;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChildClass extends ParentClass {
	

	@Test
	public void testRun()
	{
		int a=3;
		doThis();    //because of inheritance concept we can call method here 
		
//		ParentClass ps=new ParentClass();
//		ps.doThis();  //Another way to access method present in another class is to create object
	    SingleResponsibilityPrinciple srp=new SingleResponsibilityPrinciple(3);  //Parameterized Constructor concept
	    System.out.println(srp.increment());
	    System.out.println(srp.decrement());
	    
//	    SingleResponsibilityPrinciple2 srp2=new SingleResponsibilityPrinciple2(a);
//	    System.out.println(srp2.multiplyThree());
	    //Now after using this code we sent this code for review to senior manager, he decline it
	    //because we created two objects for multiple class we need to create multiple object
	    //is it possible to acccess multiplyThree method using srp object?
	    //yes in that case super keyword comes into picture
	    System.out.println(srp.multiplyThree());
	
	}

}
