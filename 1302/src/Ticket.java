//Stephanie Rimel ticket template

public class Ticket {
	
		private int number;
		private int ticketPrice;
		
	
		public Ticket (int number){
			this.number = number;
			ticketPrice = 50;
		}
		
		public int getPrice(){
			return ticketPrice;
		}
		
		public void setPrice(int price){
			ticketPrice = price;
		}
		
		public int getNumber(){
			return number;
		}
		
		public String toString(){
			return String.format(" #%14s    $%14s", number, ticketPrice);
		   
		 }
	}

	

