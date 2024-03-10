
public class CoreJavaConcept3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String Operations
		//String is a object represent sequence of characters
		//Creating String using string literals
		//String s="Rahul Shetty Academy";
		//String s1="Rahul Shetty Academy"; //here both string text is same in backend only one object is created
		//Another way of creating String
		String s2= new String("Welcome");
		String s3=new String("Welcome");  //here 2 object are created when we create new keyword it will create new object every time in memmory
		
		String s="Rahul Shetty Academy";  //let we want to break this string into 3 pieces
		String[] splittedString=s.split(" ");          //As we braking string it will conver it into array
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		
		//let we want to split based on shetty
		System.out.println("************");
		String[] splittedString1=s.split("Shetty");
		System.out.println(splittedString1[0]);
		System.out.println(splittedString1[1]); //here some white spaces coming before academy to remove that we have trim() method
		System.out.println(splittedString1[1].trim());
		
		//let we want to print characters
		for (int i=0;i<s.length();i++)
		{
			System.out.println(s.charAt(i));      //it will give character present at index
		    
			//Q print string in reverse order
			//for that use for(int i=s.length()-1;i=0;i--)
			
			
		
		}
	}

}
