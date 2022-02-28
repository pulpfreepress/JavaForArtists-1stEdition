/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

package chap16.race;

public class SynchedBreaker extends Thread {
  private final static LongSetter longSetter = new LongSetter();

  private final long value;

  public SynchedBreaker(long value) {
    this.value = value;
  }
  public void run() {
    long count = 0;
    boolean success;

    while (true) {
      synchronized (longSetter) {
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
    new SynchedBreaker(1).start();
    new SynchedBreaker(2).start();
    new SynchedBreaker(3).start();
    new SynchedBreaker(4).start();
  }
}