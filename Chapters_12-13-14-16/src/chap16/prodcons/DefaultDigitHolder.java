/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.prodcons;

public class DefaultDigitHolder implements DigitHolder {
  private int digit;

  public void store(int digit) {
    this.digit = digit;
  }
  public int retrieve() {
    return digit;
  }
}