package edu.duke.sj445.battleship;

public class InBoundsRuleChecker<T> extends PlacementRuleChecker<T> {

  /**
   * check if the ship to be placed is in the bound of the board
   */
  public InBoundsRuleChecker(PlacementRuleChecker<T> next) {
    super(next);
  }
  /**
   * @param theShip the ship to be placed
   * @param theBoard the board where the ship to be placed
   * @return if error exists, return the error message, else return null 
   * check if the board and ship satisfies this rule
   */
  @Override
  protected String checkMyRule(Ship<T> theShip, Board<T> theBoard) {
    int Width = theBoard.getWidth();
    int Height = theBoard.getHeight();
    for (Coordinate C : theShip.getCoordinates()){
      int Row = C.getRow();
      int Column = C.getColumn();
      if( Row < 0){
        return "That placement is invalid: the ship goes off the top of the board.";
      }else if(Row >= Height){
        return "That placement is invalid: the ship goes off the bottom of the board.";
      }else if(Column < 0){
        return "That placement is invalid: the ship goes off the left of the board.";
      }else if(Column >= Width){
        return "That placement is invalid: the ship goes off the right of the board.";
      }
    }
    return null;
  }

}
