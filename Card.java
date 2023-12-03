import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D; 
 
/** 
 * creates card with suit(spades, clubs, heart, diamond)
 * val - the worth of the card(int from 1-11)
 * rank - the face of the card(ace - king)
 */
public class Card {
    private int suit;
    private int val;
    private int rank;

    private int xPos;
    private int yPos;
    /**
     * constructor initializes card with val suit and rank
     * @param val the value of the card(royals are 10, Ace is 11)
     * @param suit spade, club, heart, or diamond
     * @param rank the face value of the card - ace,2,3...
     */
    public Card(int val, int suit, int rank){
        this.val = val;
        this.suit = suit;
        this.rank = rank;
    }
    /**
     * getter command for the suit
     * @return the suit of the card
     */
    public int getSuit(){
        return suit;
    }
    /**
     * getter command for the value of the card
     * @return the value
     */
    public int getVal(){
        return val;
    }
    /**
     * getter method for the rank/facevalue of teh card
     * @return the facevalue 
     */
    public int getRank(){
        return rank;
    }
    /**
     * set the suit, 1-spade; 2- club; 3 - heart 4; diamond
     * @param s an integer that determines suit
     */
    public void setSuit(int s) {
        suit = s;
    }
    /**
     * set the value of the card from 1-11;
     * @param v the value of the card
     */
    public void setVal(int v) {
        val = v;
    }
    /**
     * set the face value of the card(the rank) 1-13
     * @param r the rank of the card
     */
    public void setRank(int r) {
        rank = r;
    }

    /**
     * prints the cards from a cardSprite sheet
     * @param g1 graphics object
     * @param dealerTurn whether or not it is the dealer's turn
     * @param faceDown whether or not card is facedown
     * @param cardNum which card it is
     * @param card1 card object itself
     * @throws IOException in case of improper file inputs
     */
    public void cardPrinter(Graphics2D g1, boolean dealerTurn, boolean faceDown, int cardNum, Card card1) throws IOException{
        BufferedImage cardDeck = ImageIO.read(new File("images/cardSpriteSheet.png")); 

        int deckWidth = 950; 
        int deckHeight = 392;

        BufferedImage[][] cardImages = new BufferedImage[4][13];
        BufferedImage backCard = ImageIO.read(new File("images/backCard.png")); 

        for (int c = 0; c < 4; c++) { 
            for (int r = 0; r < 13; r++) {
              cardImages[c][r] = cardDeck.getSubimage(r*deckWidth/13, c*deckHeight/4, deckWidth/13, deckHeight/4); 
          }
        }

        if (dealerTurn) {
            yPos = 75;
        }
        else{
            yPos = 550;
        }
    
        xPos = 560 + 75*cardNum; 
    
        if (faceDown) { 
            g1.drawImage(backCard, xPos, yPos, null ); 
            System.out.println("we are printing back");
        }

        else {
            g1.drawImage(cardImages[card1.getSuit()][card1.getRank()-1], xPos, yPos, null); 
            System.out.println("we are printing");
        }

    }
}
