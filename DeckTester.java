import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DeckTester {


	public static void main(String[] args) throws IOException {
		Scanner s  = new Scanner(System.in);
		Deck deck = new Deck();
		Card2 C;
	
		
		System.out.println(Arrays.toString(Deck.getCards().toArray()));
		Deck.getCards().toString();
		Collections.shuffle(Deck.getCards());
		System.out.println("\n\nShuffled Cards: ");
		System.out.println(Arrays.toString(Deck.getCards().toArray()));
		
		
		System.out.println("Enter number of cards to be dealt: ");
		int input = s.nextInt();
		System.out.println("\n\nYou drew these cards: ");
		for(int i = 0; i <= input; i++) {
			C = deck.drawRandomCard();
			System.out.println();
			System.out.println(C.toString());
		}
		System.out.println("\n\nCards remaining: ");
		 for(int i=0; i<Deck.getCards().size(); i++)
		    {
		        System.out.println(Deck.getCards().get(i).toString());
		    }
		 
		 
		}
	private static void unshuffle(Random rnd,ArrayList<Card> cards){
        int[] seq = new int[cards.size()];
        for (int i = seq.length; i >= 1; i--) {
            seq[i - 1] = rnd.nextInt(i);
        }
        for (int i = 0; i < seq.length; i++) {
            Collections.swap(cards, i, seq[i]);
        }
    }

	
}

	