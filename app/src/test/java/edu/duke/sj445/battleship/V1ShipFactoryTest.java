package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class V1ShipFactoryTest {
  /**
   * check ship's name, locations
   * @param testShip: the ship need to be test
   * @param expectedName: expected ship name
   * @param expectedLetter: expected ship letter
   * @param expectedLocs: Coordinate[]
   */
  private void checkShip(Ship<Character> testShip, String expectedName,
                         char expectedLetter, Coordinate... expectedLocs){
    assertEquals(expectedName, testShip.getName());
    for(Coordinate c:expectedLocs){
      assertEquals(expectedLetter, testShip.getDisplayInfoAt(c, true));
      assertEquals(testShip.getDisplayInfoAt(c,false),null);
    }
  }

  @Test
  public void test_() {
    V1ShipFactory f = new V1ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'V');
    Ship<Character> dst = f.makeDestroyer(v1_2);
    checkShip(dst, "Destroyer", 'd', new Coordinate(1, 2), new Coordinate(2, 2), new Coordinate(3, 2));
    
    Placement v1_1 = new Placement(new Coordinate(1, 1), 'V');
    Ship<Character> sbmrn = f.makeSubmarine(v1_1);
    checkShip(sbmrn, "Submarine", 's', new Coordinate(1, 1), new Coordinate(2, 1));

    Placement v1_3 = new Placement(new Coordinate(1, 3), 'V');
    Ship<Character> bts = f.makeBattleship(v1_3);
    checkShip(bts, "Battleship", 'b', new Coordinate(1, 3), new Coordinate(2, 3), new Coordinate(3, 3), new Coordinate(4, 3));

    Placement v1_4 = new Placement(new Coordinate(1, 4), 'V');
    Ship<Character> Crer = f.makeCarrier(v1_4);
    checkShip(Crer, "Carrier", 'c', new Coordinate(1, 4), new Coordinate(2, 4), new Coordinate(3, 4), new Coordinate(4, 4), new Coordinate(5, 4), new Coordinate(6, 4));

    Placement h8_4 = new Placement(new Coordinate(8, 4), 'h');
    Ship<Character> Sbm2 = f.makeSubmarine(h8_4);
    checkShip(Sbm2, "Submarine", 's', new Coordinate(8, 4), new Coordinate(8, 5));

    Placement s10_10 = new Placement(new Coordinate(6, 10), 'h');
    //Ship<Character> sbm3 = f.makeSubmarine(s10_10);
    // assertThrows(IllegalArgumentException.class,
    //           () -> f.createShip(s10_10, 1, 1, 's', null));
  } 
}
