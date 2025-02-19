package edu.duke.sj445.battleship;


public class InBoundsRuleChecker<T> extends PlacementRuleChecker<T> {

  @Override
  protected String checkMyRule(Ship<T> theShip, Board<T> theBoard) {
    // TODO Auto-generated method stub
    for(Coordinate c : theShip.getCoordinates()){
      if(c.getRow() < 0){
        return "That placement is invalid: the ship goes off the top of the board.";
      }
      else if(c.getRow() >= theBoard.getHeight()){
        return "That placement is invalid: the ship goes off the bottom of the board.";
      }
      else if(c.getColumn() <0){
        return "That placement is invalid: the ship goes off the left of the board.";
      }
      else if(c.getColumn() >= theBoard.getWidth()){
        return "That placement is invalid: the ship goes off the right of the board.";
      }
    }
    return null;
  }

   @Override 
  protected String checkCollision(Ship<T> theShip, Board<T> theBoard){

    for(Coordinate c : theShip.getCoordinates()){
      if(theBoard.whatIsAtForSelf(c)!= null){
        return "That placement is invalid: the ship overlaps another ship.";
      }
    }
    return null;
  }

  public InBoundsRuleChecker(PlacementRuleChecker<T> next) {
    super(next);
  }

}








