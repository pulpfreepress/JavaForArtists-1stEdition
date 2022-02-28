/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.simple;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.TreePrinterUtils;

public class Gui extends JFrame {
  public Gui() {
    Container contentPane = getContentPane();
    JButton button = new JButton("Print Threads");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        TreePrinterUtils.printThreads();
      }
    });
    contentPane.add(button, BorderLayout.CENTER);
    pack();
  }
  public static void main(String[] args) {
    new Gui().show();
  }
}