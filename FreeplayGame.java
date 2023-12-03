import javax.swing.*;
import java.util.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.*;


public class FreeplayGame {
    public boolean faceDown;
    private static Deck deck;
    private static int pool;
    private static Player dealer;
    private static Player user;
    public boolean over; 
    JFrame mainFrame;
    private static int balance1 = 1000;
    
    FreeplayGUI creatorComp;
    FreeplayGUI cardComp;

    JButton btnHit; 
    JButton btnStand;
    JButton btnExit;

    /**
     * loads freeplay game
     * @param frame1 jframe
     */
    public FreeplayGame(JFrame frame1) {
        mainFrame = frame1;
        deck = new Deck();
        deck.shuffle(); //we randomize the deck.
        user = new Player("player1");
        dealer = new Player("dealer1");
        faceDown = true;
        over = false;
      }
    
    /**
     * find the balance
     * @return balance
     */
    public int getBal1(){
      return creatorComp.getBal();
    }

    /**
     * forms a game
     */
    public void formGame() {
        mainFrame.setTitle("Deckster - Freeplay"); 
        mainFrame.setSize(1280, 720);
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false); 
    
        btnHit = new JButton("Hit"); 
        btnHit.setBounds(1000, 540, 150, 50); 
        btnHit.setFont(new Font("Tahoma", Font.BOLD, 16));  
        btnStand = new JButton("Stand");
        btnStand.setBounds(1000, 620, 150, 50);
        btnStand.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnExit = new JButton("Exit");
        btnExit.setBounds(75, 5, 100, 50);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
    
        mainFrame.add(btnHit); 
        mainFrame.add(btnStand);
        mainFrame.add(btnExit);


        btnExit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
              System.exit(0); 
            }
          }
          );


        creatorComp = new FreeplayGUI(dealer, user);
        creatorComp.setBounds(0, 0, 1280, 720);  
        mainFrame.add(creatorComp); 
        mainFrame.setVisible(true); 
}

/**
 * starts a game
 */
public void startGame() { 

    Freeplay loader = new Freeplay(dealer, user, pool, deck);

    cardComp = new FreeplayGUI(loader.getDealer(), loader.getPlayer());
    loader.setPool(cardComp.getBet());
    cardComp.setBounds(0, 0, 1280, 720); 
    mainFrame.add(cardComp); 
    mainFrame.setVisible(true); 


    btnHit.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent e) {
        cardComp.repaint();
        faceDown = true;
        int returner = loader.hit();



        if (returner == -1){
          cardComp.repaint();
          System.out.println(user.hand());
          JOptionPane.showMessageDialog(mainFrame, "You have busted. Dealer Wins.");
        }
      }
    });
    
    btnStand.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent e) {
        cardComp.repaint();
        creatorComp.faceDown = false;
        cardComp.faceDown = false;
        cardComp.repaint();
        int returner = loader.stand();

        if (returner == -1){
          cardComp.repaint();
          JOptionPane.showMessageDialog(mainFrame, "Dealer has higher card value. Dealer Wins.");
          
        }

        else if (returner ==1){
          cardComp.repaint();
          JOptionPane.showMessageDialog(mainFrame, "Dealer has lower card value or has busted. Player Wins.");
        }

        

      }
    });
    




}



}