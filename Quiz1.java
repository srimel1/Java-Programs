import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/***
 * 
 * @author Stephanie Rimel
 * Quiz one: this is a demonstration of the LinkedList and recursion.
 * There is a populate method, that populates the list with random integers.
 * There is a size method, that counts the number of elements in the list recursively and returns the count.
 *
 */
public class Quiz1 {
	public static void main(String[] args) {
		LinkedList<Integer> nodes = new LinkedList<Integer>();
		System.out.println("LinkedList, before populate method: "+nodes.toString());
		System.out.println("Number of elements before populate method: "+ countsize(0,nodes));
		populate(nodes, 25);
		System.out.println("LinkedList: "+ nodes.toString());
		System.out.println("Number of elements in LinkedList: "+ countsize(0,nodes));
	}

	/***
	 * 
	 * @param a : the linked list ot populate
	 * @param length : the length of the list to populate
	 */

	public static void populate(LinkedList<Integer> a, int length) {
		Random rand = new Random();
		// add method
		for(int i = 0; i < length; i++) {
			int num = 1 + rand.nextInt(15);
			a.add(i,num);
		}
	}
	/***
	 * 
	 * @param index, the index that you wish to start the count from
	 * @param ll, the linked list
	 * @return the number of elements in the list using recursion
	 */
	
	public static int countsize(int index, LinkedList<Integer> ll) {
	    Iterator<Integer> next = ll.listIterator(index);  
	    if (!next.hasNext())
	        return index; 
	    return countsize(index + 1,  ll);
	}

}
