package cPSetTest;

public class ReverseString1 {

	public static void main(String[] args) {
		
		String name = "dog";
		String reverse = "";//Stores the reverse of given string
		
		
		//Iterate through the string from last and add each character to variable reversedStr 
		for(int i = name.length()-1;i>=0;i--) {
			
			reverse = reverse + name.charAt(i);
			
		
		}
		

	}

}
