/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.clock;

import java.awt.Component;

public class ClockThread extends Thread {
  private Component component;

  public ClockThread(Component component) {
    this.component = component;
    setName("Clock Thread");
  }
  public void run() {
    while (true) {
      long currentMillis = System.currentTimeMillis();
      long sleepMillis = 1000 - (currentMillis % 1000);
      component.repaint();
      try {
        Thread.sleep(sleepMillis);
      } catch (InterruptedException e) {}
    }
  }
}