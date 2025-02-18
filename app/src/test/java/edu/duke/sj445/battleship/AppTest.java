package edu.duke.sj445.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

class AppTest {
  //@Disabled
  @Test
  public void test_mode() throws IOException {
    BufferedReader input = new BufferedReader(new StringReader("s\nC\n"));
    String s = App.getGameMode(input);
  }
  
  //  @Disabled
  @Test
  @ResourceLock(value = Resources.SYSTEM_OUT, mode = ResourceAccessMode.READ_WRITE)
  void test_main() throws IOException {
    String[] inputs = new String[5], outputs = new String[5];
    inputs[0] = "input.txt";
    inputs[1] = "input2.txt";
    inputs[2] = "input3.txt";
    inputs[3] = "input4.txt";
    inputs[4] = "input5.txt";
    outputs[0] = "output.txt";
    outputs[1] = "output2.txt";
    outputs[2] = "output3.txt";
    outputs[3] = "output4.txt";
    outputs[4] = "output5.txt";
    
    for(int i = 0; i < 5; i++){
       ByteArrayOutputStream bytes = new ByteArrayOutputStream();
       PrintStream out = new PrintStream(bytes, true);
       //get InputStream
       InputStream input = getClass().getClassLoader().getResourceAsStream(inputs[i]);
       assertNotNull(input);
       //get expected output
       InputStream expectedStream = getClass().getClassLoader().getResourceAsStream(outputs[i]);
       assertNotNull(expectedStream);

    
       InputStream oldIn = System.in;
       PrintStream oldOut = System.out;
       try {
         System.setIn(input);
         System.setOut(out);
         App.main(new String[0]);
       }
       finally {
         System.setIn(oldIn);
         System.setOut(oldOut);
       }
       //read all the data from expectedStream
       String expected = new String(expectedStream.readAllBytes());
       String actual = bytes.toString();  //get the String out of bytes
       assertEquals(expected, actual);
     }
  }
}
