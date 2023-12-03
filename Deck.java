import java.util.*;

public class Deck {

    private LinkedList<Card> deck = new LinkedList<>();

    /**
     * Constructor for deck, creates a full deck of 6 standard card decks
     */
    public Deck() {
        for(int i = 0; i < 6; i++) {
            LinkedList<Card> temp = createDeck();
            for(Card c : temp) {
                deck.add(c);
            }
        }
    }

    /**
     * creates a standard 52 card deck
     * @return linked list of the cards in the deck, without shuffling
     */
    private LinkedList<Card> createDeck() {
        LinkedList<Card> temp = new LinkedList<>();

        for(int i = 0; i < 4; i++) {
            for(int j = 1; j <= 13; j++) {

                int suit = 0;
                int val = -1;
                int rank = j;
                if(i == 0) suit = 3;
                else if(i == 1) suit = 0;
                else if(i == 2) suit = 1;
                else if(i == 3) suit = 2;

                if(j > 11 || j == 1) val = 11;
                else val = j;

                temp.add(new Card(val, suit, rank));
            }
        }

        return temp;
    }

    /**
     * shuffles the cards in the 6 deck set
     */
    public void shuffle() {
        LinkedList<Card> temp = new LinkedList<>();

        for(int i = 312; i >= 1; i--) {
            int ind = (int) (Math.random() * i);
            temp.add(deck.remove(ind));
        }

        deck = temp;
    }

    /**
     * draws a card, reshuffles all cards in the deck if there are not enough cards for a round
     * @return a drawn card object
     */
    public Card draw() {
        if(deck.size() <= 4) {

            for(int i = 0; i < 6; i++) {
                LinkedList<Card> temp = createDeck();
                for(Card c : temp) {
                    deck.add(c);
                }
            }
            
            shuffle();
        }

        return deck.remove();
    }

    /**
     * adds a card to the deck
     * @param c card to be added
     */
    public void add(Card c) {
        deck.add(c);
    }

    /**
     * gets the number of cards left
     * @return number of cards left
     */
    public int cardsLeft() {
        return deck.size();
    }
}
