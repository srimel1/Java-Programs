import java.util.Arrays;

public class ArrayMystery2 {

	public static void main(String[] args) {
		int a[] = {-1,6,3,5,-3
				};
		for(int i = 1; i<a.length-1; i++) {
			
//			System.out.println("a["+i+"] = " +a[i]);
//					System.out.println("a["+i+"-1] ="+a[i-1]);
//					System.out.println("a["+i+"+1]="+a[i+1]);
					a[i] = (a[i-1]+a[i+1]/2);
			System.out.println(Arrays.toString(a));
		}
	}
}
