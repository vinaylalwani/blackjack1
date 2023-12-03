import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FreeplayGUI extends JPanel implements MouseListener {

  public BufferedImage backgroundImage;
  public BufferedImage chipImage;
  Player playerHand;
  Player dealerHand;
  public static int bet;
  public boolean faceDown = true;
  public static boolean betMade = false;
  private int bal;
  public static int cBet;

  /**
   * constructor to load the GUI for freeplay
   * @param dealer of the game
   * @param player of the game
   */
  public FreeplayGUI(Player dealer, Player player) {
    dealerHand = dealer;
    playerHand = player;
    bal = 1000;
    addMouseListener(this);
  }

  /**
   * adds winLose to bal
   * @param winLose to be added to bal
   */
  public void setBal(int winLose){
    bal += winLose;
  }

  /**
   * gets the balance
   * @return balance
   */
  public int getBal(){
    return bal;
  }

  /**
   * gets current bet
   * @return current bet
   */
  public int getBet(){
    return bet;
  }

  /**
   * paint the freeplay menu
   * @param g graphics object
   */
  public void paintComponent(Graphics g) {
    Graphics2D g1d = (Graphics2D) g;

    try {
      backgroundImage = ImageIO.read(new File("images/casinoBackground.png"));
      chipImage = ImageIO.read(new File("images/chip.png"));
    } catch (IOException e) {
    }

    g1d.drawImage(backgroundImage, 0, 0, null);
    g1d.drawImage(chipImage, 45, 475, null);
    g1d.setColor(Color.WHITE);
    g1d.setFont(new Font("Tahoma", Font.BOLD, 20));
    g1d.drawString("Balance: " + playerHand.getChips(), 55, 650);
    

    try {
      int counter1 = 0;
      for (Card card : dealerHand.hand()) {
        //System.out.println("yay:" + counter1 + " " + faceDown);
        if (counter1 == 0) {
          //System.out.println("after if");
          if (faceDown) {
            //System.out.println("WOW1");
            card.cardPrinter(g1d, true, true, counter1, card);
          } else {
            //System.out.println("WOW2");
            card.cardPrinter(g1d, true, false, counter1, card);
          }
        } else {
          card.cardPrinter(g1d, true, false, counter1, card);
          //System.out.println("WOW3");
        }

        counter1++;
      }
    } catch (IOException e) {
    }

    try {

      int counter2 = 0;
      for (Card card : playerHand.hand()) {
        //System.out.println("uwu:" + counter2);
        System.out.println(playerHand.hand());
        card.cardPrinter(g1d, false, false, counter2, card);
        //System.out.println("WOW4");
        counter2++;
      }
    } catch (IOException e) {
    }

  }

  /**
   * refreshes the GUI
   * @param bal of the game
   * @param faceDown whether or not card is face up or face down
   */
  public void refresher(int bal, boolean faceDown) {
    this.bal = bal;
    this.faceDown = faceDown;
    this.repaint();
  }

  /**
   * repaint cards
   */
  public void repainter(){
    this.repaint();
  }

  /**
   * detects a mouse press, and checks if it falls into the region of the chip to place bet
   * @param e mouse click event
   */
  public void mousePressed(MouseEvent e) {
    int mouseX = e.getX();
    int mouseY = e.getY();

    if (mouseX >= 45 && mouseX <= 195 && mouseY >= 475 && mouseY <= 625) {
      betMade = true;
      String[] options = new String[] { "200", "150", "100", "50", "20" };
      int response = JOptionPane.showOptionDialog(null, "Please select your betting amount", "Bets",
          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      if (response == 0) {
        bet = 200;
        bal -= 200;
        playerHand.placeBet(200);
      } else if (response == 1) {
        bet = 150;
        bal -= 150;
        playerHand.placeBet(150);
      } else if (response == 2) {
        bet = 100;
        bal -= 100;
        playerHand.placeBet(100);
      } else if (response == 3) {
        bet = 50;
        bal -= 50;
        playerHand.placeBet(50);
      } else if (response == 4) {
        bet = 20;
        bal -= 20;
        playerHand.placeBet(20);
      }
      // else {
      // bet = 20;
      // balance -= 20;
      // }

      Main.newGame.startGame();
    }
  }

  
  public void mouseExited(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseClicked(MouseEvent e) {
  }

}
