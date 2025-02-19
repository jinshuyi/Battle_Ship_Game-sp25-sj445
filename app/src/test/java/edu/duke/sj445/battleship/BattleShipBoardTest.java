package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
                                        
public class BattleShipBoardTest {
  @Test
  public void test_() {
    BattleShipBoard<Character> b1 = new BattleShipBoard<Character>(10, 20, 'X');
    assertEquals(10, b1.getWidth());
    assertEquals(20, b1.getHeight());

 }
  @Test
  public void test_invalid_dimensions() {
    assertThrows(IllegalArgumentException.class, () -> new BattleShipBoard<Character>(10, 0, 'X'));
    assertThrows(IllegalArgumentException.class, () -> new BattleShipBoard<Character>(0, 20, 'X'));
    assertThrows(IllegalArgumentException.class, () -> new BattleShipBoard<Character>(10, -5, 'X'));
    assertThrows(IllegalArgumentException.class, () -> new BattleShipBoard<Character>(-8, 20, 'X'));
  }

   @Test
   public void test_width_and_height() {
    Board<Character> b1 = new BattleShipBoard<Character>(10, 20, 'X');
    assertEquals(10, b1.getWidth());
    assertEquals(20, b1.getHeight());
  }
  
  private <T> void checkWhatIsAtBoard(BattleShipBoard<T> b, T[][] expected){
    if (b.getWidth() != expected.length || b.getHeight() != expected[0].length){
      throw new IllegalArgumentException("Board size expected (" + b.getWidth() + ", " + b.getHeight() + ") but got (" + expected.length + ", " + expected[0].length + ")");
    }
    for (int i = 0; i < b.getWidth(); i++){
      for (int j = 0; j< b.getHeight(); j++){
        if (b.whatIsAtForSelf(new Coordinate(i, j)) != expected[i][j]){
          throw new IllegalArgumentException("Elements not match.");
        }
      }
    }
  }
  
  @Test
  public void test_board_starts_empty(){
    BattleShipBoard<Character> b1 = new BattleShipBoard<Character>(3, 3, 'X');
    Character[][] nullBoard1 = new Character[3][3];
    Character[][] nullBoard2 = new Character[3][4];
    checkWhatIsAtBoard(b1, nullBoard1);
    assertThrows(IllegalArgumentException.class , () -> checkWhatIsAtBoard(b1, nullBoard2));
    nullBoard1[0][0] = 'a';
    assertThrows(IllegalArgumentException.class , () -> checkWhatIsAtBoard(b1, nullBoard1));
  }

  @Test
  public void test_add_ship(){
    BattleShipBoard<Character> b1 = new BattleShipBoard<Character>(3, 3, 'X');
    Character[][] nullBoard1 = new Character[3][3];
    nullBoard1[1][1] = 's';
    Placement p1 = new Placement(new Coordinate(1, 1), 'v');
    RectangleShip<Character> ship = new RectangleShip<Character>(p1.getWhere(), 's', '*', p1);
    assertEquals(null, b1.tryAddShip(ship));
    assertEquals('s', b1.whatIsAtForSelf(p1.getWhere()));
    checkWhatIsAtBoard(b1, nullBoard1);
    
  }

  @Test
  public void test_fireAt() {
    BattleShipBoard<Character> b = new BattleShipBoard<Character>(5, 5, 'X');
    V1ShipFactory f = new V1ShipFactory();
    Placement h1_2 = new Placement(new Coordinate(1, 2), 'H');
    Ship<Character> sbr = f.makeSubmarine(h1_2);
    b.tryAddShip(sbr);
    assertEquals('s', b.whatIsAtForEnemySonar(new Coordinate(1, 2)));
    assertSame(sbr, b.fireAt(new Coordinate(1, 2)));
    Coordinate h2_2 = new Coordinate(2,2);
    assertEquals(b.whatIsAtForEnemy(h2_2),null);
    assertEquals(b.whatIsAtForEnemy(new Coordinate(1, 2)),'s');
    assertEquals(b.fireAt(h2_2),null);
    
    assertEquals(b.whatIsAtForEnemy(h2_2), 'X');
    b.tryAddShip(sbr);
    assertEquals(sbr, b.whichShipIsAtForSelf(new Coordinate(1, 2)));
    assertEquals(null, b.whichShipIsAtForSelf(new Coordinate(10, 2)));
    assertEquals('s', b.whatIsAtForEnemySonar(new Coordinate(1, 2)));
    assertEquals(null, b.whatIsAtForEnemySonar(new Coordinate(10, 2)));
    b.fireAt(new Coordinate(1, 2));
    b.removeShip(sbr);
    assertEquals(b.fireAt(new Coordinate(1, 2)), null);
    Ship<Character> sbr2 = f.makeSubmarine( new Placement(new Coordinate(3, 2), 'H'));
    b.tryAddShip(sbr2);
    b.whatIsAt(new Coordinate(1, 2), false);
    
    b.tryAddShip(sbr);
    assertEquals(b.fireAt(new Coordinate(1, 2)), sbr);
    b.SonarDetect(h2_2);
  }

  @Test
  public void test_whatisAt() throws IOException{
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    BufferedReader input = new BufferedReader(new StringReader("A0v\n"));
    PrintStream output = new PrintStream(bytes, true);
    Board<Character> board = new BattleShipBoard<Character>(5, 5, 'X');
    V1ShipFactory shipFactory = new V1ShipFactory();
    TextPlayer p1 = new TextPlayer("A", board, input, output, shipFactory, false);
    HashMap<String, Function<Placement, Ship<Character>>> shipCreationFns = new HashMap<String, Function<Placement, Ship<Character>>>();
    shipCreationFns.put("Submarine", (p) -> shipFactory.makeSubmarine(p));
    p1.doOnePlacement("Submarine",shipCreationFns.get("Submarine"));
    p1.theBoard.fireAt(new Coordinate(0, 0));
    // p1.moveShip(new Coordinate(3,3));
    p1.theBoard.whatIsAtForEnemy(new Coordinate(0, 0));
  }
}
