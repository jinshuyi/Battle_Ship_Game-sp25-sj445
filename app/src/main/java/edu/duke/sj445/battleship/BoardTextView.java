package edu.duke.sj445.battleship;

import java.util.function.Function;

/**
 * This class handles textual display of
 * a Board (i.e., converting it to a string to show
 * to the user).
 * It supports two ways to display the Board:
 * one for the player's own board, and one for the 
 * enemy's board.
 */
public class BoardTextView {
  /**
   * The Board to display
   */
  private final Board<Character> toDisplay;
  
 /**
   * Constructs a BoardView, given the board it will display.
   * 
   * @param toDisplay is the Board to display
   * @throws IllegalArgumentException if the board is larger than 10x26.  
   */
  public BoardTextView(Board<Character> toDisplay) {
    this.toDisplay = toDisplay;
    if (toDisplay.getWidth() > 10 || toDisplay.getHeight() > 26) {
      throw new IllegalArgumentException(
          "Board must be no larger than 10x26, but is " + toDisplay.getWidth() + "x" + toDisplay.getHeight());
    }
  }
  
  /**
   * This makes all the lines, e.g.   0|1\n
   *                                A  |  A\n
   *                                B  |  B\n
   *                                  0|1\n
   * 
   * @return the String for the given board
   */
  protected String displayAnyBoard(Function<Coordinate, Character> getSquareFn){
    StringBuilder ans = new StringBuilder("  "); // README shows two spaces at
    String sep=""; //start with nothing to separate, then switch to | to separate
    for (int i = 0; i < toDisplay.getWidth(); i++) {
      ans.append(sep);
      ans.append(i);
      sep = "|";
    }
    ans.append("\n");
    StringBuilder bd = new StringBuilder("");
    for (int row = 0; row < toDisplay.getHeight(); row++) {
      int num = row + 65;
      bd.append((char)num + " ");
      for (int column = 0; column < toDisplay.getWidth(); column++) {
        
        Coordinate c = new Coordinate(row, column);
        if (getSquareFn.apply(c) == null){
          bd.append(" ");
        }
        else {
          bd.append(getSquareFn.apply(c));
        }
       if (column < toDisplay.getWidth() - 1){
          bd.append("|");
        }        
      }
      bd.append(" " + (char)num + "\n");
    }
    return ans.toString()+bd.toString()+ans.toString();
  }

  /**
   * @return the String that represents self's boardTextView
   */
  public String displayMyOwnBoard() {
    return displayAnyBoard((c)->toDisplay.whatIsAtForSelf(c));
  }

  /**
   * @return the String that represents enemy's boardTextView
   */
  public String displayEnemyBoard(){
    return displayAnyBoard((c)->toDisplay.whatIsAtForEnemy(c));
  }

  /**
   * This makes the header lines, e.g. 0|1|2|3|4\n
   * 
   * @return the String that is the header line for the given board
   */
  String makeHeader() {
    StringBuilder ans = new StringBuilder("  "); // README shows two spaces at
    String sep=""; //start with nothing to separate, then switch to | to separate
    for (int i = 0; i < toDisplay.getWidth(); i++) {
      ans.append(sep);
      ans.append(i);
      sep = "|";
    }
    ans.append("\n");
    return ans.toString();
  }
}
