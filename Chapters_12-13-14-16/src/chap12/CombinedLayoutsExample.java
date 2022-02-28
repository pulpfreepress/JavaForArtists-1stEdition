/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap12;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.TreePrinterUtils;

public class CombinedLayoutsExample extends JFrame {

  public CombinedLayoutsExample() {
    super("CombinedLayoutsExample");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createGUI();
  }

  public void createGUI() {
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(new JButton("WEST"), BorderLayout.WEST);
    contentPane.add(new JButton("NORTH"), BorderLayout.NORTH);
    JPanel gridPanel = new JPanel(new GridLayout(4, 3));
    for (int row = 0; row < 4; ++row) {
      for (int col = 0; col < 3; ++col) {
        gridPanel.add(new JButton("" + row + ", " + col));
      }
    }
    contentPane.add(gridPanel, BorderLayout.CENTER);
  }

  public static void main(String[] arg) {
    JFrame frame = new CombinedLayoutsExample();
    frame.pack();
    frame.setVisible(true);
    TreePrinterUtils.printLayout(frame.getContentPane());
  }
}