import java.util.Scanner;
import java.util.Random;

public class lab1 {
    public static void main(String[] args) {     
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
      
        int[] randNumber = new int[100000];
                
        System.out.println("Please enter range for random numbers: ");
        System.out.println("Min:");       
        int min = input.nextInt();
        System.out.println("Max:");
        int max = input.nextInt();
 
        long start = System.currentTimeMillis();
        for (int i = 0; i < randNumber.length; i++){
            randNumber[i] = rand.nextInt(max - min + 1) + min;
        }
        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println("Time to fill array: " + time);
        
        input.close();
    }
    
}