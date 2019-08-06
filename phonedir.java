
import java.util.*;


/***
 * Create a class, phonedir
 * @author Stephanie Rimel
 *
 */
public class phonedir
{
    //Create a LinkedList class's object
    LinkedList<directory> record = new LinkedList<directory>();
   
    //Create a Scanner class object
    private Scanner s;
   
    //Initialize variable
    private int currentData = 0;
   
    //Default constructor
    public phonedir()
    {
        s = new Scanner(System.in);
    }
    //main method
    public static void main(String[] args)
    {
        phonedir pd = new phonedir();
        pd.start();
    }
  
    //Method definition of begins
    private void start()
    {
        String choice;

        System.out.println("\n The Phone Directory Program: ");
   //Call the method
        menuDisplay();

        //Prompt and read the input from the user
        while(s.hasNext())
        {
            try
            {
                choice = s.next();

                switch(choice)
                {
                    case "q": System.exit(-1);       
                    break;
                    case "a": displayTotalRecords();      
                    break;
                    case "d": deleteCurrentRecord();
                    break;
                    case "f": changeFirstNameRecord();     
                    break;
                    case "l": changeLastName();      
                    break;
                    case "n": addNewRecord();        
                    break;
                    case "p": changePhoneNum();   
                    break;
                    case "s": selectRecord();        
                    break;
                    default:
                        System.out.println("Illegal command ");
                        break;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Illegal command");
            }
            finally
            {
                menuDisplay();
            }
        }
    }
    /***
     * Method definition of menuDisplay
     */
    private void menuDisplay()
    {
       System.out.println("\n\n" +
                           "          a     Show all records\n" +
                           "          d     Delete the current record\n" +
                           "          f     Change the first name in the current record\n" +
                           "          l     Change the last name in the current record\n" +
                           "          n     Add a new record\n" +
                           "          p     Change the phone number in the current record\n" +
                           "          q     Quit\n" +
                           "          s     Select a record from the record list to become the current record\n");
        System.out.print("Enter a command from the list above (q to quit): ");
    }
    /***
     * Method definition of displayTotalRecords: This method is used to
     * display all records
     */
    private void displayTotalRecords()
    { 
        if (record.size() == 0)
        {
            System.out.println("No current record.");
            return;
        }
        System.out.println("First Name          Last Name           Phone Number    ");
        System.out.println("----------------   ------------------- -----------------");
       
        for (directory list: this.record)
        {
            System.out.print(list.getFirstName());
            for (int i = list.getFirstName().length(); i < 20; i++)
            {
                System.out.print(" ");
            }

            System.out.print(list.getLastName());
            for (int i = list.getLastName().length(); i < 20; i++)
            {
                System.out.print(" ");
            }

            System.out.print(list.getPhoneNumber());
             for (int i = list.getPhoneNumber().length(); i < 20; i++)
            {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    /***
     * Method definition of deleteCurrentRecord: This method is used to
     * delete the current record.
     */
    private void deleteCurrentRecord()
    {
        if (record.size() == 0 || this.currentData == -1)
        {
            System.out.println("No current record");
            return;
        }
        System.out.println("Deleted: " +
                this.record.get(currentData).getFirstName() + " " +
                this.record.get(currentData).getLastName() + " " +
                this.record.get(currentData).getPhoneNumber());
   
       
        this.record.remove( this.currentData);
        this.currentData = -1;
    }
    /***
     * Method definition of showCurrentRecord: This method is used to
     * show the current record
     */
    private void showCurrentRecord()
    {
        System.out.println("Current record is: " +
                record.get(currentData).getFirstName() + " " +
                record.get(currentData).getLastName() + " " +
                record.get(currentData).getPhoneNumber());
    }
   
    /***
     * Method definition of changeFirstName: This method is used to
     * change the first name in the current record.
     */
    private void changeFirstNameRecord()
    {
        if (record.size() == 0 || this.currentData == -1)
        {
            System.out.println("No current record");
            return;
        }
        System.out.print("Enter new first name: ");
        String firstName = s.next();
        String s1 = firstName.substring(0, 1).toUpperCase();
        firstName = s1 + firstName.substring(1);
        directory current = record.get(currentData);
        record.remove(currentData);
        current.setfName(firstName);
        getIndexInsert(current);
        this.record.add(this.currentData, current);
        showCurrentRecord();
    }
   
   
    /***
     * Method definition of changeLastNameRecord: This method is used to
     * change the last name in the current record.
     */
    private void changeLastName()
    {
        if (record.size() == 0 || this.currentData == -1)
        {
            System.out.println("No current record");
            return;
        }

        System.out.print("Enter new last name: ");
        String lastName = s.next();
        String s1 = lastName.substring(0, 1).toUpperCase();
        lastName = s1 + lastName.substring(1);

        directory current = record.get(currentData);
        record.remove(currentData);
        current.setlName(lastName);

        getIndexInsert(current);
        this.record.add(this.currentData, current);
        showCurrentRecord();
    }
   
    /***
     * Method definition of changephNum: This method is used to change tghe phone number in the record.
     * 
     */
    private void changePhoneNum()
    {
        if (record.size() == 0 || this.currentData == -1)
        {
            System.out.println("No current record");
            return;
        }
        String phoneNum = record.get(currentData).getPhoneNumber();
        boolean numExists = true;
        while (numExists)
        {
            System.out.println("Enter new phone number: ");
            phoneNum = s.next();
            phoneNum = formatNumber(phoneNum);

            if (phoneNum.equals("q"))
            {
                System.exit(-1);
            } else if (phoneNum.equals("d"))
            {
                this.displayTotalRecords();
            }

            numExists = checkIfphNumExists(phoneNum);

            if (numExists) {
                System.out.println("Number already exists, try another.");
                System.out.println("You can enter 'q' to quit, 'a' to display all records or add a new number to " +
                        "try again.");
            }
        }

        directory current = this.record.get( this.currentData);
        this.record.remove( this.currentData);
        current.setphNum(phoneNum);

        getIndexInsert(current);
        this.record.add(this.currentData, current);

        System.out.println("The phone number has been successfully updated.");
        this.showCurrentRecord();
    }
    /***
     * 
     * @param phNum
     * @returns true if the phone number exists, false if it doesnt.
     */
    private boolean checkIfphNumExists(String phNum)
    {
        for (directory data: this.record)
        {
            if (data.getPhoneNumber().equals(phNum))
            {
                return true;
            }
        }

        return false;
    }

    /***
     * Method definition of addNewRecord: This method is used to
    add new record
     */
    private void addNewRecord()
    {
        System.out.print("Enter first name: ");
        String first = s.next();
        String s1 = first.substring(0, 1).toUpperCase();
        first = s1 + first.substring(1);

        System.out.print("Enter last name: ");
        String last = s.next();
        s1 = last.substring(0,1).toUpperCase();
        last = s1 + last.substring(1);

        boolean isNumberCorrect = false;
        String number = "";

        while (!isNumberCorrect)
        {
            System.out.print("Enter phone number: ");
            number = s.next();

            if (number.equals("q"))
            {
                System.exit(-1);
            }

            number = formatNumber(number);

            if (checkIfphNumExists(number))
            {
                System.out.println("Number already exists. Try again");
                System.out.println("You may also enter 'q' to quit.");
                continue;
            }
            String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";

            if (number.length() != 12 || !number.matches(regex)) {
                System.out.println("Incorrect Number entered. Try again.");
                System.out.println("You may enter 'q' to quit or try again.");
            } else {
                isNumberCorrect = true;
            }
        }

        directory data = new directory(first, last,number);
        getIndexInsert(data);
        this.record.add(this.currentData, data);

        showCurrentRecord();
    }
    /***
     * phone number formatter
     * @param phNum
     * @return
     */
    private String formatNumber(String phNum)
    {
        phNum = phNum.replaceAll("[^\\d]", "");

        String regex = "^[0-9]*$";
        char[] newNum = new char[12];
        char[] num = phNum.toCharArray();

        if (phNum.matches(regex))
        {
            if (phNum.length() != 10)
            {
                return "";
            }

            createCorrectPhoneFormat(0, 3, newNum, num, 1);
            createCorrectPhoneFormat(3, 6, newNum, num, 2);
            createCorrectPhoneFormat(6, 10, newNum, num, 3);
        }

        phNum = new String(newNum);
        return phNum;
    }
    /***
     * This is a method to check if the phone number entered is of the correct format.
     * @param begins
     * @param end
     * @param newNum
     * @param num
     * @param pass
     */
    private void createCorrectPhoneFormat(int begins, int end, char[] newNum, char[] num, int pass)
    {
        // Invariant: begins <= i < end
        for (int i = begins; i < end; i++)
        {
            int j = 0;

            if (pass == 2)
            {
                j = 1;
            } else if (pass == 3)
            {
                j = 2;
            }

            newNum[i + j] = num[i];
        }

        if (pass == 1)
        {
            newNum[end] = '-';
        } else if (pass == 2)
        {
            newNum[end+1] = '-';
        }
    }
    /***
     * Method to select a record.
     */
    private void selectRecord()
    {
        if (record.size() == 0)
        {
            System.out.println("No current record. You must add at least one record.");
            return;
        }
        System.out.print("Enter first name: ");
        String first = s.next();
        String s1 = first.substring(0, 1).toUpperCase();
        first = s1 + first.substring(1);

        System.out.print("Enter last name: ");
        String last = s.next();
        s1 = last.substring(0,1).toUpperCase();
        last = s1 + last.substring(1);
        String data=getDetails(first, last);
       
        System.out.println(data);
    }
   /***
    * 
    * @param fname
    * @param lname
    * @returns the details of the entry.
    */
    private String getDetails(String fname, String lname)
    {

        for (int i = 0; i < record.size(); i++)
        {
           
            if(fname.equals(record.get(i).getFirstName()) && lname.equals(record.get(i).getLastName()))
            {
            this.currentData = i;
            return "Current record is: " +record.get(i).getFirstName()+" "+ record.get(i).getLastName()+" "+ record.get(i).getPhoneNumber();           
            }
           
        }
        return "No matching record found.";
    }
    /***
     * method to insert an entry at a particular index
     * @param data
     */
    private void getIndexInsert(directory data)
    {
        String currentPerson = data.getLastName() + " " + data.getFirstName() + " " + data.getPhoneNumber();

        if (record.size() == 0)
        {
            this.currentData= 0;
            return;
        }
        for (int i = 0; i < record.size(); i++)
        {
            String compareToPerson = record.get(i).getLastName() + " " +
                    record.get(i).getFirstName() + " " +
                    record.get(i).getPhoneNumber();
            if (currentPerson.toLowerCase().compareTo(compareToPerson.toLowerCase()) < 0)
            {
                this.currentData = i;
                return;
            } else
            {
                this.currentData = i+1;
            }
        }
   }
    /***
     * 
     * the directory class with constructors to create entry.
     *
     */
   class directory
   {
        private String Fname;
        private String Lname;
        private String phNum;
       
        //Constructor with arguments
        public directory(String first, String last,String phNum)
        {
            setfName(first);
            setlName(last);
            setphNum(phNum);
        }
       
        //Set and getter methods
        public void setfName(String first)
        {
        Fname = first;
        }
        public void setlName(String last)
        {
        Lname = last;
        }
        public void setphNum(String number)
        {
            phNum = number;
        }
       public String getFirstName()
       {
            return Fname;
        }
        public String getLastName()
        {
            return Lname;
        }
        public String getPhoneNumber()
        {
            return phNum;
        }
    }
}