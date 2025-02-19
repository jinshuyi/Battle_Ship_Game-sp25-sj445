package edu.duke.sj445.battleship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShipRotationHitMap {
  /*
   * Caculate the new hit coordinates of the new ship
   * @param oldShip
   * @param newShip
   * @return set of coordinates of hit of new ship
   */
  public Set<Coordinate> Rotation(Ship<Character> oldShip, Ship<Character> newShip){
    Set<Coordinate> hitAt = new HashSet<Coordinate> (); 
    Coordinate oldUpperLeft = oldShip.getUpperLeft().getWhere();
    char oldOrientation = oldShip.getUpperLeft().getOrientation();
    Coordinate newUpperLeft = newShip.getUpperLeft().getWhere();
    char newOrientation = newShip.getUpperLeft().getOrientation();
    String name = oldShip.getName();
    List<Coordinate> oldC = new ArrayList<>();
    List<Coordinate> newC = new ArrayList<>();
    switch(name){
    case "Submarine":
       oldC = SubmarineHelper(oldUpperLeft, oldOrientation);
       newC = SubmarineHelper(newUpperLeft, newOrientation);
       break;
    case "Destroyer":
      oldC = DestroyerHelper(oldUpperLeft, oldOrientation);
      newC = DestroyerHelper(newUpperLeft, newOrientation);
      break;
    case "Battleship":
      oldC = BattleshipHelper(oldUpperLeft, oldOrientation);
      newC = BattleshipHelper(newUpperLeft, newOrientation);
      break;
    case "Carrier":
      oldC = CarrierHelper(oldUpperLeft, oldOrientation);
      newC = CarrierHelper(newUpperLeft, newOrientation);
      break;
    }
    
    for(int i = 0; i < oldC.size(); i++){
      if(oldShip.wasHitAt(oldC.get(i))){
        hitAt.add(newC.get(i));
      }
    }
    return hitAt;
  }

  protected List<Coordinate> SubmarineHelper(Coordinate upperLeft, char orientation){
    List<Coordinate> c = new ArrayList<>();
    c.add(upperLeft);
    if (orientation == 'V'){
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
    }
    else{
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 1));
    }
    return c;
  }

  protected List<Coordinate> DestroyerHelper(Coordinate upperLeft, char orientation){
    List<Coordinate> c = new ArrayList<>();
    c.add(upperLeft);
    if (orientation == 'V'){
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 2, upperLeft.getColumn()));
    }
    else{
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 2));
    }
    return c;
  }

  protected List<Coordinate> BattleshipHelper(Coordinate upperLeft, char orientation){
    List<Coordinate> c = new ArrayList<>();
    /*
     *     c(0)
     *c(1) c(2) c(3)
     */
    switch(orientation){
    case 'U':
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 2));
      break;
    case 'R':
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 1));
      c.add(upperLeft);
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 2, upperLeft.getColumn()));
      break;
    case 'D':
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 2));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 1));
      c.add(upperLeft);
      break;
    case 'L':
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 2, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 1));
      break;
    }
    return c;
  }

  protected List<Coordinate> CarrierHelper(Coordinate upperLeft, char orientation){
    List<Coordinate> c = new ArrayList<>();
     /*
       * c(0)
       * c(1)
       * c(2)c(4)
       * c(3)c(5)
       *     c(6)
       */
    switch(orientation){
    case 'U':
      c.add(upperLeft);
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 2, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 3, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 2, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 3, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 4, upperLeft.getColumn() + 1));
      break;
    case 'R':
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 4));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 3));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 2));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 2));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn())); 
      break;
    case 'D':
      c.add(new Coordinate(upperLeft.getRow() + 4, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 3, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 2, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 2, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
      c.add(upperLeft); 
      break;
    case 'L':
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn()));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 1));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 2));
      c.add(new Coordinate(upperLeft.getRow() + 1, upperLeft.getColumn() + 3));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 2));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 3));
      c.add(new Coordinate(upperLeft.getRow(), upperLeft.getColumn() + 4));  
      break;
    }
    return c;
  }
}
