
public class MethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		MethodDemo d=new MethodDemo();   //Creation of object for method
		String name=d.getData();      //here we capturing string name="rahulshetty" in name variable
		System.out.println(name);
		
		methodDemo2 d1=new methodDemo2();
		d1.getUserData();
		
		String name1=getData1();   //here we use static keyword in method so no need to create object 
		
		
		//How to create method in class and how to access it
		//why methods- when we have set of line of code reuse every time we can put that code in block and when we called that block so repeating line again and again we can use this
		
		
		//But we should not create method in main block, main block is for execution
	}
	
	public String getData()    //Void means what this method written if it returns integer type int in place of void if not written anything put void
	{
		System.out.println("Hello");
		return "rahulshetty";
	}
	//Now to access method we need to create object first of that class
	
	//Can we access own class methods without creating objects we can do that in that case we need to mark method as Static then this method belong to class not object
	
	public static String getData1()  //static keyword move method to class level
	{
		System.out.println("Hello");
		return "rahulshetty";
	}
	
	//so to call that no need to use object we can call method as below in main block
	//String name1=getData1();

}
