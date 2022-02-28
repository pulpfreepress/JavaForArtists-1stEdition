/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap12;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.TreePrinterUtils;

public class GridBagLayoutExample {
  public static void main(String[] arg) {
    JFrame frame = new JFrame("GridBagLayoutExample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = gbc.BOTH;
    gbc.gridwidth = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    contentPane.add(new JButton("FM"), gbc);
    gbc.gridx = 1;
    contentPane.add(new JButton("AM"), gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    contentPane.add(new JButton("Seek - Stereo"), gbc);

    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 2;
    contentPane.add(new JButton("Tuning"), gbc);
    frame.pack();
    frame.setVisible(true);

    TreePrinterUtils.printLayout(contentPane);
  }
}