/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.prodcons;

public class GoodDigitHolder extends DefaultDigitHolder {
  private boolean haveDigit = false;

  public synchronized void store(int digit) {
    while (haveDigit) {
      try {
        wait();
      } catch (InterruptedException e) {}
    }
    super.store(digit);
    haveDigit = true;
    notify();
  }
  public synchronized int retrieve() {
    while (!haveDigit) {
      try {
        wait();
      } catch (InterruptedException e) {}
    }
    haveDigit = false;
    notify();
    return super.retrieve();
  }
}