/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.race;

public class PointlessSynchedBreaker extends Thread {
  private final static LongSetter longSetter = new LongSetter();

  private final long value;

  public PointlessSynchedBreaker(long value) {
    this.value = value;
  }
  public void run() {
    long count = 0;
    boolean success;

    while (true) {
      synchronized (this) {
        success = longSetter.set(value);
      }
      count++;
      if (!success) {
        System.out.println(
          "Breaker " + value + " broke after " + count + " tries.");
        System.exit(0);
      }
    }
  }
  public static void main(String[] arg) {
    new PointlessSynchedBreaker(1).start();
    new PointlessSynchedBreaker(2).start();
    new PointlessSynchedBreaker(3).start();
    new PointlessSynchedBreaker(4).start();
  }
}