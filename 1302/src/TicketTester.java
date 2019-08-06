import java.io.IOException;

public class TicketTester {
	public static void main(String[] args) throws IOException {
		Ticket t1 = new Ticket(5);
		AdvanceTicket t2 = new AdvanceTicket(23, 10);
		AdvanceTicket t6 = new AdvanceTicket(33, 4);
		Walkup t3 = new Walkup(2);
		StudentAdvanceTicket t4 = new StudentAdvanceTicket(68, 5);
		StudentAdvanceTicket t5 = new StudentAdvanceTicket(25, 11);
		
		 System.out.printf("%15s%20s%n","Ticket Number","Ticket Price") ;
		 System.out.printf("%15s%20s%n","==============","===============") ;
	      
	     System.out.println(t1.toString());
	     System.out.println(t2.toString());
	     System.out.println(t3.toString());
	     System.out.println(t4.toString());
	     System.out.println(t5.toString());
	     System.out.println(t6.toString());
		
	}
}