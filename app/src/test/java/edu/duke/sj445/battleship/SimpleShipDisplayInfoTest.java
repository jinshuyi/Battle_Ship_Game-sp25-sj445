package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleShipDisplayInfoTest {
  @Test
  public void test_() {
    Coordinate c1 = new Coordinate(1, 1);
    Character myData = 'a';
    Character onHit = 'b';
    ShipDisplayInfo<Character> ship = new SimpleShipDisplayInfo<Character>(myData, onHit);
    assertEquals('a', ship.getInfo(c1, false));
    assertEquals('b', ship.getInfo(c1, true));
  }

}
