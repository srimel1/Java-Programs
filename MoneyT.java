
public class MoneyT {
	public static void main(String[] args) {
		int[] arr = {3,2,1};
		System.out.println(Integer.MIN_VALUE);
		System.out.println(value(arr));
		double sum = sum(1,18);
		System.out.println(sum);
	}
	public static int value(int[] arr) {
		return Integer.MAX_VALUE;
	}
	public static int sum(int start, int end) {
		if(start == end) {
			return end;
		}else {
			return sum(start,end-1)+end;
		}
	}

}
