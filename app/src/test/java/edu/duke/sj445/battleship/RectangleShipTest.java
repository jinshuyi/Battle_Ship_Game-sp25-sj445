package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class RectangleShipTest {
  @Test
  public void test_makeCoords() {
     HashSet<Coordinate> ShipSet = new HashSet<Coordinate>();

     Coordinate c1 = new Coordinate(1, 2);
     Coordinate c2 = new Coordinate(2, 2);
     Coordinate c3 = new Coordinate(3, 2);
     Coordinate c4 = new Coordinate(0, 2);

     ShipSet.add(c1);
     ShipSet.add(c2);
     ShipSet.add(c3);
     ShipDisplayInfo<Character> info = new SimpleShipDisplayInfo<Character>('a', 'b');
     RectangleShip<Character> rc = new RectangleShip<Character>("submarine", c1, 1, 3, 's', '*', new Placement(c1, 'H'));
     
     assertEquals(true, rc.occupiesCoordinates(c1));
     assertEquals(true, rc.occupiesCoordinates(c2));
     assertEquals(true, rc.occupiesCoordinates(c3));
     assertEquals(false, rc.occupiesCoordinates(c4));
  }
  
  @Test
  public void test_Hit(){
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(2, 4);
    ShipDisplayInfo<Character> info = new SimpleShipDisplayInfo<Character>('a', 'b');
    RectangleShip<Character> rc = new RectangleShip<Character>("submarine", c1, 1, 3, 's', '*', new Placement(c1, 'H'));
    assertThrows(IllegalArgumentException.class, () -> rc.checkCoordinateInThisShip(c2));
    assertEquals(false, rc.wasHitAt(c1));
    rc.recordHitAt(c1);
    assertEquals(true, rc.wasHitAt(c1));
  }

  @Test
  public void test_sunk(){
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(2, 2);
    ShipDisplayInfo<Character> info = new SimpleShipDisplayInfo<Character>('a', 'b');
    RectangleShip<Character> rc = new RectangleShip<Character>("submarine", c1, 1, 2, 's', '*', new Placement(c1, 'H'));
    assertEquals("submarine", rc.getName());
    rc.recordHitAt(c1);
    assertEquals(false, rc.isSunk());
    rc.recordHitAt(c2);
    assertEquals(true, rc.isSunk());
  }

  @Test
  public void test_getCoordinates(){
    HashSet<Coordinate> c = new HashSet<Coordinate>();
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(2, 2);
    ShipDisplayInfo<Character> info = new SimpleShipDisplayInfo<Character>('a', 'b');
    RectangleShip<Character> rc = new RectangleShip<Character>("submarine", c1, 1, 2, 's', '*', new Placement(c1, 'H'));
    c.add(c1);
    c.add(c2);
    assertEquals(c, rc.getCoordinates());
  }
}
