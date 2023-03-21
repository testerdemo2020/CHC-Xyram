package cPSetTest;

public class FindDuplicate {

	public static void main(String[] args) {

		String sentense = "Ashish";
		String characters = "";
		String duplicates = "";
		for(int i=0;i<=sentense.length()-1;i++) {

			String current = Character.toString(sentense.charAt(i)); //Char to string conversion using wrapper class
			if(characters.contains(current)){ 		//Condition to check the duplicate char
			if(!duplicates.contains(current)) {		
					duplicates = duplicates + current + ",";
				}

			}
			characters = characters + sentense.charAt(i);			

		}
		System.out.println("duplicates char in the given string is :- "+duplicates);

	}

}
