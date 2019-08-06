
public class Practice {
	String n = null;
	public static void main(String[] args) {
		String s = "AABBBBB";
		System.out.println(isIn(s));
	}
	public static boolean isIn(String n){
			if(n.charAt(0)=='A' && n.charAt(1)=='A' && n.charAt(n.length()-1)=='B') {
				return isIn(n.substring(2, n.length()-1));
			}else if(n.length()==0|| n.isEmpty()) {
				return true;
			}
			return false;
	}
}


