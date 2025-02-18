package edu.duke.sj445.battleship;

public class V2ShipFactory implements AbstractShipFactory<Character> {

  /**
	 * @param upperLefts the upperleft coordinates
	 * @param widths width of the ship
	 * @param heights height of the ship
	 * @param letter the display char
	 * @param name the name of the ship
	 * create a ship for V2
	 */
  protected Ship<Character> createShip(Coordinate[] upperLefts, int[] widths, int[] heights, char letter, String name, Placement upperLeft){
		return new SpecialShip<Character>(name, upperLefts, widths, heights, letter, '*', upperLeft);
	}

  @Override
  public Ship<Character> makeSubmarine(Placement where) {
    char o = where.getOrientation();
    if(o!='H' && o!='V'){
      throw new IllegalArgumentException("That placement is invalid: it does not have the correct format.");
    }
    V1ShipFactory factoryV1 = new V1ShipFactory();
    return factoryV1.createShip(where,1,2,'s',"Submarine");
  }
  
  @Override
  public Ship<Character> makeBattleship(Placement where) {
    char o = where.getOrientation();
    if(o != 'U' && o != 'R' && o != 'D' && o != 'L'){
      throw new IllegalArgumentException("That placement is invalid: it does not have the correct format(U, R, D, L).");
    }
    int row = where.getWhere().getRow();
    int column = where.getWhere().getColumn();
    Coordinate[] upperLefts = new Coordinate[2];
    int[] widths = new int[2];
    int[] heights = new int[2];
    switch(o){
    case 'U':
      /*
       *  b
       * bbb
       */
      upperLefts[0] = new Coordinate(row, column + 1);
      widths[0] = 1;
      heights[0] = 1;
      upperLefts[1] = new Coordinate(row + 1, column);
      widths[1] = 3;
      heights[1] = 1;
      break;
    case 'R':
      /*
       * b
       * bb
       * b
       */
      upperLefts[0] = new Coordinate(row, column);
      widths[0] = 1;
      heights[0] = 3;
      upperLefts[1] = new Coordinate(row + 1, column + 1);
      widths[1] = 1;
      heights[1] = 1;
      break;
    case 'D':
      /*
       * bbb
       *  b
       */
      upperLefts[0] = new Coordinate(row, column);
      widths[0] = 3;
      heights[0] = 1;
      upperLefts[1] = new Coordinate(row + 1, column + 1);
      widths[1] = 1;
      heights[1] = 1;
      break;
    case 'L':
      /*
       *  b
       * bb
       *  b
       */
      upperLefts[0] = new Coordinate(row, column + 1);
      widths[0] = 1;
      heights[0] = 3;
      upperLefts[1] = new Coordinate(row + 1, column);
      widths[1] = 1;
      heights[1] = 1;
      break;
    }
    return createShip(upperLefts, widths, heights, 'b', "Battleship", where);
  }

  @Override
  public Ship<Character> makeCarrier(Placement where) {
    char o = where.getOrientation();
    if(o != 'U' && o != 'R' && o != 'D' && o != 'L'){
      throw new IllegalArgumentException("That placement is invalid: it does not have the correct format(U, R, D, L).");
    }
   
    int row = where.getWhere().getRow();
    int column = where.getWhere().getColumn();
    Coordinate[] upperLefts = new Coordinate[2];
    int[] widths = new int[2];
    int[] heights = new int[2];
    switch(o){
    case 'U':
      /*
       * c
       * c
       * cc
       * cc
       *  c
       */
      upperLefts[0] = new Coordinate(row, column);
      widths[0] = 1;
      heights[0] = 4;
      upperLefts[1] = new Coordinate(row + 2, column + 1);
      widths[1] = 1;
      heights[1] = 3;
      break;
    case 'R':
      /*
       *  cccc
       * ccc
       */
      upperLefts[0] = new Coordinate(row, column + 1);
      widths[0] = 4;
      heights[0] = 1;
      upperLefts[1] = new Coordinate(row + 1, column);
      widths[1] = 3;
      heights[1] = 1;
      break;
    case 'D':
      /*
       * c
       * cc
       * cc
       *  c
       *  c
       */
      upperLefts[0] = new Coordinate(row, column);
      widths[0] = 1;
      heights[0] = 3;
      upperLefts[1] = new Coordinate(row + 1, column + 1);
      widths[1] = 1;
      heights[1] = 4;
      break;
    case 'L':
      /*
       *   ccc
       * cccc
       */
      upperLefts[0] = new Coordinate(row, column + 2);
      widths[0] = 3;
      heights[0] = 1;
      upperLefts[1] = new Coordinate(row + 1, column);
      widths[1] = 4;
      heights[1] = 1;
      break;
     }
    return createShip(upperLefts, widths, heights, 'c', "Carrier", where);
  }

  @Override
  public Ship<Character> makeDestroyer(Placement where) {
    char o = where.getOrientation();
    if(o!='H' && o!='V'){
      throw new IllegalArgumentException("That placement is invalid: it does not have the correct format.");
    }
    V1ShipFactory factoryV1 = new V1ShipFactory();
    return factoryV1.createShip(where, 1, 3, 'd', "Destroyer");
  }

}
