import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaConcept2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		int [] arr2= {1,2,4,5,6,7,8,9,10,122};
		// check array multiples by 2 
		for(int i=0;i<arr2.length;i++)
		{
			if(arr2[i]%2==0)
			{
			System.out.println(arr2[i]);
		    }
			else {
				System.out.println( arr2[i] +"is not multiple of 2");
			}
		
	   	
	   }
		//Arraylist- in array we initialize size at beginning so we can't increase size latter so it's static array to increase size of array latter we can use arraylist called dynamic array
		//ArrayList a= new ArrayList();
		//create object of class- object .method
	    //lets arraylist storing string value
		ArrayList<String> a=new ArrayList<String>();
		a.add("Rahul");
		a.add("shetty");
		a.add("academy");
		a.add("selenium");
		//a.remove(2);
		System.out.println(a.get(2));//extract 2th value

		for(int i=0;i<a.size();i++)    //for arraylist we are using .size() method
		{
			System.out.println(a.get(i));
		}
		
		System.out.println("**************");
		
		//Enhanced for loop
		for(String val:a)
		{
			System.out.println(val);
		}
		
		//Get to know any item present in arraylist
		System.out.println(a.contains("selenium"));
		String[] name = {"rahul", "shetty", "selenium"};
		//Let's see how to use .contains method to traditional array
		List<String> nameArrayList=Arrays.asList(name);    //Array.asList convert traditional array to arrayList
	    nameArrayList.contains("selenium");
	}
}