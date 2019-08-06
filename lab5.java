import java.util.Arrays;
import java.util.Random;

public class lab5 {
	
	//insert new number at beginning and move others down 
	public static String insertBeg(int[] array, int v){
		int[] newArr = Arrays.copyOf(array, array.length);
		
		for(int i = newArr.length-1; i > 0; i--){
			newArr[i] = newArr[i-1];
		}
		newArr[0] = v;
		System.out.println("insertBeg");
		return toString(array, newArr);	
	}
	
	//insert new number at end and move others up
	public static String insertEnd(int[] array, int v){
		int[] newArr = Arrays.copyOf(array, array.length);
		
		for(int i = 0; i < newArr.length-1; i++){
			newArr[i] = newArr[i+1];
		}
		newArr[newArr.length-1] = v;
		
		System.out.println("insertEnd");
		return toString(array, newArr);
	}
		
	//insert new number at new index, make bigger array
	public static String insertIndex(int[] array, int p, int v){
		int[] newArr = Arrays.copyOf(array, array.length+1);
		
		for(int i = 0; i < p; i++){
			newArr[i] = newArr[i];
		}
		newArr[p] = v;
		for(int i = (p+1); i < newArr.length; i++){
			newArr[i] = newArr[i];
		}
		
		System.out.println("insertIndex");
		return toString(array, newArr);
	}
	
	//reverse original array
	public static String reverse(int[] array){
		int[] newArr = Arrays.copyOf(array, array.length);
		
		for(int i = 0; i < newArr.length/2; i++){
		
			int temp = newArr[i];
			newArr[i] = newArr[newArr.length-1-i];
			newArr[newArr.length-1-i] = temp;
		}
		
		System.out.println("reverse");
		return toString(array, newArr);
	}
	
	//print out each array
	public static String toString(int[] array, int[] array1){
		return "The Original Array: " + Arrays.toString(array) + "\nNew Array: "+ Arrays.toString(array1);
		
	}
	
	public static void main(String[] args){
		
		Random r = new Random();//random value 1-10
		int[] arr = new int[5];
		int v = 42;
		int p = 5;
		
		//populate array with random integers
		for(int i = 0; i < arr.length; i++){
			arr[i] = r.nextInt(10)+1;
		}
		
		System.out.println(insertBeg(arr,v) + "\n");
		System.out.println(insertEnd(arr,v) + "\n");
		System.out.println(insertIndex(arr,p,v) + "\n");
		System.out.println(reverse(arr) + "\n");
	
	
	}
	
}