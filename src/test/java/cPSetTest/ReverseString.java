package cPSetTest;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the string:- ");
		String string = sc.nextLine();
		String r = reverse(string);
		System.out.println("Reverse string is :- "+r);
	}

	public static String reverse(String s) {

		char[] letters = new char[s.length()]; 

		int letterIndex=0;
		for(int i=s.length()-1;i>=0;i--) {   //First for loop for storing string into Char[] array with last to first
			letters[letterIndex] = s.charAt(i);
			letterIndex++;
		}
		String reverse="";
		for(int i=0;i<s.length();i++) { //Second for loop for arranging string in order

			reverse = reverse+letters[i];

		}
		return reverse;

	}

}
