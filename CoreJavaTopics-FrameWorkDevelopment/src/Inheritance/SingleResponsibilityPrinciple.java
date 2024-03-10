package Inheritance;

public class SingleResponsibilityPrinciple extends SingleResponsibilityPrinciple2 {

	//If we think some utilities can be reuse in multiple test its best to put them in 
	//Seperate class instead of writing logic in single test called this as single Responsibility Building principle
	
	int a;    //class variable
	public SingleResponsibilityPrinciple(int a) {   //int a-instance variable and scope of this variable is just inside the block only
		// TODO Auto-generated constructor stub
		super(a);      // parent class constructor will invoke
		this.a=a;    //this.classvariable=instancevariable,
	
	}
	public int increment()
	{
		a=a+1;
		return a;
	}
	public int decrement()
	{
		a=a-1;
		return a;
	}
}
