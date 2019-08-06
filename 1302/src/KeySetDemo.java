import java.util.Map;
import java.util.TreeMap;

public class KeySetDemo {
	public static void main(String[] args) {
		Map<String, Integer> ages = new TreeMap<String, Integer>();
		ages.put("Marty", 19);
		ages.put("Geneva", 2);
		ages.put("Vicky", 57);
		System.out.println(ages.toString());
		for(String name : ages.keySet()) { // ages.keySet() returns  Set<String>
			int age = ages.get(name);
			System.out.println(name + " -> " + age);
		}
	}

}
