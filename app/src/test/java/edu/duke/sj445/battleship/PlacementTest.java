package edu.duke.sj445.battleship;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlacementTest {

  @Test
  public void test_with_coord_and_orientation() {
    Coordinate c1 = new Coordinate(1, 2);
    Placement p1 = new Placement(c1, 'v');
    assertEquals(c1, p1.getCoordinate());
    assertEquals('V', p1.getOrientation());
  }

  @Test
  public void test_equals() {
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(1, 2);
    Coordinate c3 = new Coordinate(1, 3);
    Coordinate c4 = new Coordinate(3, 2);

    Placement p1 = new Placement(c1, 'v');
    Placement p2 = new Placement(c2, 'V');
    Placement p3 = new Placement(c3, 'h');
    Placement p4 = new Placement(c3, 'v');
    Placement p5 = new Placement(c3, 'H');
    Placement p6 = new Placement(c4, 'H');
    assertEquals(p1, p2);
    assertEquals(p3, p5);
    assertNotEquals(p3, p4);
    assertNotEquals(p1, p4);
    assertNotEquals(p1, p3);
    assertNotEquals(p2, p6);
    assertNotEquals(p1, "(1,2)");
  }

  @Test
  public void test_hashCode() {
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(1, 2);
    // Coordinate c3 = new Coordinate(0, 3);
    // Coordinate c4 = new Coordinate(2, 1);
    Placement p1 = new Placement(c1, 'v');
    Placement p2 = new Placement(c2, 'V');
    assertEquals(p1.hashCode(), p2.hashCode());

  }

  @Test
  void test_string_constructor_valid_cases() {
    Coordinate c1 = new Coordinate("B3");
    Placement p1 = new Placement(c1, 'v');
    assertEquals(1, p1.getCoordinate().getRow());
    assertEquals(3, p1.getCoordinate().getColumn());
    assertEquals('V', p1.getOrientation());

    Coordinate c2 = new Coordinate("D5");
    Placement p2 = new Placement(c2, 'h');
    assertEquals(3, p2.getCoordinate().getRow());
    assertEquals(5, p2.getCoordinate().getColumn());
    assertEquals('H', p2.getOrientation());
    
    Coordinate c3 = new Coordinate("A9");
    Placement p3 = new Placement(c3, 'h');
    assertEquals(0, p3.getCoordinate().getRow());
    assertEquals(9, p3.getCoordinate().getColumn());
    assertEquals('H', p3.getOrientation());
    
    Coordinate c4 = new Coordinate("Z0");
    Placement p4 = new Placement(c4, 'v');
    assertEquals(25, p4.getCoordinate().getRow());
    assertEquals(0, p4.getCoordinate().getColumn());
    assertEquals('V', p4.getOrientation());


    Placement p5 = new Placement( "Z0v");
    assertEquals('V', p5.getOrientation());

    Placement p6 = new Placement( "Z0H");
    assertEquals('H', p6.getOrientation());
  }



  @Test
  public void test_string_constructor_error_cases(){
    assertThrows(IllegalArgumentException.class, () -> new Placement("00v"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("AAV"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("@0h"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("[0H"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("A/h"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("A:v"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("Avt"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("A12"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("A12g"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("A1"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("A9G"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("A"));
  }
}
