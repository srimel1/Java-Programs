import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Words {
	public static void main(String[] args){
		ArrayList<String> allWords = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
//		for(int i = 0; i< 2; i++) {
//			System.out.println("Please enter a word: ");
//			String word = input.next();
//			allWords.add(word);
//		}
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(87);
		numbers.add(45);
		numbers.add(600);
		numbers.add(118);
		numbers.add(12);
		numbers.add(3);
		System.out.println(numbers);
		//filterEvens(numbers);
		int[] arr = {1,4,6,9};
		System.out.println("before reverse: " + Arrays.toString(arr));
		Collections.reverse(numbers);
		System.out.println(numbers);
		//System.out.println(allWords);
//		for(int i = 0; i<allWords.size(); i++) {
//			String word = allWords.get(i);
//			if(word.endsWith("s")) {
//				allWords.remove(i);
//				i--;
//			}
		//removePlural(allWords);
		//System.out.println(allWords);
		allWords.contains("a");
		
//		allWords.size();
//		allWords.lastIndexOf(word);
	//ArrayList<String> c = new ArrayList<String>();
	//c.addAll(allWords);
	
//	c.add("books"); c.add("car"); c.add("my"); c.add("name");c.add("is");c.add("Stephanie");
	
//		allWords.containsAll(c);
//		allWords.equals(c);
//		allWords.iterator();
//		allWords.remove(0);
	
		}	
		
	
	public static void removePlural(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			if(str.endsWith("s")) {
				list.remove(i);
				i--;
			}
		}
	}
	public static void filterEvens(ArrayList<Integer> list) {
		for(int i = list.size()-1; i>=0; i--) {
			int n = list.get(i);
			if(n%2==0) {
				list.remove(i);
			}
		}
	}
	public static void reverse(ArrayList<Integer> list) {
		for(int i = list.size()-1; i< list.size()/2; i++) {
			
		}
	}
	public static void reverseArr(int[] array) {
		for(int i=0; i<array.length/2; i++){
			  int temp = array[i];
			  array[i] = array[array.length -i -1];
			  array[array.length -i -1] = temp;
			}



	}
}
