package edu.duke.sj445.battleship;


/**
   * Constructs a Coordinate  with the specified row
   * and coordinate
   * @param row is the Abscissa.
   * @param column is the ordinate.
   * @throws IllegalArgumentException if the length of the string is invalid(e.g "A") or the there are extra char (e.g"A12").
   * @throws IllegalArgumentException if the characters in the string are invalid(e.g "/@"). 
   */


public class Coordinate {
  private final int row;
  private final int column;

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public Coordinate(int r, int c) {
    this.row = r;
    this.column = c;
  }

  public Coordinate(String descr) {

    int r = 0;
    int c = 0;

    if (descr.length() < 2) {
      throw new IllegalArgumentException("The string length is not correct");
    }

    for (int i = 0; i < descr.length(); ++i) {
      if (i == 0) {
        char rowLetter = Character.toUpperCase(descr.charAt(i));

        if (rowLetter < 'A' || rowLetter > 'Z') {
          throw new IllegalArgumentException("The rowLetter is not correct" + rowLetter);
        }

        r = rowLetter - 'A';

      }

      if (i == 1) {

        char columnLetter = descr.charAt(i);
        if (!Character.isDigit(columnLetter)) {
          throw new IllegalArgumentException("The columnLetter is not correct" + columnLetter);
        }
        c = Character.getNumericValue(columnLetter);
      }

      if (i > 1) {
        throw new IllegalArgumentException("The length of the string is beyond the bourdary");
      }
    }
    this.row = r;
    this.column = c;
  }

  @Override
  public boolean equals(Object o) {
    if (o.getClass().equals(getClass())) {
      Coordinate c = (Coordinate) o;
      return row == c.row && column == c.column;
    }
    return false;
  }

  @Override
  public String toString() {
    return "(" + row + ", " + column + ")";
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

}
