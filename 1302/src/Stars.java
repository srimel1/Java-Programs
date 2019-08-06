import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stars {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("the"); list.add("quick");
		list.add("brown");
		list.add("fox");
		System.out.println(list.toString());
		reverse(list);
		System.out.println(list);
		
		//REVERSES THE LIST!!!!!
		Collections.reverse(list);
		
		for(int i = 1; i < list.size(); i+=2) {
			list.add(i,"*");
		}
		System.out.println(list.toString());
		for(int i = 1; i < list.size(); i++) {
			list.remove(i);
		}
		System.out.println(list.toString());
		
		Integer[] intArray = {1,4,8,9,11,15,28,41,59};
		Integer[] intArray2 = {4,7,11,17,19,20,23,28,37,59,81};
		List<Integer> intList = new ArrayList<Integer>(intArray.length);
		List<Integer> intList2 = new ArrayList<Integer>(intArray2.length);
		for(int i=0; i<intArray.length; i++) {
			intList.add(intArray[i]);
			intList2.add(intArray[i]);
		}
		intList.toString();
		intList2.toString();
		intList.retainAll(intList2);
		System.out.println(intList.retainAll(intList2));
			
		}
	

		public static void reverse(ArrayList<String> list) {
			
		Collections.reverse(list);
	}
}

