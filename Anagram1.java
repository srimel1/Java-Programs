import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author keithwellman
 */
public class Anagram1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector<String> fileContents = new Vector<>(50);
        Vector<String> signature = new Vector<>(50);
        Vector<String> tempVector = new Vector<>(50);
        Scanner fileinput = null; 
        int i = 0;
        int wordcount = 0;
        final String FILE_PATH = "//Fall 2016//Data Structure//testfile/";
        
        Scanner input = new Scanner(System.in);
        // prompt user for name of file and assign to inputFile
        System.out.print("Please enter name of file: ");
        String inputFile = input.next();
        
        File inFile = new File(FILE_PATH + inputFile);
        input.close();
        
        try {
            fileinput = new Scanner(inFile);
            if (!fileinput.hasNext()) { // check if file is empty
                System.out.println("the input file is empty");
                System.exit(1);
            }
            while (fileinput.hasNext()) { // get words from file and add to vector
                String temp = fileinput.next();
                if (temp.length() <= 15) { //check length of word <=  15
                    fileContents.add(temp); //put word in vector
                    wordcount++; // increment word count
                    if (wordcount > 50) { // check word count < 50
                        System.out.println("There are more than 50 words!");
                        System.exit(1);
                    }
                } 
            }
            fileinput.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        } finally {
            fileinput.close();
        }
        
        AnagramFilter filter = new AnagramFilter();
        
        tempVector = (Vector)fileContents.clone(); //copy vector so as to not overwrite original vector
        signature = filter.wordFilter(tempVector); //remove non-alphabetic characters
        filter.charSort(signature); //sort signature words by character
        filter.duelSort(fileContents, signature); //sort vectors together based on signature vector
        System.out.println("\nAnagrams:\n");
        filter.printAnagrams(fileContents, signature);
        System.out.println("\n\n");
      
    }
}
