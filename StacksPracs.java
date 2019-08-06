
public class StacksPracs {

	public static void mystery(int n) {
		StackInterface s = new StackReferenceBased();
		
		while(n>0) {
			s.push(n%8);
			n=n/8;
		}
		while(!s.isEmpty()){
			System.out.println(stack.pop());
			System.out.println();
		}
	}
}
