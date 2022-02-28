/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class MyKeyListener implements KeyListener {
  JLabel eventLabel;

  public MyKeyListener(JLabel eventLabel) {
    this.eventLabel = eventLabel;
  }
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