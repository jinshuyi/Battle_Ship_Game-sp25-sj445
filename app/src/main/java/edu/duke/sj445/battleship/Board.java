package edu.duke.sj445.battleship;

import java.util.HashMap;

public interface Board<T> {
  public int getWidth();

  public int getHeight();

    /**
   * checks the validity of the placement and returns
   * null if the placement was ok, and error info if it was invalid 
   * 
   * @param toAdd is the ship added to the list
   * @return The validity of the placement.
   */
  public String tryAddShip(Ship<T> toAdd);

  /**
   * This method takes a Coordinate, and sees which (if any) Ship
   * occupies that coordinate.  If one is found, we return whatever
   * displayInfo it has at those coordinates (for now, just 's').  If
   * none is found, we return null.
   * 
   * @param where whether the ship accupies.
   * @return DisplayInfo or null
   */
  public T whatIsAtForSelf(Coordinate where);

  /**
   * @param where whether the ship accupies.
   * @return ship or null
   */
  public Ship<T> whichShipIsAtForSelf(Coordinate where);

  /**
   * fire at the given coordinate on the board
   * return the ship if hit
   * else record the miss and return null
   * @param c the coordinate to be fired at
   * @return the ship hit or null if miss
   */
  public Ship<T> fireAt(Coordinate c);

  /** 
   * Takes a Coordinate and see if any ship occupies that position
   * @param where is the position to check
   * @return the displayInfo for enemy's board at that position or 
   * null if none was found
   */
  public T whatIsAtForEnemy(Coordinate where);

  /** 
   * Takes a Coordinate and see if any enemy ship occupies that position
   * @param where is the position to check
   * @return the displayInfo for enemy's board at that position or 
   * null if none was found
   */
  public T whatIsAtForEnemySonar(Coordinate c);
  /**
   * check if the ships on this board is all sunk
   * @return if all ships are sunk, yes, else no
   */
  public boolean lose();

  /**
   * remove the given ship
   */
  public void removeShip(Ship<T> ship);

  /*
   * use sonar to detect ships nearby
   * @param where target coordinate
   * return info at where
   */
  public HashMap<T, Integer> SonarDetect(Coordinate where);
}


