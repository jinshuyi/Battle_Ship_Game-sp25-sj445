package edu.duke.sj445.battleship;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


 /**
   * Test board created whether as expected
   * 
   * @param w: board width
   * @param h: board height
   * @param expectedheader: expected board header
   * @param expectedBody: expected board body
   */
public class BoardTextViewTest {
   private void emptyBoardHelper(int w, int h, String expectedHeader, String expectedBody){
     Board<Character> b1 = new BattleShipBoard<Character>(w, h, 'X');
    
    BoardTextView view = new BoardTextView(b1);
    assertEquals(expectedHeader, view.makeHeader());
    String expected = expectedHeader + expectedBody + expectedHeader;
    assertEquals(expected, view.displayMyOwnBoard());
  }
 
  @Test
  public void test_display_empty_2by2() {
    String expectedHeader= "  0|1\n";
    String expectedBody =  "A  |  A\n"+
                           "B  |  B\n";
    emptyBoardHelper(2, 2, expectedHeader, expectedBody);
  }

  @Test
  public void test_display_empty_3by2() {
    String expectedHeader= "  0|1|2\n";
    String expectedBody =  "A  | |  A\n"+
                           "B  | |  B\n";
    emptyBoardHelper(3, 2, expectedHeader, expectedBody);
  }

  @Test
  public void test_display_empty_3by5() {
    String expectedHeader= "  0|1|2\n";
    String expectedBody =  "A  | |  A\n"+
                           "B  | |  B\n"+
                           "C  | |  C\n"+
                           "D  | |  D\n"+
                           "E  | |  E\n";
    emptyBoardHelper(3, 5, expectedHeader, expectedBody);
  }

  @Test
  public void test_invalid_board_size() {
    Board<Character> wideBoard = new BattleShipBoard<Character>(11,20, 'X');
    Board<Character> tallBoard = new BattleShipBoard<Character>(10,27, 'X');
    //you should write two assertThrows here
    assertThrows(IllegalArgumentException.class, () -> new BoardTextView(wideBoard));
    assertThrows(IllegalArgumentException.class, () -> new BoardTextView(tallBoard));
  }

  @Test
  public void test_non_empty_board(){
    Board<Character> b1 = new BattleShipBoard<Character>(3, 4, 'X');
    Placement p1 = new Placement("A1h");
    b1.tryAddShip(new RectangleShip<Character>(p1.getWhere(), 's', '*', p1));
    BoardTextView view = new BoardTextView(b1);
    String expectedHeader= "  0|1|2\n";
    String expectedBody =  "A  |s|  A\n"+
                           "B  | |  B\n"+
                           "C  | |  C\n"+
                           "D  | |  D\n";
    String expected = expectedHeader + expectedBody + expectedHeader;
    assertEquals(expected, view.displayMyOwnBoard());
  }
  
  @Test
  public void test_enemyBoard(){
    Board<Character> b = new BattleShipBoard<Character>(4,3,'X');
    BoardTextView view = new BoardTextView(b);
    String myView_empty =
      "  0|1|2|3\n" +
      "A  | | |  A\n" +
      "B  | | |  B\n" +
      "C  | | |  C\n" +
      "  0|1|2|3\n";
    assertEquals(myView_empty,view.displayMyOwnBoard());
    assertEquals(myView_empty,view.displayEnemyBoard());

    V1ShipFactory f = new V1ShipFactory();
    Ship<Character> s1 = f.makeSubmarine(new Placement(new Coordinate(0,0),'V'));
    assertEquals(b.tryAddShip(s1),null);
    String myView =
      "  0|1|2|3\n" +
      "A s| | |  A\n" +
      "B s| | |  B\n" +
      "C  | | |  C\n" +
      "  0|1|2|3\n";
    assertEquals(myView,view.displayMyOwnBoard());
    assertEquals(myView_empty,view.displayEnemyBoard());

    b.fireAt(new Coordinate(0,0));
    String myViewHit =
      "  0|1|2|3\n" +
      "A *| | |  A\n" +
      "B s| | |  B\n" +
      "C  | | |  C\n" +
      "  0|1|2|3\n";
    String enemyViewHit1 =
      "  0|1|2|3\n" +
      "A s| | |  A\n" +
      "B  | | |  B\n" +
      "C  | | |  C\n" +
      "  0|1|2|3\n";
    assertEquals(myViewHit,view.displayMyOwnBoard());
    assertEquals(enemyViewHit1,view.displayEnemyBoard());

    b.fireAt(new Coordinate(0,1));
    String enemyViewHit2 =
      "  0|1|2|3\n" +
      "A s|X| |  A\n" +
      "B  | | |  B\n" +
      "C  | | |  C\n" +
      "  0|1|2|3\n";
    assertEquals(myViewHit,view.displayMyOwnBoard());
    assertEquals(enemyViewHit2,view.displayEnemyBoard());
  }
}
