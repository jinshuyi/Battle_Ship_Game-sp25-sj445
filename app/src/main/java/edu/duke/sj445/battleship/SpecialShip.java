package edu.duke.sj445.battleship;

import java.util.HashSet;

public class SpecialShip<T> extends BasicShip<T> {

  final String name;
  final Placement _upperLeft;
  /*
   * make the right coordinate set, and pass them up to the
   * BasicShip constructor
   * @param name the name of the ship
   * @param upperLefts the upperleft coordinate for a rectangle ship
   * @param widths the width of the rectangle
   * @param heights the height of the rectangle
   * @param myDisplayInfo the display info for self board display
   * @param enemyDisplayInfo the display info for enemy board display
   * @param upperLeft the reference point to be used in rotate
   */
  public SpecialShip(String name, Coordinate[] upperLefts, int[] widths, int[] heights, ShipDisplayInfo<T> info, ShipDisplayInfo<T> enemyDisplayInfo, Placement _upperLeft) {
    super(makeCoords(upperLefts, widths, heights), info, enemyDisplayInfo);
    this.name = name;
    this._upperLeft = _upperLeft;
  }
  public SpecialShip(String name, Coordinate[] upperLefts, int[] widths, int[] heights, T data, T onHit, Placement _upperLeft) {
    this(name, upperLefts, widths, heights, new SimpleShipDisplayInfo<T>(data, onHit), new SimpleShipDisplayInfo<T>(null, data), _upperLeft);
  }
  
  /**
   * generate the set of coordinates for an arrey of rectangle starting
   * at an array of upperLeft whose width and height are as specified.
   * @param upperLefts the upperlefts coordinate for a rectangle
   * @param widths the widths of a rectangle
   * @param heights the heights of a rectangle
   * @return a set of coordinates of the area combined by a series of rectangles
   */
  static HashSet<Coordinate> makeCoords(Coordinate[] upperLefts, int[] widths, int[] heights){
    HashSet<Coordinate> ShipSet = new HashSet<Coordinate>();
    for(int i = 0; i < upperLefts.length; i++){
      for(int w = 0; w < widths[i]; w++){
        for(int h = 0;h < heights[i]; h++){
          ShipSet.add(new Coordinate(upperLefts[i].getRow()+h, upperLefts[i].getColumn()+w));
        }
      }
    }
    return ShipSet;
  }

  /**
   * Get the name of this Ship
   * @return the name of this ship
   */
  public String getName(){
    return this.name;
  }

  /**
   * Get the upperleft point's info of this Ship
   * @return the placement of upperleft of this ship
   */
  public Placement getUpperLeft(){
    return this._upperLeft;
  }
}
