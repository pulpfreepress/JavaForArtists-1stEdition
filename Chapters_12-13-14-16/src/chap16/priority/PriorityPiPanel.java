/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap16.priority;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import chap16.pi.PiPanel1;

public class PriorityPiPanel extends PiPanel1 {
  public PriorityPiPanel() {
    Vector choices = new Vector();
    for (int i = Thread.MIN_PRIORITY; i <= Thread.MAX_PRIORITY; ++i) {
      choices.add(new Integer(i));
    }
    final JComboBox cb = new JComboBox(choices);
    cb.setMaximumRowCount(choices.size());
    cb.setSelectedItem(new Integer(producerThread.getPriority()));
    cb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Integer item = (Integer)cb.getSelectedItem();
        int priority = item.intValue();
        producerThread.setPriority(priority);
      }
    });
    buttonPanel.add(cb, BorderLayout.WEST);
  }
  public static void main(String[] arg) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new GridLayout(2, 1));
    f.getContentPane().add(new PriorityPiPanel());
    f.getContentPane().add(new PriorityPiPanel());
    f.pack();
    f.show();
  }
}