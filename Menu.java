import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


public class Menu extends JComponent implements ActionListener {

    private JButton freeplayBTN = new JButton("Freeplay");
    private JButton ccBTN = new JButton("CC Sim");
    private JButton exitBTN = new JButton("Exit");

    private static BufferedImage backgroundImage;

    private JFrame menuFrame;


    /**
     * constructor for menu
     * @param menuFrame frame of the menu
     */
    public Menu(JFrame menuFrame){
        this.menuFrame = menuFrame;
        freeplayBTN.addActionListener(this);
        ccBTN.addActionListener(this);
        exitBTN.addActionListener(this);
    }

    /**
     * paints the board
     * @param g0 graphics object
     */
    public void paintComponent(Graphics g0){
        

        Graphics2D g1 = (Graphics2D) g0;

        try{
            backgroundImage = ImageIO.read(new File("images/menuBackground.png"));
        }

        catch(IOException e){

        }

        g1.drawImage(backgroundImage, 0, 0, null);
        g1.setFont(new Font("Bell MT", Font.BOLD, 100));
        g1.setColor(Color.WHITE);


        freeplayBTN.setBounds(425, 300, 125, 60);
        ccBTN.setBounds(725, 300, 125, 60);  
        exitBTN.setBounds(575, 450, 125, 60);


        freeplayBTN.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 20)); 
        ccBTN.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 20));
        exitBTN.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 20));
        
        super.add(freeplayBTN);
        super.add(ccBTN);
        super.add(exitBTN);

    }

    /**
     * checks for a performed action
     * @param x action event
     */
    public void actionPerformed(ActionEvent x){

        JButton selectedBTN = (JButton)x.getSource();

        if (selectedBTN==exitBTN){
            System.exit(0);
        }


        else if (selectedBTN == freeplayBTN){
            Main.currentState = Main.STATE.FREEPLAY;
            menuFrame.dispose();
            // Main.openFreeplay1();
            Main.openFreeplay2();
        }

        else if (selectedBTN==ccBTN){
            Main.currentState = Main.STATE.CC;
            menuFrame.dispose();
            // Main.openFreeplay1();
            Main.openCCSim2();
    }
    
}}

    

