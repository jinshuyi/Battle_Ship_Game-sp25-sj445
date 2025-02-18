package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InBoundsRuleCheckerTest {
  @Test
  public void test_() {
    PlacementRuleChecker<Character> rc = new InBoundsRuleChecker<Character>(null);
    Board<Character> b = new BattleShipBoard<Character>(10, 26, rc, 'X');
    V1ShipFactory f = new V1ShipFactory();

    Ship<Character> s1 = f.makeBattleship(new Placement(new Coordinate(3,5),'H'));
    Ship<Character> s2 = f.makeBattleship(new Placement(new Coordinate(-1,2),'V'));
    Ship<Character> s3 = f.makeBattleship(new Placement(new Coordinate(26,2),'V'));
    Ship<Character> s4 = f.makeBattleship(new Placement(new Coordinate(2,-1),'H'));
    Ship<Character> s5 = f.makeBattleship(new Placement(new Coordinate(3,8),'H'));

    assertEquals(rc.checkPlacement(s1,b), null);
    assertEquals(rc.checkPlacement(s2,b),"That placement is invalid: the ship goes off the top of the board.");
    assertEquals(rc.checkPlacement(s3,b),"That placement is invalid: the ship goes off the bottom of the board.");
    assertEquals(rc.checkPlacement(s4,b),"That placement is invalid: the ship goes off the left of the board.");
    assertEquals(rc.checkPlacement(s5,b),"That placement is invalid: the ship goes off the right of the board.");
  }

}
