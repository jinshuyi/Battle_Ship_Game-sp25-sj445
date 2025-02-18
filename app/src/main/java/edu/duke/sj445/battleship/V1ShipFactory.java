package edu.duke.sj445.battleship;

public class V1ShipFactory implements AbstractShipFactory<Character>{
  /**
	 * @param where the placement info, containing the coordinate and orientation
	 * @param w width of the ship
	 * @param h height of the ship
	 * @param letter the display char
	 * @param name the name of the ship
	 * create a rectangleship for V1
   */
  protected Ship<Character> createShip(Placement where, int w, int h, char letter, String name){
    if(where.getOrientation() == 'H'){
      int temp = w;
      w = h;
      h = temp;
    }
    return new RectangleShip<Character>(name, where.getWhere(), w, h, letter, '*', where);
  }
  @Override
  public Ship<Character> makeSubmarine(Placement where) {
    return createShip(where, 1, 2, 's', "Submarine");
  }

  @Override
  public Ship<Character> makeBattleship(Placement where) {
    return createShip(where, 1, 4, 'b', "Battleship");
  }

  @Override
  public Ship<Character> makeCarrier(Placement where) {
    return createShip(where, 1, 6, 'c', "Carrier");
  }

  @Override
  public Ship<Character> makeDestroyer(Placement where) {
    return createShip(where, 1, 3, 'd', "Destroyer");
  }

}
