public class Card1 {
	private int cardRank;
	private String cardSuit;
	
	//constructors
	public Card1(){
		this.cardRank = 1;
		this.cardSuit = "Spades";
	}
	
	public Card1(int cardRank, String cardSuit){
		this.cardRank = cardRank;
		this.cardSuit = cardSuit;
	}
	
	//setters
	public void setCardRank(int cardRank){
		this.cardRank = cardRank;
	}

	public void setCardSuit(String cardSuit){
		this.cardSuit = cardSuit;
	}
	
	//getters
	public int getCardRank(){
		return cardRank;
	}
	
	public String getCardSuit(){
		return cardSuit;
	}
	
	//print method for class 
	public String toString(){
		
		String rank = ""+cardRank;
		String suit = cardSuit;
		
		if (cardRank == 1){
			rank = "A";
		}
		if (cardRank == 11){
			rank = "J";
		}
		if (cardRank == 12){
			rank = "Q";
		}
		if (cardRank == 13){
			rank = "K";
		}
		
		if (cardSuit.equals("Hearts")){
			suit = "H";
		}
		if (cardSuit.equals("Spades")){
			suit = "S";
		}
		if (cardSuit.equals("Diamonds")){
			suit = "D";
		}
		if (cardSuit.equals("Clubs")){
			suit = "C";
		}
		return rank + suit;
	}
}