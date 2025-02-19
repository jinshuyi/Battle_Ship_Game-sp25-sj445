package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ShipRotationHitMapTest {
  @Test
  public void test_() {
    ShipRotationHitMap srhm = new ShipRotationHitMap();
    V2ShipFactory f = new V2ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'V');
    Ship<Character> sm = f.makeSubmarine(v1_2);

    Placement v6_6 = new Placement(new Coordinate(6, 6), 'H');
    Ship<Character> sm2 = f.makeSubmarine(v6_6);
    Set<Coordinate> ans = new HashSet<Coordinate> ();
    sm.recordHitAt(new Coordinate(2, 2));
    ans.add(new Coordinate(6, 7));
    assertEquals(ans, srhm.Rotation(sm, sm2));    
  }

  @Test
  public void test_destroy(){
    ShipRotationHitMap srhm = new ShipRotationHitMap();
    V2ShipFactory f = new V2ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'V');
    Ship<Character> sm = f.makeDestroyer(v1_2);
    Placement v6_6 = new Placement(new Coordinate(6, 6), 'H');
    Ship<Character> sm2 = f.makeDestroyer(v6_6);
    Set<Coordinate> ans = new HashSet<Coordinate> ();
    assertEquals(ans, srhm.Rotation(sm, sm2));
  }
  
  @Test
  public void test_battleship(){
    ShipRotationHitMap srhm = new ShipRotationHitMap();
    V2ShipFactory f = new V2ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'U');
    Ship<Character> sm = f.makeBattleship(v1_2);
    Placement v6_6 = new Placement(new Coordinate(6, 6), 'R');
    Ship<Character> sm2 = f.makeBattleship(v6_6);
    Set<Coordinate> ans = new HashSet<Coordinate> ();
    assertEquals(ans, srhm.Rotation(sm, sm2));
    Placement v9_6 = new Placement(new Coordinate(9, 6), 'L');
    Ship<Character> sm3 = f.makeBattleship(v9_6);
    Placement v13_3 = new Placement(new Coordinate(13, 3), 'D');
    Ship<Character> sm4 = f.makeBattleship(v13_3);
    assertEquals(ans, srhm.Rotation(sm3, sm4));
  }

  
  @Test
  public void test_carrier(){
    ShipRotationHitMap srhm = new ShipRotationHitMap();
    V2ShipFactory f = new V2ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'U');
    Ship<Character> sm = f.makeCarrier(v1_2);
    Placement v6_6 = new Placement(new Coordinate(6, 6), 'D');
    Ship<Character> sm2 = f.makeCarrier(v6_6);
    Set<Coordinate> ans = new HashSet<Coordinate> ();
    assertEquals(ans, srhm.Rotation(sm, sm2));

    Placement v8_2 = new Placement(new Coordinate(8, 2), 'R');
    Ship<Character> sm3 = f.makeCarrier(v8_2);
    Placement v14_6 = new Placement(new Coordinate(14, 6), 'L');
    Ship<Character> sm4 = f.makeCarrier(v14_6);
    Set<Coordinate> ans2 = new HashSet<Coordinate> ();
    assertEquals(ans2, srhm.Rotation(sm3, sm4));

  }
  
}
