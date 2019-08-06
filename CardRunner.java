import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author Josh Baird
 */
public class CardRunner {

    public static void main(String[] args) {
        Collection<Card2> ss = new TreeSet<>();

        ss.add(new BlackJackCard("two", Suit.Club));
        ss.add(new BlackJackCard("five", Suit.Spade));
        ss.add(new BlackJackCard("king", Suit.Heart));
        ss.add(new BlackJackCard("jack", Suit.Diamond));
        ss.add(new BlackJackCard("ace", Suit.Spade));

        for (Card2 c : ss) {
            System.out.println(c.toString());
        }
        System.out.println(Arrays.toString(ss.toArray()));
        System.out.println("\n");
        System.out.println();
        Deck2 mydeck = new Deck2(ss);
        System.out.println(mydeck.deal());
        
        System.out.println(mydeck.size());

        mydeck.shuffle();
        while (!mydeck.isEmpty()) {
            System.out.println(mydeck.deal());
            System.out.println(mydeck.size());
        }
    }
}