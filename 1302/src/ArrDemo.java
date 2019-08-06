import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrDemo {

	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7,8};
		System.out.println(Arrays.toString(arr));
		//Collections.reverse(Arrays.asList(arr));
		//System.out.println(Arrays.toString(arr));
		reverse(arr);
		System.out.println(Arrays.toString(arr));
		
		
		
//		for(int i = 0; i< arr.length/2; i++) {
//			int temp = arr[i];
//			arr[i] = arr[arr.length -1 - i];
//			arr[arr.length - 1 - i] = temp;
//			
//		}
//		
//		System.out.println(Arrays.toString(arr));
//		
		String[] typesOfInsurance = {"Life Insurance", "Car Insurance", "Health Insurance"};
	      System.out.println("array before reverse: " + Arrays.toString(typesOfInsurance) );
	      List<String> listOfProducts = Arrays.asList(typesOfInsurance);      
	      Collections.reverse(listOfProducts);
	      String[] reversed = listOfProducts.toArray(typesOfInsurance);
	      System.out.println("array after reverse: " + Arrays.toString(reversed) );



	}

	public static Integer[]  reverse(Integer[] arr) {
		Collections.reverse(Arrays.asList(arr));
		return arr;
	}

	
	
		
		
}
