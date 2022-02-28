/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Exercise5 extends JFrame {
  public Exercise5() {
    setSize(200, 200);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(Exercise5.this, "Do you really want to quit?");
        if (result == JOptionPane.YES_OPTION) {
          System.exit(0);
        }
      }
    });
  }
  public static void main(String[] arg) {
    new Exercise5().show();
  }
}
