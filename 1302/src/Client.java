
public class Client {

	public static void main(String[] args) {
		Foo[] pity = {new Baz(), new Bar(), new Mumble(), new Foo()};
		Bar b1 = new Bar();
		Mumble m = new Mumble();
		System.out.println("mumble  "+ m.toString());
		System.out.println(" to string " +b1.toString());
	
		System.out.print("pity 2 ");
		pity[2].method1();
		pity[2].method2();
		pity[1].toString();
		System.out.println();
		System.out.println();
		for(int i = 0; i<pity.length; i++) {
			System.out.println(pity[i]);
			pity[i].method1();
			pity[i].method2();
			System.out.println();
		}
	}
}
