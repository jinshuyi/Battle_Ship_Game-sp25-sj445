package edu.duke.sj445.battleship;

public class SimpleShipDisplayInfo<T> implements ShipDisplayInfo<T>{
  private T myData;
  private T onHit;

  public SimpleShipDisplayInfo(T myData, T onHit){
    this.myData = myData;
    this.onHit = onHit;
  }
    
  @Override
  public T getInfo(Coordinate where, boolean hit) {
    // TODO Auto-generated method stub
    if (hit){
      return onHit;
    }
    else{
      return myData;
    }
  }

}
