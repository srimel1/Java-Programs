/*ArrayList.java that creates an ArrayList data structure that is similar to the 
 * 		ArrayList data Structure that exist in the java library. The class must be 
 * 		written to accept any type of Objects.
 * 		Methods:  2 constructors: create an ArrayList object with a 
 * 		default size of 10 ------ public ArrayList(); and one that will 
 * 		allow you to determine the size of the ArrayList(int n);. Two add
 * 		methods: one that will allow you to add the end of the list, and 
 * 		another where you can specify which index to add too. One method
 * 		will allow the retrieval of the object at a certain index. Another
 * 		method gives the size of the list. One method will remove a value 
 * 		from the method. Two Boolean method arrays; one two show if the array
 * 		is empty and the other will show if an object is in the list.
 * 		Then write a driver program that utilizes a Card class, and fill an 
 * 		"ArrayList" with the Card objects, then write a method to shuffle card
 * 	 	objects. Show that methods from the ArrayList class work.
 * 
 * Solution and Algorithms: 
 * 		The driver program uses a for loop to load the Array list with card objects
 * 		It then used the shuffle method to shuffle the ArrayList objects in it's array, 
 * 		which uses a random generated number for an index to place a random object into.
 * 		
 * Data Structures: Arrays
 * 
 * Expected Input/Output
 * 		Input would be objects into the ArrayList, and the expected output would be
 * 		an array full with the objects, printed to the screen.
 * 
 */

public class testarray {
	public static void main(String[] args) { //main class
		ArrayList deck = new ArrayList();

		String [] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
		
		for (int j = 0; j < 4; j++){					//suits
			for (int k = 1; k <= 13; k++){				//card rank
				deck.add(new Card(k, suits[j]));
			}
		}
		
		System.out.println("Original deck: ");
		System.out.println(deck.toString());
		
		System.out.println("\nShuffled Deck: ");
		deck.shuffle();									//shuffle written into the ArrayList class
		System.out.println(deck.toString());
		
		System.out.println("Object at ArrayList index 2: " + deck.get(2));
		
		Object card = deck.get(7);
		System.out.println("Deck Array Size: " + deck.size());
		System.out.println("Is the ArrayList empty? " + deck.isEmpty());
		System.out.println("Does the object exist in the ArrayList? " + deck.isIn(card));
		System.out.println("Removing object from the ArrayList.");
		deck.remove(card);
		if(deck.find(card) == -1){
			System.out.println("Object is no longer in in the ArrayList.");
			System.out.println("Deck Array Size: " + deck.size());
		}
		
//		System.out.println("Where is the object with the array Index: " + deck.find(deck.get(7)));
		
	}//end of main
}
