import java.util.Arrays;

public class ArrayMystery {

	public static void main(String[] args) {
		int[] a = {1,7,5,6,4,14,11};
		
		System.out.println(Arrays.toString(a));
		for(int i = 0; i < a.length-1; i++) {
			System.out.println(a[i] +">? " + a[i+1]+" "+ a[i+1]*2 );
			if(a[i]>a[i+1]) {
				
				a[i+1] = a[i+1]*2;
				System.out.println(Arrays.toString(a));
			}
		}
	}
}
