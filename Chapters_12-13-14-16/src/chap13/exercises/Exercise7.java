/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import chap13.ListeningMainFrame0;

public class Exercise7 extends ListeningMainFrame0 {
  protected void addListeners() {
    textArea.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        Rectangle r = textArea.getVisibleRect();
        int x = e.getX();
        int y = e.getY();
        String ns = y < r.y + r.height / 2 ? "N" : "S";
        String ew = x < r.width / 2 ? "W" : "E";
        System.out.println(ns + ew);
      }
    });
  }
  public static void main(String[] arg) {
    new Exercise7();
  }
}
