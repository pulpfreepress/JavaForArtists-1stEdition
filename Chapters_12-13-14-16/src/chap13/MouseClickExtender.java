/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickExtender extends MouseAdapter {
  public void mouseClicked(MouseEvent e) {
    System.out.println("mouseClicked");
  }
}