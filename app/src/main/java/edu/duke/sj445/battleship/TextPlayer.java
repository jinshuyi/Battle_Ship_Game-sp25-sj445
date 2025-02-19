package edu.duke.sj445.battleship;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class TextPlayer {
  final Board<Character> theBoard;
  final BoardTextView view;
  final BufferedReader inputReader;
  final PrintStream out;
  final AbstractShipFactory<Character> shipFactory;
  final String name;
  final ArrayList<String> shipsToPlace;
  final HashMap<String, Function<Placement, Ship<Character>>> shipCreationFns;

  private boolean isAI;
  private int moveCounts;
  private int sonarCounts;
  private Random myrnd;
  private NotRandom myrnd2;
  
  /**
   * @param name the player's name
   * @param theBoard initialize the board and board text view with this board
   * @param inputSource inputReader
   * @param out initialize printstream with out
   * @param factory the ship factory
   * @param isAI decide whether it is AI
   */
  public TextPlayer(String name, Board<Character> theBoard, BufferedReader inputSource, PrintStream out, AbstractShipFactory<Character> factory, boolean isAI) {
    this.theBoard = theBoard;
    this.view = new BoardTextView(theBoard);
    this.inputReader = inputSource;
    this.shipFactory = factory;
    this.out = out;
    this.name = name;
    this.shipCreationFns = new HashMap<String, Function<Placement, Ship<Character>>>();
    this.shipsToPlace = new ArrayList<String>();
    setupShipCreationMap();
    setupShipCreationList();
    this.moveCounts = 3;
    this.sonarCounts = 3;
    this.isAI = isAI;
    this.myrnd = new Random(42);
    this.myrnd2 = new NotRandom();
  }

  /**
     * set up the ship creation hashmap
     */
    protected void setupShipCreationMap(){
        shipCreationFns.put("Submarine", (p) -> shipFactory.makeSubmarine(p));
        shipCreationFns.put("Carrier", (p) -> shipFactory.makeCarrier(p));
        shipCreationFns.put("Destroyer", (p) -> shipFactory.makeDestroyer(p));
        shipCreationFns.put("Battleship", (p) -> shipFactory.makeBattleship(p));
    }
    /**
     * set up the list of ships to be created at the beginning of the game
     */
    protected void setupShipCreationList(){
        shipsToPlace.addAll(Collections.nCopies(2, "Submarine"));
        shipsToPlace.addAll(Collections.nCopies(3, "Destroyer"));
        shipsToPlace.addAll(Collections.nCopies(3, "Battleship"));
        shipsToPlace.addAll(Collections.nCopies(2, "Carrier"));
    }

   /**
   * Read placement from String
   * @param prompt is the input String
   * @throws IO exception
   */
  public Placement readPlacement(String prompt, boolean special) throws IOException {
    out.println(prompt);
    String s = null;
    if (!isAI){
      s = this.inputReader.readLine();
    }
    else{
      String placeCoordinate = myrnd2.placeCoordinate();
      if(special){
        s = placeCoordinate + "L";
      }
      else{
        s = placeCoordinate + "H";
      }
    }
    if(s==null){
      throw new EOFException();
    }
    return new Placement(s);
  }
  
  /**
   * print a message to user, get an input, try to add a ship to the board
   * and print the board text view after the attempt
   * @param shipName the name of the ship to be placed
   * @param createFn the function to be called over a Placement, 
   * which basically create different kinds of ships
   */
  public void doOnePlacement(String shipName, Function<Placement, Ship<Character>> createFn) throws IOException{
    String line = "--------------------------------------------------------------------------------";
    Ship<Character> bs  = null;
    Placement p = null;
    boolean special = true;
    if (shipName != "Battleship" && shipName != "Carrier"){
      special = false;
    }
    if(!isAI){
      while(true){
        try{
          p = readPlacement(line + "\nPlayer "+this.name+" Where do you want to place a " + shipName + "?", special);
          bs  = createFn.apply(p);
          String message = this.theBoard.tryAddShip(bs);
          if (message == null){
            break;
          }
          else{
            out.println(message);
          }
        }catch(IllegalArgumentException e){
          out.println(e.getMessage());
        }
      }
      out.println(line + "\nCurrent ocean:");
      out.print(view.displayMyOwnBoard());
      out.println(line);
    }
    else{
      while(true){
        p = readPlacement("", special);
        bs  = createFn.apply(p);
        String message = this.theBoard.tryAddShip(bs);
        if (message == null){
          break;
        }
      }
    }
  }
  

  /**
   * display the starting (empty) board
   * print the instructions message
   * iterate throw the creation ship list
   * call doOnePlacement to place ships one by one
   */
  public void doPlacementPhase() throws IOException{
    String line = ("---------------------------------------------------------------------------\n");
    out.print(line + "Current ocean:\n");
    this.out.print(this.view.displayMyOwnBoard());
    this.out.print(line+"Player "+this.name+
                   ": you are going to place the following ships (which are all\n"+
                   "rectangular). For each ship, type the coordinate of the upper left\n"+
                   "side of the ship, followed by either H (for horizontal) or V (for\n"+
                   "vertical).  For example M4H would place a ship horizontally starting\n"+
                   "at M4 and going to the right.  You have\n\n"+
                   "2 \"Submarines\" ships that are 1x2\n"+ 
                   "3 \"Destroyers\" that are 1x3\n"+
                   "3 \"Battleships\" that are now shaped as shown below\n\n"+
                   " b     OR    b         bbb         b\n"+
                   "bbb          bb   OR    b     OR  bb\n"+
                   "             b                     b\n\n"+
                   "Up          Right      Down      Left\n"+
                   "2 \"Carriers\" that are now shaped as shown below\n\n"+
                   "c                       c             \n"+
                   "c           cccc        cc         ccc\n"+
                   "cc   OR    ccc      OR  cc   OR  cccc \n"+  
                   "cc                       c            \n"+
                   "c                        c            \n"+
                   "Up          Right      Down          Left\n"+
                   "These four orientations are now up (U),\n"+
                   "right (R), down (D), and left (L), with each diagram above\n"+
                   "having its orientation written below it.\n"+line);
    for(String shipName: this.shipsToPlace){
      doOnePlacement(shipName, shipCreationFns.get(shipName));
    }
  }

  /**
   * get the text display for two boards together
   * @param enemyView enemy's textboardview
   * @param myHeader the header over my board
   * @param enemyHeader the header over enemy's board
   * @return the string of text display
   */
  public String displayMyBoardWithEnemyNextToIt(BoardTextView enemyView, String myHeader, String enemyHeader){
    String myBoard = this.view.displayMyOwnBoard();
    String enemyBoard = enemyView.displayEnemyBoard();
    int W1 = this.theBoard.getWidth();

    
    String headerLine = "     "+myHeader;
    while(headerLine.length() < 2 * W1 + 22){
      headerLine += " ";
    }
    headerLine=headerLine + enemyHeader + "\n";
    StringBuilder sb = new StringBuilder();
    String splitLine = "---------------------------------------------------------------------------\n";
    sb.append(splitLine);
    sb.append("Player "+this.name+"'s turn:\n");
    sb.append(headerLine);

    String[] myBoardLines = myBoard.split("\n");
    String[] enemyBoardLines = enemyBoard.split("\n");
    for(int i = 0;i < myBoardLines.length; i++){
      String currLine = myBoardLines[i];
      while(currLine.length() < 2 * W1 + 19){
        currLine += " ";
      }
      currLine+=enemyBoardLines[i]+"\n";
      sb.append(currLine);
    }
    sb.append(splitLine);
    return sb.toString();
  }

  /**
   * print the message after attack
   * @param enemyShip is the enemy's ship been hit
   */
  protected void showFireResult(Ship<Character> enemyShip){
    String splitLine = ("---------------------------------------------------------------------------\n");
    this.out.print(splitLine);
    String player = "You";
    String ya = "a";
    if (isAI){
      player = "Your enemy";
      ya = "your";
    }
    if(enemyShip == null){
      this.out.println(player + " missed!");
    }else{
      this.out.println(player + " hit " + ya  +" "+enemyShip.getName()+"!");
    }
    this.out.print(splitLine);
  }

  /**
   * check if this player loses by checking all his ships
   * if all ships are sunk, yes, else, no
   * @return a boolean respresenting if the player loses or not
   */
  public boolean ifLost(){
    return this.theBoard.lose();
  }

  /**
   * Read Coordinate from String
   * @param prompt is the input String
   * @throws IO exception
   */
  public Coordinate readCoordinate(String prompt) throws IOException {
    String line = "---------------------------------------------------------------------------";
    out.println(line);
    out.print(prompt);
    out.println(line);
    String s = inputReader.readLine();
    if(s==null){
      throw new EOFException();
    }
    return new Coordinate(s);
  }

  /**
   * read the player's move
   */
  protected String readMove() throws IOException{
    if (isAI || (this.moveCounts == 0 && this.sonarCounts == 0)){
      return "F";
    }
    String line = "\n---------------------------------------------------------------------------";
    out.println(line);
    out.print("Possible actions for Player " + this.name + ":\n\n" + " F Fire at a square\n");
    out.print(" M Move a ship to another square (" + this.moveCounts + " remaining)\n");
    out.print(" S Sonar scan (" + this.sonarCounts + " remaining)\n");
    out.print("Player " + this.name + ", what would you like to do?");
    out.println(line);
    String s = this.inputReader.readLine();
    if(s==null){
      throw new EOFException();
    }
    s = s.toUpperCase();
    if (s.length() == 1
        && (s.charAt(0) == 'F' ||
            (s.charAt(0) == 'M' && this.moveCounts > 0) ||
            (s.charAt(0) == 'S' && this.sonarCounts > 0))){
      return s;
    }
    else{
      throw new IllegalArgumentException();
    }
  }

  /*
   * based on the move input by user, output different inst
   * @param move the move user choice
   * @return move info
   */
  protected String moveInfo(String move) {
    String inst = null;
    switch(move){
    case "F":
      inst = "Where do you want to fire at?\n";
      break;
    case "M":
      inst = "Which ship do you want to move?\n" +
        "Please type any coordinate which is a part of the ship you want.\n";
      break;
    case "S":
      inst = "Where do you want to use the sonar?\n";
      break;
    }
    return inst;
  }

  /*
   * AI's turn 
   */
  protected void playOneTurnAI(Board<Character> enemyBoard){
    int r = myrnd.nextInt(20);
    int c = myrnd.nextInt(10);   
    Ship<Character> enemyShip = enemyBoard.fireAt(new Coordinate(myrnd2.nextInt(r), myrnd2.nextInt(c)));
    this.showFireResult(enemyShip);
  }
  /**
   * let the player attack for one turn and print the msg
   * Based on the move, implement different action
   * @param enemyBoard the enemy's board
   * @param enemyView the enemy's boardTextView
   * @param enemyName the enemy player's name
   */
   public void playOneTurn(Board<Character> enemyBoard, BoardTextView enemyView, String enemyName)  throws IOException {
     if (isAI){
       playOneTurnAI(enemyBoard);
       return;
     }
     
     this.out.print(this.displayMyBoardWithEnemyNextToIt(enemyView,"Your ocean","Player "+enemyName+"'s ocean"));
     boolean flag = false;
     while(!flag){
       String move = null;
       try{
         move = readMove();
       }catch(IllegalArgumentException e){
         this.out.println("The input is invalid. Please try again:");
         continue;
       }
       
       Coordinate c = null;
       try{
         c = readCoordinate(moveInfo(move));
       }catch(IllegalArgumentException e){
         this.out.println("That coordinate is invalid: it does not have the correct format. Please try again.");
         continue;
       }
       
       switch(move){
       case "F":
         this.showFireResult(enemyBoard.fireAt(c));
         flag = true;
         break;
       case "M":
         try{
           moveShip(c);
           flag = true;
         }catch(IllegalArgumentException e){
           this.out.println("The input is invalid. Please try again.");
         }
         break;
       case "S":
         useSonar(enemyBoard,c);
         flag = true;
         break;
       }
     }
   }

   /*
   * move ship to target coordinate
   * @param where target coordinate
   */
 
  public void moveShip(Coordinate where) throws IOException{
    String line = "\n--------------------------------------------------------------------------------\n";
    Ship<Character> ship = this.theBoard.whichShipIsAtForSelf(where);
    if(ship == null){
      throw new IllegalArgumentException();
    }else{
      Placement p = null;
      Ship<Character> newship  = null;
      while(true){
        try{
          p = readPlacement(line + "Where do you want to move the " + ship.getName() + " to?", false);
          newship = shipCreationFns.get(ship.getName()).apply(p);
          this.theBoard.removeShip(ship);
          String message = this.theBoard.tryAddShip(newship);
          if (message == null){
            //record hit
            ShipRotationHitMap rotationHitMap = new ShipRotationHitMap();
            Set<Coordinate> hit = rotationHitMap.Rotation(ship, newship);
            
            for(Coordinate hitCoordinate : hit){
              //out.println(hitCoordinate.toString());
              newship.recordHitAt(hitCoordinate);
            }
            break;
          }
          else{
            out.println(message);
        }
        }catch(IllegalArgumentException e){
          out.println(e.getMessage());
        }
      }
    }
    out.println(line + "\nCurrent ocean:");
    out.print(view.displayMyOwnBoard());
    out.println(line);
    this.moveCounts--; 
  }

   /*
   * use sonar to detect ships nearby
   * @param enemyBoard
   * @param where target coordinate 
   */
   public void useSonar(Board<Character> enemyBoard, Coordinate where){
    HashMap<Character,Integer> ship = new HashMap<Character,Integer>();
    ship = enemyBoard.SonarDetect(where);
    this.sonarCounts--;
    int s = ship.getOrDefault('s', 0);
    int d = ship.getOrDefault('d', 0);
    int b = ship.getOrDefault('b', 0);
    int c = ship.getOrDefault('c', 0);
    String line = "---------------------------------------------------------------------------";
    out.println(line);
    out.print("Submarines occupy " + s + " square");
    if (s > 1){
      out.print("s");
    }
    out.print("\nDestroyers occupy " + d + " square");
    if (d > 1){
      out.print("s");
    }
    out.print("\nBattleships occupy " + b + " square");
    if (b > 1){
      out.print("s");
    }
    out.print("\nCarriers occupy " + c + " square");
    if (c > 1){
      out.print("s");
    }
    out.println("\n" + line);
  }
}
