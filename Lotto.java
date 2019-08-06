import java.util.Scanner;

import java.util.*;
public class Lotto {
    public static void main(String[] args) {
    String[] nums = new String[1000];
    Scanner s = new Scanner(System.in);
        System.out.println("Enter A Random String Of 5 Letters And Numbers to Play The Lottery,\nfor example: A56C3T... ");
        String ticket = s.nextLine().toUpperCase();
        System.out.println(ticket);
        for(int i = 0; i<1000; i++){
           
            nums[i] = generate(
                           "GHIJKLMNOPQRSTUVWXYZ123456789", 5);
        }
        System.out.println(Arrays.toString(nums));
        if(Arrays.asList(nums).contains(ticket)) {
        	System.out.println("You have the winning ticket! Congratulations! ");
        }else {
        	System.out.println("You lost. Try again.");
        }
        	
            
        }
    
    public static String generate(String candidate, int length){
   // String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidate.charAt(random.nextInt(candidate
                    .length())));
        }

        return sb.toString();
    }
    
}

