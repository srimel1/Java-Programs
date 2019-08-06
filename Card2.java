public class Card2 implements Comparable<Card2> {

    /**
     * All the names of the faces
     */
    public static final String FACES[] = {
        "",
        "Ace",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Jack",
        "Queen",
        "King"
    };

    private Suit suit;
    private int rank;

    /**
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return the friendly suit string
     */
    public String getSuitString() {
        return suit.toString();
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * @return the rank of this card
     */
    public int getRank() {
        return rank;
    }

    /**
     * @return the friendly name of this card
     */
    public String getRankString() {
        return FACES[rank];
    }

    /**
     * @param rank the rank (rank) to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Create a new card
     *
     * @param rank The rank/rank of the card
     * @param suit The suit of the card
     */
    public Card2(String rank, Suit suit) {
        for (int i = 1; i < FACES.length; i++) {
            if (FACES[i].equalsIgnoreCase(rank)) {
                this.rank = i;
            }
        }
        if (this.rank == 0) {
            throw new IllegalArgumentException("Face was not a valid card");
        }
        this.suit = suit;
    }

    @Override
    public String toString() {
        return getRankString() + " of " + getSuitString();
    }

    @Override
    public int compareTo(Card2 o) {
        if (o.getRank() == this.getRank() && o.getSuit().equals(this.getSuit())) {
            return 0;
        } else {
            return (this.getRank() - o.getRank());
        }
    }
}