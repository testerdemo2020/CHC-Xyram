package Selenium.Test;

public class sdfasdf {

	public static void main(String[] args) {
		
		String str = "Ashish Kumar Chaurasia";
		String[] data = str.split(" ");
		String x = data[0];
		String y = data[1];
		String z = data[2];
		
		System.out.println("First char value :- "+x);
		System.out.println("Second char value :- "+y);
		System.out.println("Third char value :- "+z);
		
		char p = str.charAt(5);
		System.out.println("charat value :- "+p);
		boolean b = str.endsWith(z);
		System.out.println("comparre :- "+b);
	}

}
