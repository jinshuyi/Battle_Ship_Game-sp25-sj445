package edu.duke.sj445.battleship;


import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *main class of battleship game
 */

public class App {
  private final TextPlayer p1;
  private final TextPlayer p2;
 
  /**
   * @param p1 player1
   * @param p2 player2
   */
  public App(TextPlayer p1,TextPlayer p2){
    this.p1 = p1;
    this.p2 = p2;
  }

/**
   * Handles the placement phase where both players place their ships on the board.
   * 
   * @throws IOException if an input error occurs
   */
  
  public void doPlacementPhase()throws IOException{
    p1.doPlacementPhase();
    p2.doPlacementPhase();
  }

   /**
   * Manages the attacking phase of the game where players take turns attacking each other.
   * The game continues until one player loses all ships.
   * 
   * @throws IOException if an input error occurs
   */
  
  public void doAttackingPhase() throws IOException{
    while(true){
      p1.playOneTurn(p2.theBoard,p2.view,p2.name);
      if(p2.ifLost()){
        System.out.println("Player " + p1.name + " Win!");
        break;
      }
      p2.playOneTurn(p1.theBoard,p1.view,p1.name);
      if(p1.ifLost()){
        System.out.println("Player " + p2.name + " Win!");
        break;
      }
    }
  }
  
  /**
   * decide game mode
   * @param inputReader
   * @return user choice
   */
  public static String getGameMode(BufferedReader inputReader) throws IOException{
    String input = null;
    while(true){
      input = inputReader.readLine();
      input = input.toUpperCase();
      if( input.equals("A") || input.equals("B") || input.equals("C") || input.equals("D")){
        break;
      }
      else {
        System.out.println("Invalid Choice, please enter again!");
      }
    }
    return input;
  }

 /**
   * The main entry point for the Battleship game.
   * It initializes the game, creates the players, and starts the game loop.
   *
   * @param args command-line arguments (not used)
   * @throws IOException if an input error occurs
   */
  
  public static void main(String[] args) throws IOException {
    Board<Character> b1 = new BattleShipBoard<Character>(10, 20, 'X');
    Board<Character> b2 = new BattleShipBoard<Character>(10, 20, 'X');
    String prompt = "Please select game mode:\n"+
            "A: human vs human\n" +
            "B: human vs computer\n" +
            "C: computer vs human\n" +
            "D: computer vs computer\n" ;

    System.out.println(prompt);
    
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    V2ShipFactory factory = new V2ShipFactory();
    String choice = getGameMode(input);
    TextPlayer p1 = null;
    TextPlayer p2 = null;
    switch(choice){
    case "A":
      p1 = new TextPlayer("A", b1, input, System.out, factory, false);
      p2 = new TextPlayer("B", b2, input, System.out, factory, false);
      break;
    case "B":
      p1 = new TextPlayer("A", b1, input, System.out, factory, false);
      p2 = new TextPlayer("B", b2, input, System.out, factory, true);
      break;
    case "C":
      p1 = new TextPlayer("A", b1, input, System.out, factory, true);
      p2 = new TextPlayer("B", b2, input, System.out, factory, false);
      break;
    case "D":
      p1 = new TextPlayer("A", b1, input, System.out, factory, true);
      p2 = new TextPlayer("B", b2, input, System.out, factory, true);
      break;
    }
    App app = new App(p1,p2);
    app.doPlacementPhase();
    app.doAttackingPhase();
  }
}
