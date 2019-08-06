import java.lang.reflect.Array;
import java.util.Arrays;

public class Matrix1 {
	public static void main(String[] args) {
		int[] a, b;
		int c, d[];
		
		
		int[][] matrix = new int[4][12];
		System.out.println(" elements (a.length * a[0].length) = "+ (matrix.length * matrix[0].length));
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				
				matrix[i][j] = (int) (Math.random()*10);
				
			}
		}
		 for (int[] row : matrix) {
			    System.out.println("Printed array \n" +Arrays.toString(row)+"\n\n");
	     }
		 System.out.println("percent even "+percentEven(matrix));
	}
	public static double percentEven(int[][] arr) {
		double count = 0;
		double percent = 0;
		double temp=0;

		for (int i=0;i<arr.length;i++) {
		    for (int j=0;j<arr[i].length;j++) {
		        if(arr[i][j] % 2 == 0) {
		        	count++;
		        	temp = (arr.length * arr[0].length);
		        	
		        	
		        }}	
		  
		            
		
		            
		        
		    
		    
		
		//percent = count/Math.pow(arr.length, 2)*100;
		        }
		return count/(arr.length * arr[0].length);
		
		
		

		
  

		
		    
		
		}
	public static double getAverage(int[][] a)
	{
	   double total = 0;
	   for (int row = 0; row < a.length; row++)
	   {
	       for (int col = 0; col < a[0].length; col++)
	       {
	          total = total + a[row][col];
	       }
	   }
	   return total / (a.length * a[0].length);
	}
	
	
}
