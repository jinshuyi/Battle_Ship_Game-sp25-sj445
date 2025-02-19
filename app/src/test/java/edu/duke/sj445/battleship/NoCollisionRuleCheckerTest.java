package edu.duke.sj445.battleship;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NoCollisionRuleCheckerTest {
  @Test
  public void test_() {
    PlacementRuleChecker<Character> rc = new NoCollisionRuleChecker<Character>(null);
    Board<Character> b = new BattleShipBoard<Character>(10, 26, rc, 'X');
    V1ShipFactory f = new V1ShipFactory();

    Ship<Character> s1 = f.makeSubmarine(new Placement(new Coordinate(5,4),'H'));
    Ship<Character> s2 = f.makeSubmarine(new Placement(new Coordinate(5,3),'H'));
    
    assertEquals(rc.checkPlacement(s1,b),null);
    b.tryAddShip(s1);
    assertEquals(rc.checkPlacement(s2,b),"That placement is invalid: the ship overlaps another ship.");
  }
  
  @Test
  public void test_both(){
    PlacementRuleChecker<Character> rc = new NoCollisionRuleChecker<Character>(new InBoundsRuleChecker<Character>(null));
    Board<Character> b = new BattleShipBoard<Character>(10,26,rc, 'X');
    V1ShipFactory f = new V1ShipFactory();

    Ship<Character> s1 = f.makeSubmarine(new Placement(new Coordinate(5,4),'H'));
    Ship<Character> s2 = f.makeSubmarine(new Placement(new Coordinate(5,3),'H'));
    Ship<Character> s3 = f.makeBattleship(new Placement(new Coordinate(25,3),'V'));

    assertEquals(rc.checkPlacement(s1,b), null);
    b.tryAddShip(s1);
    assertEquals(rc.checkPlacement(s2,b),"That placement is invalid: the ship overlaps another ship.");
    assertEquals(b.tryAddShip(s2),"That placement is invalid: the ship overlaps another ship.");
    assertEquals(rc.checkPlacement(s3,b),"That placement is invalid: the ship goes off the bottom of the board.");
  }
}
