/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.exercises;

import chap16.prodcons.DigitHolder;

public class BufferedDigitHolder implements DigitHolder {
  private final int[] digits;
  private final int maxSize;
  private int size;

  public BufferedDigitHolder(int maxSize) {
    this.maxSize = maxSize;
    digits = new int[maxSize];
  }
  public synchronized void store(int digit) {
    while (size == maxSize) {
      try {
        wait();
      } catch (InterruptedException e) {}
    }
    digits[size] = digit;
    size++;
    notify();
    System.out.println("store: size = " + size());
  }
  public synchronized int retrieve() {
    int digit;
    while (size == 0) {
      try {
        wait();
      } catch (InterruptedException e) {}
    }
    size--;
    System.arraycopy(digits, 1, digits, 0, size);
    digit = digits[0];
    notify();
    System.out.println("retrieve: size = " + size());
    return digit;
  }
	/**
	 * Returns the current number of stored, unretrieved digits
	 */
  public synchronized int size() {
    return size;
  }
}