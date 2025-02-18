package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class SpecialShipTest {
  @Test
  public void test_makeCoords() {
    Coordinate[] c = new Coordinate[2];
    c[0] = new Coordinate(1,2);
    c[1] = new Coordinate(2,3);
    int[] widths = new int[2];
    int[] heights = new int[2];
    widths[0] = 2;
    widths[1] = 3;
    heights[0] = 1;
    heights[1] = 2;

    HashSet<Coordinate> hset = SpecialShip.makeCoords(c,widths,heights);
    for(int i = 0; i < c.length;i++){
      for(int row = c[i].getRow(); row < heights[i] + c[i].getRow();row++){
        for(int col = c[i].getColumn(); col < widths[i] + c[i].getColumn();col++){
          Coordinate curr = new Coordinate(row,col);
          assertEquals(hset.contains(curr),true);
        }
      }
    }
  }

  @Test
  public void test_constructor() {
    Coordinate[] c = new Coordinate[2];
    c[0] = new Coordinate(1,2);
    c[1] = new Coordinate(2,3);
    int[] widths = new int[2];
    int[] heights = new int[2];
    widths[0] = 1;
    widths[1] = 3;
    heights[0] = 1;
    heights[1] = 1;

    SpecialShip<Character> btship = new SpecialShip<Character>("Battleship", c, widths, heights, 'b', '*', new Placement(c[0], 'H'));
    assertEquals( new Placement(c[0], 'H'), btship.getUpperLeft());
    assertEquals(btship.getName(),"Battleship");
    assertThrows(IllegalArgumentException.class, () -> btship.wasHitAt(new Coordinate(c[0].getRow() - 1, c[0].getColumn())));
  }
}
