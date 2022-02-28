/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import chap13.ListeningMainFrame0;

public class Exercise6 extends ListeningMainFrame0 {
  protected void addListeners() {
    saladList.addMouseListener(new MyMouseListener());
  }
  private class MyMouseListener extends MouseAdapter {
    long lastPressTime = Long.MAX_VALUE;
    public void mousePressed(MouseEvent e) {
      if (SwingUtilities.isLeftMouseButton(e)) {
        lastPressTime = e.getWhen();
      }
    }
    public void mouseReleased(MouseEvent e) {
      if (SwingUtilities.isLeftMouseButton(e)) {
        long releaseTime = e.getWhen();
        if (releaseTime - lastPressTime >= 5000) {
          System.out.println("Five seconds or more");
        }
        lastPressTime = Long.MAX_VALUE;

      }
    }
  }
  public static void main(String[] arg) {
    new Exercise6();
  }
}
