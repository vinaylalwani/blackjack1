import javax.swing.JFrame;

public class Main {
    public static JFrame menuFrame = new JFrame(); 
    public static JFrame ccFrame = new JFrame();
    public static JFrame freeplayFrame = new JFrame();
    public static FreeplayGame newGame = new FreeplayGame(freeplayFrame);
    public static CardCountingSimulatorGame newCCGame = new CardCountingSimulatorGame(ccFrame);


    public static enum STATE{ 
        MENU,
        FREEPLAY,
        CC
      };

    public static STATE currentState = STATE.MENU; 

    /**
     * main method
     * @param args main's args
     * @throws InterruptedException in case of menu close or unexpected error
     */
    public static void main(String[] args) throws InterruptedException {
        if(currentState == STATE.MENU) {
          oM(); 
        }
      }

      /**
       * open menu GUI
       */
      public static void oM(){
        menuFrame.setTitle("Deckster"); 
        menuFrame.setSize(1280, 720);
        menuFrame.setLocationRelativeTo(null); 
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false);

        Menu startingComp = new Menu(menuFrame); 
        menuFrame.add(startingComp); 
        menuFrame.setVisible(true); 
      }

    /**
     * opens CCSim
     */
    public static void openCCSim2(){
      ccFrame.getContentPane().removeAll();
      newCCGame = new CardCountingSimulatorGame(ccFrame);
      newCCGame.formGame();
    }

    /**
     * opens Freeplay
     */
    public static void openFreeplay2() {
      
      freeplayFrame.getContentPane().removeAll();
      newGame = new FreeplayGame(freeplayFrame); 
      newGame.formGame();
  }
      
}
