package edu.duke.sj445.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class V1ShipFactoryTest {

  private void checkShip(Ship<Character> testShip, String expectedName, char expectedLetter,
      Coordinate... expectedLocs) {
    assertEquals(testShip.getName(), expectedName);
    assertEquals(Character.toLowerCase(testShip.getName().charAt(0)), expectedLetter);
    for (Coordinate c : expectedLocs) {
      assertTrue(testShip.occupiesCoordinates(c));
    }
  }

  @Test
  public void test_with_Destroyer() {

    V1ShipFactory f = new V1ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'V');
    Ship<Character> dst = f.makeDestroyer(v1_2);
    checkShip(dst, "Destroyer", 'd', new Coordinate(1, 2), new Coordinate(2, 2), new Coordinate(3, 2));
    assertEquals(3,dst.getMyPieces_order().get(new Coordinate(3, 2)));
  }


  @Test
  public void test_with_Submarine(){

    V1ShipFactory f = new V1ShipFactory();
    Placement h1_2 = new Placement(new Coordinate(1, 2), 'H');
    Ship<Character> sbr = f.makeSubmarine(h1_2);
    checkShip(sbr, "Submarine", 's', new Coordinate(1, 2), new Coordinate(1, 3));
    assertEquals(1,sbr.getMyPieces_order().get(new Coordinate(1, 2)));

  }


  @Test
  public void test_with_Submarine_wrong(){
    V1ShipFactory f = new V1ShipFactory();
    Placement h1_2 = new Placement(new Coordinate(1, 2), 'd');
    assertThrows(IllegalArgumentException.class,()->f.makeSubmarine(h1_2));
  }



  @Test
  public void test_with_Destroyer_wrong(){
    V1ShipFactory f = new V1ShipFactory();
    Placement h1_2 = new Placement(new Coordinate(1, 2), 'd');
    assertThrows(IllegalArgumentException.class,()->f.makeDestroyer(h1_2));
  }

  @Test
  public void test_with_Battleship(){
V1ShipFactory f = new V1ShipFactory();

Placement v1_2 = new Placement(new Coordinate(1, 2), 'V');
Ship<Character> bts = f.makeBattleship(v1_2);
checkShip(bts, "Battleship", 'b', new Coordinate(1, 2), new Coordinate(2, 2),new Coordinate(3, 2),new Coordinate(4, 2));
  }



  @Test
  public void test_with_Carrier(){
    V1ShipFactory f = new V1ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'V');
    Ship<Character> car = f.makeCarrier(v1_2);
    checkShip(car, "Carrier", 'c', new Coordinate(1, 2), new Coordinate(2, 2),new Coordinate(3, 2),new Coordinate(4, 2), new Coordinate(5, 2), new Coordinate(6, 2));
  }
}
