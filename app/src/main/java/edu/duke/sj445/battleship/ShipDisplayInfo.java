package edu.duke.sj445.battleship;

public interface ShipDisplayInfo<T> {
       public T getInfo(Coordinate where, boolean hit);
}
