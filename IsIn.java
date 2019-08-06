
public class IsIn {
	
	public static boolean isIn(String s) {
		String temp = null;
		if(s!=null) {
			do {
				if(s.contains("ABB")==true) {
					 temp = s.replace("ABB", "");
					isIn(temp);
				}
			
		}while(isIn(temp)==true);
		return true;
	}else
		return false;

	}
	public static void main(String[] args) {
		String s = "ABBABB";
		System.out.println("Stephanie");
		System.out.println(isIn(s));
	}
}
