/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

package chap16.prodcons;

public class BadDigitHolder extends DefaultDigitHolder {
  public synchronized void store(int digit) {
    super.store(digit);
  }
  public synchronized int retrieve() {
    return super.retrieve();
  }
}