package cPSetTest;
//Use of static method in java class
public class InstanceCounter {
	
	private static int numIntances = 0;
	protected static int getCount() {
		
		return numIntances;
		
	}
	
	private static void addIntance() {
		
		numIntances++;
		
	}
	
	InstanceCounter(){
		
		InstanceCounter.addIntance();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Starting with "+InstanceCounter.getCount()+" instances");
		
		for(int i=0;i<500;i++) {
			
			new InstanceCounter();
			
		}
		System.out.println("Created " + InstanceCounter.getCount() + " instances");
	}
	

}
