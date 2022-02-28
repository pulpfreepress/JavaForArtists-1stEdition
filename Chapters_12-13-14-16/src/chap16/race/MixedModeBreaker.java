/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.race;

public class MixedModeBreaker extends Thread {
  private final static LongSetter longSetter = new LongSetter();

  private final long value;
  private boolean synch;

  public MixedModeBreaker(long value, boolean synch) {
    this.value = value;
    this.synch = synch;
  }
  public void run() {
    long count = 0;
    boolean success;

    while (true) {
      if (synch) {
        synchronized (longSetter) {
          success = longSetter.set(value);
        }
      } else {
        success = longSetter.set(value);
      }
      count++;
      if (synch && !success) {
        System.out.println(
          "Breaker " + value + " broke after " + count + " tries.");
        System.exit(0);
      }
    }
  }
  public static void main(String[] arg) {
    new MixedModeBreaker(1, false).start();
    new MixedModeBreaker(2, false).start();
    new MixedModeBreaker(3, false).start();
    new MixedModeBreaker(4, true).start();
  }
}