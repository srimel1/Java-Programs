public class BlackJackCard extends Card2 {

    public BlackJackCard(String face, Suit suit) {
        super(face, suit);
    }

    /**
     * Get the BlackJack point value for the card
     *
     * @return The point value
     */
    public int getValue() {
        if (this.getRank() == 1) { //Ace
            return 11;
        } else if (this.getRank() >= 10) { //Faces and 10
            return 10;
        } else { //Numbers
            return this.getRank();
        }
    }
   
    @Override
    public String toString() {
        return super.toString() + " " + getValue();
    }
}