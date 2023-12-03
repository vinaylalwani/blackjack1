import java.util.*;

public class Player {
    private DecisionTree decisions;
    private Queue<Card> hand;
    private String name;
    private int bet;
    private int chips;
    private int runningCount;
    private double trueCount;

    /**
     * Creates a new player
     * @param name of player
     * @param chips in the player's hand
     */
    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        hand = new LinkedList<>();
        this.chips = 1000;
        this.bet = 0;
    }

    /**
     * initializes a player without any chips
     * @param name of player
     */
    public Player(String name) {
        this.name = name;
        hand = new LinkedList<>();
        this.bet = 0;
        this.chips = 1000;
    }

    /**
     * makes a decision and adds to the player's decision tree
     * @param decision made
     * @return the decision in int form, 0 -> hit, 1 -> stand, -1 -> impossible
     */
    public int makeDecision(String decision) {
        DecisionTree curr = decisions;

        if(curr == null) {
            decisions = new DecisionTree(decision);
            return decision.equals("hit") ? 0 : 1;
        }

        while(curr.getLeft() != null && curr.getRight() != null) {
            if(curr.getLeft() != null) curr = curr.getLeft();
            else if(curr.getRight() != null) curr = curr.getRight();
        }

        if(decision.equals("hit")) {
            curr.setLeft(new DecisionTree("hit"));
            return 0; //made decision to hit
        } else if(decision.equals("stand")) {
            curr.setRight(new DecisionTree("stand"));
            return 1; //made decision to stand
        }

        return -1; //impossible decision
    }

    /**
     * adds a card
     * @param c to be added
     */
    public void addCard(Card c) {
        hand.add(c);
    }

    /**
     * getter for the hand
     * @return queue of the player's card in the drawn order
     */
    public Queue<Card> hand() {
        return hand;
    }

    /**
     * places a bet
     * @param bet to place 
     */
    public void placeBet(int bet) {
        this.bet = bet;
        chips -= bet;
    }

    /**
     * getter for the player's current bet
     * @return current bet
     */
    public int getBet() {
        return bet;
    }

    /**
     * value of the cards in the player's hand
     * @return value of cards
     */
    public int valOfCards(){
        int cardsval = 0;
        for(int i = 0; i < hand.size(); i++){
            cardsval += ((LinkedList<Card>) hand).get(i).getVal();
        }
        return cardsval;
        

    }

    /**
     * sets the player's chip values
     * @param c chips to give to player
     */
    public void setChips(int c){
        chips = c;
    }

    /**
     * gets the number of chips player has
     * @return number of chips
     */
    public int getChips(){
        return chips;
    }

    /**
     * gets the running count
     * @return running count
     */
    public int getRunningCount() {
        return runningCount;
    }

    /**
     * gets the true count
     * @return true count
     */
    public double getTrueCount() {
        return (double) Math.round(trueCount * 100.0) / 100.0;
    }

    /**
     * sets the running count
     * @param running new running count
     */
    public void setRunningCount(int running) {
        this.runningCount = running;
    }

    /**
     * sets the true count
     * @param trueCount new true count
     */
    public void setTrueCount(double trueCount) {
        this.trueCount = trueCount;
    }
}
