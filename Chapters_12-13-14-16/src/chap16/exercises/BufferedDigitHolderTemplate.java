/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

//insert package declarations and imports as desired
import chap16.prodcons.DigitHolder;

public class BufferedDigitHolder implements DigitHolder {
  private final int[] digits;
  //insert fields here as desired

  public BufferedDigitHolder(int maxSize) {
    //insert code here as desired
    digits = new int[maxSize];
  }
  public synchronized void store(int digit) {
    //insert code here as desired
    System.out.println("store: size = " + size());
  }
  public synchronized int retrieve() {
    int digit;
    //insert code here as desired
    System.out.println("retrieve: size = " + size());
    return digit;
  }
  /**
   * Returns the current number of stored, unretrieved digits
   */
  public synchronized int size() {
    //insert code here as desired
  }
}