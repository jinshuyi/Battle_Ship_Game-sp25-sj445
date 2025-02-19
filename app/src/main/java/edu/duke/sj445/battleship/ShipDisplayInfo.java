package edu.duke.sj445.battleship;
/*
<T> is so that we can track different
information for different Views.  For our text views,
it will be a Character.  
 */

public interface ShipDisplayInfo<T> {
  public T getInfo(Coordinate where, boolean hit);
}
