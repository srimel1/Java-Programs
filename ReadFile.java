import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ReadFile {
	private Scanner x;
	
	public void openFile() {
		try {
			x = new Scanner(new File("Ozymandias.txt"));
			
		}
		catch(Exception e) {
			System.out.println("file not found.");
		}
	}
	public void readFile() {
		while(x.hasNext()) {
			String a = x.next();
			String c = x.next();
			String b = x.next();
//			String[] words = new String[10];
//			for(int i = 0; i<words.length; i++) {
//				words[i] = x.next();
		}
		}
	public void closeFile() {
		x.close();
		
	}
	}

//		HashMap<String, Integer> map  = new HashMap<String, Integer>();
//		
//		int total = 0;
//		for(String w : fr.words()) {
//			w=w.toLowerCase();
//			total += 1;
//			if(map.keySet().contains(w));
//			map.put(w,  map.get(w)+1);
//		}else{
//			map.putAll(w,1);
//		}
//		}
//	for(String w : map.keySte());{
//		int occurences = map.get(w);
//		if(occurences>500) {
//			System.out.println(occurences +"\t"+w);
//		}
//	}

