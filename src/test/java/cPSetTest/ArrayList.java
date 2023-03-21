package cPSetTest;

import java.util.Collection;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ArrayList {

	@Test

	public void arrayList() {

		Collection<String> str = new java.util.ArrayList<String>();
		java.util.ArrayList<String> string = new java.util.ArrayList<String>();

		string.add("A");
		Assert.assertEquals(1, string.size());
		Assert.assertEquals(0, str.size());
		System.out.println("Array Size is- "+string.size());

	}

	@Test

	public void arrayListFilled() {

		java.util.ArrayList<String> string = new java.util.ArrayList<String>();
		fillList(string,10);
		//Assert.assertEquals(10, string.size());
		Assert.assertEquals(10, string.size());


	}

	private void fillList(java.util.ArrayList<String> string, int i) {
		for(int x=0;x<i;i++) {
			string.add("String"+x);
		}
		
	}

}
