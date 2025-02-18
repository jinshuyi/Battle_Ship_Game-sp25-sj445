package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class V2ShipFactoryTest {
  private void checkShip(Ship<Character> testShip, String expectedName,
                          char expectedLetter, Coordinate... expectedLocs){
    assertEquals(testShip.getName(),expectedName);
    for(Coordinate curr : expectedLocs){
      assertEquals(testShip.getDisplayInfoAt(curr,true),expectedLetter);
      assertEquals(testShip.getDisplayInfoAt(curr,false),null);
    }
  }
  @Test
  public void test_() {
    V2ShipFactory f = new V2ShipFactory();
    Placement v1_2 = new Placement(new Coordinate(1, 2), 'V');
    Ship<Character> dst = f.makeDestroyer(v1_2);
    checkShip(dst, "Destroyer", 'd', new Coordinate(1, 2), new Coordinate(2, 2), new Coordinate(3, 2));
    
    Placement v1_1 = new Placement(new Coordinate(1, 1), 'V');
    Ship<Character> sbmrn = f.makeSubmarine(v1_1);
    checkShip(sbmrn, "Submarine", 's', new Coordinate(1, 1), new Coordinate(2, 1));

    Placement u1_2 = new Placement(new Coordinate(1, 2), 'U');
    Placement r2_5 = new Placement(new Coordinate(2, 5), 'R');
    Placement d12_2 = new Placement(new Coordinate(12, 2), 'D');
    Placement l20_4 = new Placement(new Coordinate(20, 4),'L');

    assertThrows(IllegalArgumentException.class, ()->f.makeDestroyer(u1_2));
    assertThrows(IllegalArgumentException.class, ()->f.makeSubmarine(u1_2));
    assertThrows(IllegalArgumentException.class, ()->f.makeBattleship(v1_2));
    assertThrows(IllegalArgumentException.class, ()->f.makeCarrier(v1_2));
    

    Ship<Character> btship1 = f.makeBattleship(u1_2);
    Ship<Character> btship2 = f.makeBattleship(r2_5);
    Ship<Character> btship3 = f.makeBattleship(d12_2);
    Ship<Character> btship4 = f.makeBattleship(l20_4);

    checkShip(btship1, "Battleship", 'b',
              new Coordinate(1, 3),
              new Coordinate(2, 2),
              new Coordinate(2, 3),
              new Coordinate(2, 4));
    checkShip(btship2, "Battleship", 'b',
              new Coordinate(2, 5),
              new Coordinate(3, 5),
              new Coordinate(4, 5),
              new Coordinate(3, 6));  
    checkShip(btship3, "Battleship", 'b',
              new Coordinate(12, 2),
              new Coordinate(12, 3),
              new Coordinate(12, 4),
              new Coordinate(13, 3));
    checkShip(btship4, "Battleship", 'b',
              new Coordinate(20, 5),
              new Coordinate(21, 4),
              new Coordinate(21, 5),
              new Coordinate(22, 5));

    Ship<Character> crr1 = f.makeCarrier(u1_2);
    Ship<Character> crr2 = f.makeCarrier(r2_5);
    Ship<Character> crr3 = f.makeCarrier(d12_2);
    Ship<Character> crr4 = f.makeCarrier(l20_4);

    checkShip(crr1, "Carrier", 'c',
              new Coordinate(1, 2),
              new Coordinate(2, 2),
              new Coordinate(3, 2),
              new Coordinate(4, 2),
              new Coordinate(3, 3),
              new Coordinate(4, 3),
              new Coordinate(5, 3));
    checkShip(crr2, "Carrier", 'c',
              new Coordinate(2, 6),
              new Coordinate(2, 7),
              new Coordinate(2, 8),
              new Coordinate(2, 9),
              new Coordinate(3, 5),
              new Coordinate(3, 6),
              new Coordinate(3, 7));  
    checkShip(crr3, "Carrier", 'c',
              new Coordinate(12, 2),
              new Coordinate(13, 2),
              new Coordinate(14, 2),
              new Coordinate(13, 3),
              new Coordinate(14, 3),
              new Coordinate(15, 3),
              new Coordinate(16, 3));
    checkShip(crr4, "Carrier", 'c',
              new Coordinate(20, 6),
              new Coordinate(20, 7),
              new Coordinate(20, 8),
              new Coordinate(21, 4),
              new Coordinate(21, 5),
              new Coordinate(21, 6),
              new Coordinate(21, 7));
  }
}
