import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set<Double> grades = new HashSet<Double>();
		grades.add(91.5);
		grades.add(20.6);
		grades.add(41.3);
		grades.add(86.0);
		grades.add(90.3);
		grades.add(80.5);
		grades.add(76.5);
		
		System.out.println(grades.toString());
		Iterator<Double> itr = grades.iterator();
		while(itr.hasNext()) {
			Double score = itr.next();
			
			System.out.println("itr "+score);
		
		if(score < 60) {
			itr.remove();
		}
		}
		System.out.println(grades.toString());
		for(double grade : grades) {
			System.out.println("Students grade: " + grade);
		}
	}

}
