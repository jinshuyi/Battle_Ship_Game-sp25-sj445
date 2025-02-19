package edu.duke.sj445.battleship;

import java.util.HashMap;

public abstract class BasicShip<T> implements Ship<T> {

  /**
   * myPieces.get(c) = null, c is not part of this Ship
   * myPieces.get(c) = false, c is part of this ship and has not been hit
   * myPieces.get(c) = true, c is part of this ship and has been hit
   */
  protected HashMap<Coordinate, Boolean> myPieces;
  protected ShipDisplayInfo<T> myDisplayInfo;

  protected ShipDisplayInfo<T> enemyDisplayInfo;


  public BasicShip(Iterable<Coordinate> where, ShipDisplayInfo<T> myDisplayInfo, ShipDisplayInfo<T> enemyDisplayInfo){
    this.myDisplayInfo = myDisplayInfo;
    this.myPieces = new HashMap<Coordinate, Boolean>();
    for(Coordinate c: where){
      this.myPieces.put(c, false);
    }
    this.enemyDisplayInfo = enemyDisplayInfo;
  }

  /**
   * check if c is part of this ship (in myPieces),
   * and if not, throw an IllegalArgumentException.
   */
  protected void checkCoordinateInThisShip(Coordinate c){
    if(!this.myPieces.containsKey(c)){
      throw new IllegalArgumentException("This ship dose not contains that coordinate.");
    }
  }

  @Override
  public boolean occupiesCoordinates(Coordinate where) {
    // TODO Auto-generated method stub
    return this.myPieces.containsKey(where);
  }

  @Override
  public boolean isSunk() {
    // TODO Auto-generated method stub
    for (HashMap.Entry<Coordinate, Boolean> set : myPieces.entrySet()) {
      // iterate all elements
      if (!set.getValue()){
        return false;
      }
    }
    return true;
  }

  @Override
  public void recordHitAt(Coordinate where) {
    // TODO Auto-generated method stub
    checkCoordinateInThisShip(where);
    this.myPieces.put(where, true);
  }

  @Override
  public boolean wasHitAt(Coordinate where) {
    // TODO Auto-generated method stub
    checkCoordinateInThisShip(where);
    return this.myPieces.get(where);
  }

  @Override
  public T getDisplayInfoAt(Coordinate where, boolean myShip) {
   //TODO this is not right.  We need to
    //look up the hit status of this coordinate
    checkCoordinateInThisShip(where);
    if(myShip){
			return myDisplayInfo.getInfo(where, wasHitAt(where));
		}else{
			return enemyDisplayInfo.getInfo(where, wasHitAt(where));
		}
  }

  @Override
  public Iterable<Coordinate> getCoordinates(){
    return myPieces.keySet(); 
  }
}
