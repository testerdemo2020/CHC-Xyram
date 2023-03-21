package cPSetTest;

import java.util.Scanner;


/*Logic :- 
number = 12345; reverse = 0;
reminder = 12345%10 = 5
reverse = reverse*10 + reminder = 0*10 + 5 = 5;
number = 12345/10=1234

number = 1234; reverse = 5;
reminder = 1234%10 = 4
reverse = reverse*10 + reminder = 5*10 + 4 = 54;
number = 1234/10=123

number = 123; reverse = 54;
reminder = 123%10 = 3
reverse = reverse*10 + reminder = 54*10 + 3 = 543;
number = 123/10=12

number = 12; reverse = 543;
reminder = 12%10 = 2
reverse = reverse*10 + reminder = 543*10 + 2 = 5432;
number = 12/10=1

number = 1; reverse = 5432;
reminder = 1%10 = 1
reverse = reverse*10 + reminder = 5432*10 + 1 = 54321;
number = 1/10=0

*/


public class ReverseNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number:- ");
		int number = sc.nextInt();
		int reverse = 0;
		
		//Recursive method calling
		ReverseTheNumber(number);
		
// First using While loop
		
		while(number!=0) {
			
			 int reminder = number%10;
			 reverse = reverse*10+reminder;
			 number=number/10;
		}
		System.out.println("Reverse number is for given numbers:- "+reverse);
		
// Second using for loop		
		
		for( ;number != 0; number=number/10)   
		{  
		int remainder = number % 10;  
		reverse = reverse * 10 + remainder;  
		}  
		System.out.println("The reverse of the given number is: " + reverse);  
		
// Using recursion 
			
	}
	
	public static void ReverseTheNumber(int number) {
		
		if(number<10) {
			
			System.out.println(number);
			return;
		}
		else {
			System.out.print(number%10); //Print the reverse number
			
			ReverseTheNumber(number/10);  //Recursive method
		}
		
	}

}
