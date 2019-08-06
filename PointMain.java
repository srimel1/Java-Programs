
public class PointMain {

	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point();
		System.out.println("to x coord is "+p1.x) ;
		p2.y=13;
		System.out.println(p2.y);
		p2.x+=2;
		p2.y++;
		System.out.println(p2.y);
		System.out.println(p2.x);
	}
}
