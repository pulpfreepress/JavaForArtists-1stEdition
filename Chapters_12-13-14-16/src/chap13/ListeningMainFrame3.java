/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListeningMainFrame3 extends ListeningMainFrame2 {

  protected void addListeners() {
    super.addListeners();
    KeyListener myKeyListener = new MyKeyListener();
    textArea.addKeyListener(myKeyListener);
  }
  protected class MyKeyListener implements KeyListener {
    //implementing KeyListener
    public void keyTyped(KeyEvent e) {
      String display = "keyTyped: " + String.valueOf(e.getKeyChar());
      System.out.println(display);
      eventLabel.setText(display);
    }
    public void keyPressed(KeyEvent e) {
      String display = "keyPressed: " + String.valueOf(e.getKeyChar());
      System.out.println(display);
      eventLabel.setText(display);
    }
    public void keyReleased(KeyEvent e) {
      String display = "keyReleased: " + String.valueOf(e.getKeyChar());
      System.out.println(display);
      eventLabel.setText(display);
    }
  }
  public static void main(String[] arg) {
    ListeningMainFrame3 frame = new ListeningMainFrame3();
  }
}