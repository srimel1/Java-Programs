import java.util.ArrayList;

public class ArrayListPractice {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i =1; i<=10; i++) {
			list.add(10*i);
		int[] arr = {1,2,3};
		int[] arr2 = reverse(arr);
		}
		for(int i = 0; i<list.size(); i++) {
			list.remove(i);
		}
		System.out.println(list);
		
	}
	public static int[] reverse(int[] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		return arr;
	}
}
