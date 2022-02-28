/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import chap13.ListeningMainFrame7;

public class Exercise3 extends ListeningMainFrame7 {
  protected void addListeners() {
    super.addListeners();
    textArea.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_H && e.isControlDown()) {
          JOptionPane.showConfirmDialog(Exercise3.this, "Do you need help?");
        }
      }
    });
  }
  public static void main(String[] arg) {
    new Exercise3();
  }
}
