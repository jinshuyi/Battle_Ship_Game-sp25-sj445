package edu.duke.sj445.battleship;

public class Placement {
  final Coordinate where;
  final char orientation;

  Coordinate getWhere(){
    return where;
  }

  char getOrientation(){
    return orientation;
  }

  /**
   * Constructs Placement with the specified coordinate
   * and character
   * @param w is the coordinate.
   * @param o is the orientation.
   */
  public Placement(Coordinate w, char o) {
    this.where = w;
    o = Character.toUpperCase(o);
    if(o!='H' && o!='V' && o != 'U' && o != 'R' && o != 'D' && o != 'L'){
      throw new IllegalArgumentException("That placement is invalid: it does not have the correct format.");
    }
    this.orientation = o;
  }

  /**
   * Constructs placement with the specified String(e.g. "A0V")
   * @param descr can be transformed to the orientation placed at 
   * row and column of coordinate. (e.g. "V" at row = 0, column = 0)
   */
  public Placement(String descr){
    if (descr.length() < 2){
      throw new IllegalArgumentException("That placement is invalid: it does not have the correct format."); 
    }
    Coordinate c = new Coordinate(descr.substring(0, 2));
    this.where = c;

    char o = descr.toUpperCase().charAt(descr.length() - 1);
    if(o!='H' && o!='V' && o != 'U' && o != 'R' && o != 'D' && o != 'L'){
      throw new IllegalArgumentException("That placement is invalid: it does not have the correct format.");
    }
    this.orientation = o;
  }

  @Override
  public boolean equals(Object p) {
    //requires that o has *exactly* the same class as "this" object
    if (p.getClass().equals(getClass())) {
      Placement c = (Placement) p;
      if(where.equals(c.where)){        
        return orientation == c.orientation;
      }
      return false;
    }
    return false;
  }

  @Override
  public String toString() {
    return Integer.toString(where.getRow()) + where.getColumn() + this.orientation;
  }
  @Override
  public int hashCode() {
    return toString().hashCode();
  }

}
