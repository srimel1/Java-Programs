//Stephanie Rimel advance ticket and student ticket
public class AdvanceTicket extends Ticket{
		private int days;
		
		public AdvanceTicket(int number, int days){
			super(number);
			this.days = days;
			
			if (days >= 10){
				setPrice(getPrice()-20);
			} else {
				setPrice(getPrice()-10);
			}
		}

		public int getDays(){
			return days;
		}
	}

	class StudentAdvanceTicket extends AdvanceTicket {
		public StudentAdvanceTicket(int number, int days){
			super(number, days);	
			
			if (getDays() >= 10){
				setPrice(getPrice()/2);
			} else {
				setPrice(getPrice()/2);
			}
		}
		
//		public String toString(){
//			return "Number: " + getNumber() + " Price: " + 
//						getPrice() + " (Student ID required)";
//		}
	

}
