import java.util.ArrayList;

public class Mystery {
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for(int i = 1; i<=10; i++){
//			list.add(10*i);
//			}
//		System.out.println(list);
//		for(int i = 0; i < list.size(); i++) {
//			list.remove(i);
//		}System.out.println(list);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i<=5; i++) {
			list.add(2*i);
		}//[2,4,6,8,10]
		System.out.println(list);
		int size = list.size();
		for(int i = 0; i < size; i++) {
			list.add(i,42);
		}// will add 42 in the first for spaces and then move the rest of the array to the right
		System.out.println(list); // [42,42,42,42,42,2,4,6,8,10]
			
		}
}
