/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.timeslicing;

public class SliceMeter extends Thread {
  private static int[] vals = new int[2];
  private static boolean usesTimeSlicing = false;

  private int myIndex;
  private int otherIndex;

  private SliceMeter(int myIndex, int otherIndex) {
    this.myIndex = myIndex;
    this.otherIndex = otherIndex;
    setPriority(Thread.MAX_PRIORITY);
  }
  public void run() {
    int lastOtherVal = vals[otherIndex];
    for (int i = 1; i <= Integer.MAX_VALUE; ++i) {
      if (usesTimeSlicing) {
        return;
      }
      int curOtherVal = vals[otherIndex];
      if (curOtherVal != lastOtherVal) {
        usesTimeSlicing = true;
        int numLoops = curOtherVal - lastOtherVal;
        lastOtherVal = curOtherVal;
        System.out.println(
          ("While meter" + myIndex + " waited, ")
            + ("meter" + otherIndex + " looped " + numLoops + " times"));
      }
      vals[myIndex] = i;
    }
  }
  public static void main(String[] arg) {
    SliceMeter meter0 = new SliceMeter(0, 1);
    SliceMeter meter1 = new SliceMeter(1, 0);
    meter0.start();
    meter1.start();
    try {
      meter0.join();
      meter1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("usesTimeSlicing = " + usesTimeSlicing);
  }
}