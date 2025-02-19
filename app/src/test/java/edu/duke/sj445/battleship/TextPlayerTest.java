package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class TextPlayerTest {
  private void test_Placement(String prompt, Placement[] expected) throws IOException{
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    TextPlayer player = createTextPlayer(10, 20, "B2V\nC8H\na4v\n", bytes);
    for (int i = 0; i < expected.length; i++) {
      Placement p = player.readPlacement(prompt, false);
      assertEquals(p, expected[i]); //did we get the right Placement back
      assertEquals(prompt + "\n", bytes.toString()); //should have printed prompt and newline
      bytes.reset(); //clear out bytes for next time around
     }
    assertThrows(EOFException.class, ()->player.readPlacement(prompt, false));
  }

    @Test
  void test_do_One_Placement() throws IOException{
    String line = "--------------------------------------------------------------------------------\n";
    String instr = "Player A Where do you want to place a Destroyer?";
    String prompt = line + instr + "\n" + line;
    String[] expected = new String[2];
    expected[0] = "  0|1|2\n"+"A d| |  A\n"+"B d| |  B\n"+"C d| |  C\n"+"D  | |  D\n"+"  0|1|2\n";
    expected[1] = "  0|1|2\n"+"A d| |  A\n"+"B d| |  B\n"+"C d| |  C\n"+"D d|d|d D\n"+"  0|1|2\n";
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    TextPlayer player = createTextPlayer(3, 4, "a0V\nD0H\n", bytes);
    V1ShipFactory shipFactory = new V1ShipFactory();
    HashMap<String, Function<Placement, Ship<Character>>> shipCreationFns = new HashMap<String, Function<Placement, Ship<Character>>>();
    shipCreationFns.put("Submarine", (p) -> shipFactory.makeSubmarine(p));
    shipCreationFns.put("Carrier", (p) -> shipFactory.makeCarrier(p));
    shipCreationFns.put("Destroyer", (p) -> shipFactory.makeDestroyer(p));
    shipCreationFns.put("Battleship", (p) -> shipFactory.makeBattleship(p));
    for(int i=0;i<expected.length;i++){
      player.doOnePlacement("Destroyer",shipCreationFns.get("Destroyer"));
      assertEquals(prompt + "Current ocean:\n" + expected[i] + line, bytes.toString());
      bytes.reset();
    }
    player.useSonar(player.theBoard, new Coordinate(4, 0));
    TextPlayer player2 = createTextPlayer(3, 4, "a0a\na4\n", bytes);
    V1ShipFactory sf = new V1ShipFactory();
    assertThrows(EOFException.class, ()->player2.doOnePlacement("Carrier", (p)->sf.makeCarrier(p)));
    
    //player2.doOnePlacement("Destroyer",shipCreationFns.get("Destroyer"));
  }

   @Test
  void test_read_placement() throws IOException{
    String prompt = "Please enter a location for a ship:\n";
    Placement[] expected = new Placement[3];
    expected[0] = new Placement(new Coordinate(1, 2), 'V');
    expected[1] = new Placement(new Coordinate(2, 8), 'H');
    expected[2] = new Placement(new Coordinate(0, 4), 'V');
    test_Placement(prompt, expected);
    
  }

  private TextPlayer createTextPlayer(int w, int h, String inputData, OutputStream bytes) {
    BufferedReader input = new BufferedReader(new StringReader(inputData));
    PrintStream output = new PrintStream(bytes, true);
    Board<Character> board = new BattleShipBoard<Character>(w, h, 'X');
    V1ShipFactory shipFactory = new V1ShipFactory();
    return new TextPlayer("A", board, input, output, shipFactory, false);
  }

  @Test
  void test_null() throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    TextPlayer p1 = createTextPlayer(3, 3, "", bytes);
    V1ShipFactory sf = new V1ShipFactory();
    assertThrows(IOException.class, ()->p1.doOnePlacement("Carrier", (p)->sf.makeCarrier(p)));
  }

  @Test
  void test_throw() throws IOException{
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    TextPlayer p1 = createTextPlayer(3, 3, "A0v\n", bytes);
    V1ShipFactory sf = new V1ShipFactory();
    // p1.doPlacementPhase();
  }

  @Test
  public void test_display2Boards() throws IOException{
    String expected =
    "---------------------------------------------------------------------------\n"+
    "Player A's turn:\n"+
    "     Your ocean                 Player B's ocean\n"+
    "  0|1|2|3|4                    0|1|2|3|4\n"+
    "A  | | | |  A                A  | | | |  A\n"+
    "B  | | | |  B                B  | | | |  B\n"+
    "C  | | | |  C                C  | | | |  C\n"+
    "  0|1|2|3|4                    0|1|2|3|4\n"+
    "---------------------------------------------------------------------------\n";
    TextPlayer player = createTextPlayer(5,3,"a0v\n",new ByteArrayOutputStream());
    Board<Character> enemy = new BattleShipBoard<Character>(5, 3,'X');
    BoardTextView enemyView = new BoardTextView(enemy);
    String b = player.displayMyBoardWithEnemyNextToIt(enemyView,"Your ocean","Player B's ocean");
    assertEquals(b, expected);

    V1ShipFactory shipFactory = new V1ShipFactory();
    HashMap<String, Function<Placement, Ship<Character>>> shipCreationFns = new HashMap<String, Function<Placement, Ship<Character>>>();
    shipCreationFns.put("Submarine", (p) -> shipFactory.makeSubmarine(p));
    player.doOnePlacement("Submarine",shipCreationFns.get("Submarine"));
    expected = 
    "---------------------------------------------------------------------------\n"+
    "Player A's turn:\n"+
    "     Your ocean                 Player B's ocean\n"+
    "  0|1|2|3|4                    0|1|2|3|4\n"+
    "A s| | | |  A                A  | | | |  A\n"+
    "B s| | | |  B                B  | | | |  B\n"+
    "C  | | | |  C                C  | | | |  C\n"+
    "  0|1|2|3|4                    0|1|2|3|4\n"+
    "---------------------------------------------------------------------------\n";
    b = player.displayMyBoardWithEnemyNextToIt(enemyView,"Your ocean","Player B's ocean");
    assertEquals(b, expected);

    assertEquals(false, player.ifLost());
    
    player.useSonar(player.theBoard, new Coordinate(0,0));
    player.theBoard.fireAt(new Coordinate(0,0));
    player.theBoard.fireAt(new Coordinate(1,0));
    player.useSonar(enemy, new Coordinate(0,0));
    assertEquals(true, player.ifLost());
  }

  @Test
  public void test_readCoordinate() throws IOException{
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    TextPlayer player = createTextPlayer(3, 3, "A0\na9\nb5\n\n",bytes);
    String line = "---------------------------------------------------------------------------\n";
    Coordinate[] expected = new Coordinate[3];
    expected[0] = new Coordinate(0, 0);
    expected[1] = new Coordinate(0, 9);
    expected[2] = new Coordinate(1, 5);

    for (int i = 0; i < expected.length; i++) {
        Coordinate c = player.readCoordinate("");
        assertEquals(line + line, bytes.toString()); //should have printed prompt and newline
        assertEquals(c, expected[i]); //did we get the right Coordinate back
        bytes.reset(); //clear out bytes for next time around
    }
    assertThrows(IllegalArgumentException.class, ()->player.readCoordinate(""));
    assertThrows(EOFException.class, ()->player.readCoordinate(""));
    assertThrows(EOFException.class, ()->player.readMove());
  }

  @Test void test_ai() throws IOException{
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    BufferedReader input = new BufferedReader(new StringReader(""));
    PrintStream output = new PrintStream(bytes, true);
    Board<Character> board = new BattleShipBoard<Character>(5, 5, 'X');
    V1ShipFactory shipFactory = new V1ShipFactory();
    TextPlayer p1 = new TextPlayer("A", board, input, output, shipFactory, true);
    p1.readPlacement(null, false);
    p1.readPlacement(null, true);
    HashMap<String, Function<Placement, Ship<Character>>> shipCreationFns = new HashMap<String, Function<Placement, Ship<Character>>>();
    shipCreationFns.put("Submarine", (p) -> shipFactory.makeSubmarine(p));
    p1.doOnePlacement("Submarine",shipCreationFns.get("Submarine"));
    p1.readMove();
    // p1.moveShip(new Coordinate(4, 4));
    p1.playOneTurn(board, null, null);
  }
}
