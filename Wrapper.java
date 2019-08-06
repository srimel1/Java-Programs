import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Wrapper {
	
	public int value;
	
	File file = new File("out.txt");
	public Wrapper(int value){
		 
	        this.value = value;
	    
	       
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("out.txt"));	
	
	HashMap<String, Wrapper> counts = new HashMap<String, Wrapper>();
	
	while(scanner.hasNext())
	{
	    String token = scanner.next();
	    Wrapper count = counts.get(token);
	    if(count == null)
	    {
	        counts.put(token, new Wrapper(1));
	    }
	    else
	    {
	        ++count.value;
	    }
	}
	scanner.close();
}

}


