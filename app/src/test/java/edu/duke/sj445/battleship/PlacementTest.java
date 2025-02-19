package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlacementTest {
  @Test
  public void test_() {
    Coordinate c1 = new Coordinate(10, 20);
    Placement  p1 = new Placement(c1, 'v');
    assertEquals(c1, p1.getWhere());
    assertEquals('V', p1.getOrientation());
  }

  @Test
  public void test_equals() {
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(1, 2);
    Coordinate c3 = new Coordinate(1, 3);
    Coordinate c4 = new Coordinate(3, 2);

    Placement  p1 = new Placement(c1, 'v');
    Placement  p2 = new Placement(c2, 'v');
    Placement  p3 = new Placement(c3, 'v');
    Placement  p4 = new Placement(c4, 'v');
    
    assertEquals(p1, p1);   //equals should be reflexsive
    assertEquals(p1, p2);   //different objects bu same contents
    assertNotEquals(p1, p3);  //different contents
    assertNotEquals(p1, p4);
    assertNotEquals(p3, p4);
    assertNotEquals(p1, "12V"); //different types
  }

  @Test
  public void test_toString() {
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(1, 2);
    Coordinate c3 = new Coordinate(0, 3);
    Coordinate c4 = new Coordinate(0, 3);

    Placement  p1 = new Placement(c1, 'v');
    Placement  p2 = new Placement(c2, 'v');
    Placement  p3 = new Placement(c3, 'v');
    Placement  p4 = new Placement(c4, 'h');
    
    assertEquals(p1.toString(), p1.toString());
    assertEquals("12V", p1.toString());
    assertEquals(p1.toString(), p2.toString());
    assertNotEquals(p1.toString(), p4.toString());
    assertNotEquals(p3.toString(), p4.toString());
  }
  
  @Test
  public void test_hashCode() {
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(1, 2);
    Coordinate c3 = new Coordinate(0, 3);
    Coordinate c4 = new Coordinate(0, 3);

    Placement  p1 = new Placement(c1, 'v');
    Placement  p2 = new Placement(c2, 'v');
    Placement  p3 = new Placement(c3, 'v');
    Placement  p4 = new Placement(c4, 'v');
    
    assertEquals(p1.hashCode(), p2.hashCode());
    assertNotEquals(p1.hashCode(), p3.hashCode());
    assertNotEquals(p1.hashCode(), p4.hashCode());
  }

  
@Test
  void test_string_constructor_valid_cases() {
    Placement p1 = new Placement("B3v");
    Coordinate c1 = new Coordinate("B3");
    assertEquals(c1, p1.getWhere());
    assertEquals('V', p1.getOrientation());
    
    Coordinate c2 = new Coordinate("D5");
    Placement p2 = new Placement("D5h");
    assertEquals(c2, p2.getWhere());
    assertEquals('H', p2.getOrientation());
  }
  @Test
  public void test_string_constructor_error_cases() {
    assertThrows(IllegalArgumentException.class, () -> new Placement("0"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("000"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("AAA"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("B3//"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("B3 b"));
    assertThrows(IllegalArgumentException.class, () -> new Placement("B3a"));
    assertThrows(IllegalArgumentException.class, () -> new Placement(new Coordinate("A4"), 'a'));
  }

}
