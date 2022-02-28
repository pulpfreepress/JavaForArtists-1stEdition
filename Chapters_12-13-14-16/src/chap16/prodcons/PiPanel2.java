/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.prodcons;

import chap16.pi.PiPanel1;

public class PiPanel2 extends PiPanel1 {
  private Object lock = new Object();

  protected void pauseImpl() {
    synchronized (lock) {
      try {
        lock.wait();
      } catch (InterruptedException e) {}
    }
  }
  protected void playImpl() {
    synchronized (lock) {
      lock.notify();
    }
  }
}