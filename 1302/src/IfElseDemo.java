
public class IfElseDemo {

	public static void main(String[] args) {
		int x = 0;
		if(x>0) {
			System.out.println("positive");
		}else if(x<0) {
			System.out.println("negative");
		}else {
			System.out.println("0");
		}
		
		int place = 3;
		if(place == 1) {
			System.out.println("gold");
		}else if(place == 2) {
			System.out.println("silver");
		}else if(place == 3) {
			System.out.println("bronze");
		}
	}
}
