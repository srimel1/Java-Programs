public class StaticClient{
		public static void main(String[] args) {
			StaticEx s1 = new StaticEx();//point 1
			System.out.println(s1.getCount()+"s1p1");
			System.out.println(StaticEx.getCount() + "exp1");
			System.out.println(StaticEx.getCount());
			System.out.println();
			
			
			StaticEx s2 = new StaticEx();//point 2
			System.out.println(s1.getCount()+"s1p2");
			System.out.println(StaticEx.getCount() + "exp2");
			//System.out.println(s2.getCount() + "s2p2");
			System.out.println();
			
			StaticEx s3;//point 3
			System.out.println(s1.getCount()+"s1p3");
			System.out.println(StaticEx.getCount() + "exp3");
			//System.out.println(s2.getCount() + "s2p3");
			StaticEx s4 = new StaticEx();
			System.out.println(s4.getCount());
			
			System.out.println(StaticEx.getCount());
			
			
		}
	}