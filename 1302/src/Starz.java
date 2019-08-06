
public class Starz {

	public static void main(String[] args) {
		for(int i = 10; i>0; i--) {
			for(int j = 1; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		int x =18;
		
		if((x++>=19) &&(++x<65))x++;
		System.out.println(x);
		x=4;
		while(x<=200)
			x*=2;
		System.out.println(x);
		System.out.println(5+5+"23.0"+5+2*5);
		int i = 39;
		System.out.println(i);
		while(i>= 6) {
			i-=3;
			System.out.println(i);
			int[] arr = {1,2,4,5,6,6,7,8,9};
			
		}
	
	
	}
	public static int countDigits(int n) {
		int count = 0;
		while( n> 0){
			n=n/10;
		count++;
	}
	return count;
}
}
//		
//		for(int i = 0; i<10; i++) {
//			for(int j = 10; j>i; j--) {
//				System.out.print("*");
//				
//			}
//			System.out.println();
//		}
