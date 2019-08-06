import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Course {
	private double[] grades;
	private ArrayList<String> studentNames;
	
	public Course() {
		grades =new double[4];
		studentNames= new ArrayList<String>();
		//now each object stores a collection of data inside it
	}
	public static void main(String[] args) {
		String a = "alice";
		String b = "bob";
		if(a.compareTo(b)<0) {
			System.out.println("true"); //it is true because a is to the left of b.
	}else {System.out.println("false");
	
	}
		String[] a1 = {"al", "bob", "cari", "dan", "mike"};
		int index = Arrays.binarySearch(a1, "dan");
		System.out.println(index);
		
		Set<String> set = new TreeSet<String>();
		for(String s : a1) {
			set.add(s);
		}
	}
}
