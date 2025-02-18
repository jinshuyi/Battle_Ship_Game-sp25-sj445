package edu.duke.sj445.battleship;

import java.util.HashSet;

public class RectangleShip<T> extends BasicShip<T>{

  final String name;
  final Placement _upperLeft;
  /**
   * make the right coordinate set, and pass them up to the
   * BasicShip constructor
   * @param name the name of the ship
   * @param upperLefts the upperleft coordinate for a rectangle ship
   * @param widths the width of the rectangle
   * @param heights the height of the rectangle
   * @param myDisplayInfo the display info for self board display
   * @param enemyDisplayInfo the display info for enemy board display
   * @param _upperLeft the reference point to be used in rotate
   */
  public RectangleShip(String name, Coordinate upperLeft, int width, int height, ShipDisplayInfo<T> info, ShipDisplayInfo<T> enemyDisplayInfo, Placement _upperLeft) {
    super(makeCoords(upperLeft, width, height), info, enemyDisplayInfo);
    this.name = name;
    this._upperLeft = _upperLeft;
  }

  public RectangleShip(String name, Coordinate upperLeft, int width, int height, T data, T onHit, Placement _upperLeft) {
    this(name, upperLeft, width, height, new SimpleShipDisplayInfo<T>(data, onHit), new SimpleShipDisplayInfo<T>(null, data), _upperLeft);
  }
  public RectangleShip(Coordinate upperLeft, T data, T onHit, Placement _upperLeft) {
    this("testship", upperLeft, 1, 1, data, onHit, _upperLeft);
  }

  /**
   * generate the set of coordinates for a rectangle starting
   * at upperLeft whose width and height are as specified.
   */
  static HashSet<Coordinate> makeCoords(Coordinate upperLeft, int width, int height){
    HashSet<Coordinate> ShipSet = new HashSet<Coordinate>();
    for (int i = 0; i < width; i++){
      for (int j = 0; j< height; j++){
        ShipSet.add(new Coordinate(upperLeft.getRow() + j, upperLeft.getColumn() + i));
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
