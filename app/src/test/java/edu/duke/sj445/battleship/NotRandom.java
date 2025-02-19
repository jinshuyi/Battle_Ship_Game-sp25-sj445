package edu.duke.sj445.battleship;

import java.util.Random;

public class NotRandom extends Random {
  int[] data;
  String[] place;
  int indexPlace;

  public NotRandom() {
    int[] data = new int[20];
    for(int i = 0; i < 20; i++){
      data[i] = i;
    }
    
    this.data = data;
    String[] place = {"k9", "q2", "l6", "m7", "b6", "e2", "n2", "f1", "m9", "f2", "i8", "c4", "k8", "p2", "p7", "e3"};
    this.place = place;
    this.indexPlace = 0;
 }
  
   public int nextInt(int t)  {
     int ans;
     ans = data[t];
     return ans;
   }
  public String placeCoordinate() {
    this.indexPlace++;
    return this.place[indexPlace - 1];
  }
}

