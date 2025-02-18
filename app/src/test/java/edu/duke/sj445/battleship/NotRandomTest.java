package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NotRandomTest {
  @Test
  public void test_() {
    NotRandom myrandom = new NotRandom();
    assertEquals(1, myrandom.nextInt(1));
    assertEquals("k9", myrandom.placeCoordinate());
  }

}
