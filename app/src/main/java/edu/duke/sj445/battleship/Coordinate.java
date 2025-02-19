package edu.duke.sj445.battleship;

public class Coordinate {
  
  private final int row;
  private final int column;

  public int getRow(){
    return row;
  }
  public int getColumn(){
    return column;
  }

   /**
   * Constructs coordinate with the specified row
   * and column
   * @param r is the row of the newly constructed coordinate.
   * @param c is the column of the newly constructed coorndinate.
   */
  public Coordinate(int r, int c) {
    this.row = r;
    this.column = c;
  }

  /**
   * Constructs coordinate with the specified String(e.g. "A2")
   * @param descr can be transformed to the row and column of 
   * the newly constructed coordinate. (e.g. row = 0, column = 2)
   */
  public Coordinate(String descr) {
    if (descr.length() != 2 ){
       throw new IllegalArgumentException("Coordinate's String format must be 2 characters.");
    }
    descr = descr.toUpperCase();
    char rowLetter = descr.charAt(0);

    if (rowLetter < 'A' || rowLetter > 'Z'){
      throw new IllegalArgumentException("Coordinate's first character must be A-Z but is " + rowLetter);
    }
    this.row = rowLetter - 'A';
    
    char colLetter = descr.charAt(1);
    if (colLetter < '0' || colLetter > '9'){
      throw new IllegalArgumentException("Coordinate's column character must be 0-9 but is" + colLetter);
    }
    this.column = colLetter - '0';
  }

  @Override
  public boolean equals(Object o) {
    //requires that o has *exactly* the same class as "this" object
    if (o.getClass().equals(getClass())) {
      Coordinate c = (Coordinate) o;
      return row == c.row && column == c.column;
    }
    return false;
  }

  @Override
  public String toString() {
    return "("+row+", " + column+")";
  }
  @Override
  public int hashCode() {
    return toString().hashCode();
  }
}
