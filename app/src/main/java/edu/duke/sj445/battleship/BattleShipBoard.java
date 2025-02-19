package edu.duke.sj445.battleship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This class handles size of
 * a Board (width and heght).
 */
public class BattleShipBoard<T> implements Board<T> {
  private final int width;
  private final int height;

  final ArrayList<Ship<T>> myShips;
  private final PlacementRuleChecker<T> placementChecker;

  HashSet<Coordinate> enemyMisses;
  HashMap<Coordinate, T> enemyHits;
  final T missInfo;
  
  /**
   * Methods that get width
   */
  public int getWidth(){
    return width;
  }
  
  /**
   * Methods that get height
   */
  public int getHeight(){
    return height;
  }

   /**
   * Constructs a BattleShipBoard with the specified width
   * and height
   * @param w is the width of the newly constructed board.
   * @param h is the height of the newly constructed board.
   * @throws IllegalArgumentException if the width or height are less than or equal to zero.
   */
  public BattleShipBoard(int w, int h, PlacementRuleChecker<T> placementChecker, T missInfo) {
    if (w <= 0) {
      throw new IllegalArgumentException("BattleShipBoard's width must be positive but is " + w);
    }
    if (h <= 0) {
      throw new IllegalArgumentException("BattleShipBoard's height must be positive but is " + h);
    }
    this.width = w;
    this.height = h;
    this.myShips = new ArrayList<Ship<T>>();
    this.placementChecker = placementChecker;
    this.enemyMisses = new HashSet<Coordinate>();
    this.missInfo = missInfo;
    this.enemyHits = new HashMap<Coordinate,T>();
  }
  public BattleShipBoard(int w, int h, T missInfo) {
    this(w, h, new NoCollisionRuleChecker<>(new InBoundsRuleChecker<T>(null)), missInfo);
  }

  /** 
   * Check if the ship can be added, then add it to the board or give up
   * @param toAdd is a ship
   * @return if the placement is valid, return null, else return the error message
   */
  public String tryAddShip(Ship<T> toAdd){
    String placementProblem = this.placementChecker.checkPlacement(toAdd, this);
    if(placementProblem != null){
      return placementProblem;
    }
    else{
      this.myShips.add(toAdd);
      return null;
    }
  }
  
  /** 
   * Takes a Coordinate and see if any ship occupies that position
   * @param where is the position to check
   * @return the displayInfo at that position or 
   * null if none was found
   */
  protected T whatIsAt(Coordinate where, boolean isSelf){
    for (Ship<T> s: myShips) {
      if (s.occupiesCoordinates(where)){
        if(!isSelf && !enemyHits.containsKey(where) && s.wasHitAt(where)){
          return null;
        }
        return s.getDisplayInfoAt(where, isSelf);
      }
    }
    return null;

  }
  public T whatIsAtForSelf(Coordinate where) {
    return whatIsAt(where, true);
  }

  public Ship<T> whichShipIsAtForSelf(Coordinate where){
    for(Ship<T> s : myShips){
      if(s.occupiesCoordinates(where)){
        return s;
      }
    }
    return null;
  }

  /**
   * fire at the given coordinate on the board
   * return the ship if hit
   * else record the miss and return null
   * @param c the coordinate to be fired at
   * @return the ship hit or null if miss
   */
  public Ship<T> fireAt(Coordinate c){
    for(Ship<T> s : myShips){
      if(s.occupiesCoordinates(c)){
        s.recordHitAt(c);
        enemyHits.put(c,s.getDisplayInfoAt(c,false));
        if(enemyMisses.contains(c)){
          enemyMisses.remove(c);
        }
        return s;
      }
    }
    enemyMisses.add(c);
    enemyHits.remove(c);
    return null;
  }
    
  public T whatIsAtForEnemy(Coordinate where) {
    if(enemyMisses.contains(where)){
      return missInfo;
    }
    if(enemyHits.containsKey(where)){
      return enemyHits.get(where);
    }
    return whatIsAt(where, false);
  }

  public T whatIsAtForEnemySonar(Coordinate c){
    for (Ship<T> s: myShips) {
      if (s.occupiesCoordinates(c)){
        if(s.wasHitAt(c)){
          return s.getDisplayInfoAt(c,false);
        }else{
          return s.getDisplayInfoAt(c,true);
        }
      }
    }
    return null;
  }

  /**
   * check if the ships on this board is all sunk
   * @return if all ships are sunk, yes, else no
   */
  public boolean lose(){
    for(Ship<T> s : myShips){
      if(!s.isSunk()){
        return false;
      }
    }
    return true;
  }

  /**
   * remove the given ship
   */
  public void removeShip(Ship<T> ship){
    myShips.remove(ship);
  }

  /*
   * move ship to target coordinate
   * @param where target coordinate
   */

  
   /*
   * use sonar to detect ships nearby
   * @param where target coordinate
   * @return info at where 
   */
  public HashMap<T, Integer> SonarDetect(Coordinate where){
    HashMap<T, Integer> ship = new HashMap<T, Integer>();
    int row = where.getRow();
    int column = where.getColumn();
    for (int i = row - 3; i <= row + 3; i++){
      if (i >= 0){
        int temp = Math.abs(i - row)-3;
      for (int j = column + temp; j <= column - temp; j++){
        if (j >= 0){
          Coordinate c = new Coordinate(i, j);
          T item = whatIsAtForEnemySonar(c);
          if (item != null){
            ship.put(item, ship.getOrDefault(item, 0) + 1);
          }
        }
      }
      }
    }
    return ship;
  }
}
