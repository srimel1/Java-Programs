import java.util.LinkedList;

public class SantasList {
	
	//initialize 2 lists to store the nice and naughty
	public static LinkedList<Kids> niceList = new LinkedList<Kids>();
	public static LinkedList<Kids> naughtyList = new LinkedList<Kids>();
	
	//method to add a kid to a list depending on naughty or nice status
	public static void addKid(Kids k) {
		
		if(k.type.equals("nice")) {
			
			niceList.add(k);
			
		}else if(k.type.equals("naughty")) {
			
			naughtyList.add(k);
			
		}
	}
	/***
	 * the following methods print the nice and the naughty lists.
	 */

	public static void printNice() {
		
		System.out.println("Nice List");
	
		for(int i = 0; i < niceList.size(); i++) {
			
			Kids temp = niceList.get(i);
			
			System.out.println(i+1 + ": " + temp.name);
			
		}
	
	}
	public static void printNaughty() {
		
		System.out.println("Naughty List");
		
		for(int i = 0; i < naughtyList.size(); i++) {
			
			Kids temp = naughtyList.get(i);
			
			System.out.println(i+1 + ": " + temp.name);
		}
	}
	/***
	 * main method to test methods and implementation
	 */
	public static void main(String[] args) {
		Kids steph = new Kids("nice" , "Stephanie");
		Kids josh = new Kids("naughty" , "Josh");
		Kids brian = new Kids("naughty" , "Brian");
		Kids brady = new Kids("naughty" , "Brady");
		Kids ian = new Kids("nice" , "Ian");
		
		//LinkedList<Kids> naughty = new LinkedList<Kids>();
		//LinkedList<Kids> nice = new LinkedList<Kids>();
		

		addKid(steph);
		addKid(brian);
		addKid(josh);
		addKid(brady);
		addKid(ian);

		printNice();
		printNaughty();
		
		
	}
}
