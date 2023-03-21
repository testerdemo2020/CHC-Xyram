package cPSetTest;

public class FirstLetterCap {

	public static void main(String[] args) {

		String s = "hello world";
		String result = s.substring(0, 1).toUpperCase() + s.substring(1); 
		// Substring method to capture the indexing	based value and change to upper case and concate with remaining string
		System.out.println(result);
		
	}

}
