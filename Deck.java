import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private static ArrayList<Card2> cards;

	public Deck() {

		setCards(new ArrayList<Card2>());
		for(int suite = 0; suite<4; suite++) {
			for(int rank = 0; rank<13; rank++) {
				//getCards().add(new Card2(suite,rank));
			}
		}

	}
	public void printDeck() {

		for(int i=0; i < cards.size(); i++){
			System.out.println(Deck.getCards().get(i).toString());
		}

	}
	public void printList() throws IOException 
	   {
	            
	      // print headings to screen
	      System.out.printf("%15s%20s%n","Suit","Rank") ;
	      
	      System.out.printf("%15s%20s%n","==============","===============") ;
	        
	      // for each account in this bank
	      for ( int i = 0 ; i < 52 ; i++ )
	      {
	         Card2 current = getCards().get( i ) ;	  // get next card
	         
	         // print account number and balance to screen
	         System.out.printf("%15s%20s%n",current.getRank(),
	                           current.getSuit()) ;

	      }
	      
	   
	   }
	public Card2 drawRandomCard() {

		Random generator = new Random();
		int index = generator.nextInt(getCards().size());
		return getCards().remove(index);
	}
	public static ArrayList<Card2> getCards() {
		return cards;
	}
	public static void setCards(ArrayList<Card2> cards) {
		Deck.cards = cards;
	}

}


