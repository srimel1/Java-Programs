
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Random;

	public class Deck2 {

	    private ArrayList<Card2> cards = new ArrayList<>();
	    private int size;

	    public Deck2(String[] ranks, Suit[] suits) {
	        for (int i = 0; i < ranks.length; i++) {
	            cards.add(new Card2(ranks[i], suits[i]));
	        }
	        this.size = cards.size();
	    }

	    public Deck2(Collection<Card2> cards) {
	        this.cards.addAll(cards);
	        this.size = cards.size();
	    }

	    public int size() {
	        return size;
	    }

	    public boolean isEmpty() {
	        return size <= 0;
	    }

	    public Card2 deal() {
	        size--;
	        if (size < 0) {
	            return null;
	        }
	        return cards.get(size);
	    }

	    public void shuffle() {
	        Random r = new Random();
	        Card2[] unshuffled = cards.toArray(new Card2[0]);
	        Card2[] shuffled = new Card2[size];

	        for (int k = 0; k < size; k++) {
	            int j;
	            do {
	                /* "Repeatedly generate a random integer j between 0 and 51, inclusive until
	                 * cards[j] contains a card(not marked as empty);" */
	                j = r.nextInt(size);
	                if (unshuffled[j] != null) {
	                    break;
	                }
	            } while (true);
	            shuffled[k] = unshuffled[j];
	            unshuffled[j] = null;
	        }
	        for (int i = 0; i < size; i++) {
	            cards.set(i, shuffled[i]);
	        }
	    }
	}


