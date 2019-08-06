import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, Double> taGpa = new HashMap<String, Double>();
		taGpa.put("Jared",  3.6);
		taGpa.put("Alyssa",  4.0);
		taGpa.put("Steve",  2.9);
		taGpa.put("Stef",  3.6);
		taGpa.put("Rob",  2.9);
		System.out.println(taGpa.toString());
		
		System.out.println(taGpa.toString());
		for(String name : taGpa.keySet()) {
			double gpa = taGpa.get(name);
			System.out.println(name +" : " + gpa);
			
			Set<Integer> scores = new TreeSet<Integer>();
			scores.add(94);
			scores.add(38);
			scores.add(87);
			scores.add(43);
			scores.add(72);
			Iterator<Integer> itr = scores.iterator();
			System.out.println("itr"+itr.toString());
			while(itr.hasNext()) {
				int score = itr.next();
				System.out.println("The score is " + score);
				//to eliminate the failing grades
				if(score < 60) {
					itr.remove();
				}
			}
			System.out.println(scores);
			
		}
		
	}
}
