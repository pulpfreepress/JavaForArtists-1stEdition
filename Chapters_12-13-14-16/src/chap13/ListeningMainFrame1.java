/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.event.ActionListener;

public class ListeningMainFrame1 extends ListeningMainFrame0 {

  protected void addListeners() {
    super.addListeners();
    ActionListener myMenuActionListener = new MyMenuActionListener();
    menuItem1.addActionListener(myMenuActionListener);
    menuItem2.addActionListener(myMenuActionListener);
    menuItem3.addActionListener(myMenuActionListener);
    menuItem4.addActionListener(myMenuActionListener);
  }
  public static void main(String[] arg) {
    ListeningMainFrame1 frame = new ListeningMainFrame1();
  }
}