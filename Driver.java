public class Driver {

	public static void main(String[] args) {

		Child c = new Child(1,3,4,5);

		Mother m = new Mother(6,7);

		System.out.println(c.getValueC());

		System.out.println(m.getValueA());

		System.out.println(c.Add(8, 4, 1));

		System.out.println(m.Add(8, 4, 1));

		c.setValueA(1);

	}

}