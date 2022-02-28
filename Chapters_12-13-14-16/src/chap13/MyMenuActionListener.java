/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyMenuActionListener implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    JMenuItem item = (JMenuItem)o;
    JOptionPane.showMessageDialog(
      item,
      "You selected \"" + item.getText() + "\".");
  }
}