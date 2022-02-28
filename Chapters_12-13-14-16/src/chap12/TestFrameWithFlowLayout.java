/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap12;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import utils.TreePrinterUtils;

public class TestFrameWithFlowLayout {
  public static void main(String[] arg) {
    JFrame frame = new JFrame("TestFrameWithFlowLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(200, 200, 200, 200);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new FlowLayout());

    JButton button = new JButton("I'm a JButton");
    button.setBounds(0, 0, 200, 40);
    contentPane.add(button);

    JTextArea textArea =
      new JTextArea("I'm a JTextArea and am designed to hold a lot of text.");
    textArea.setBounds(0, 40, 200, 100);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    contentPane.add(textArea);

    JLabel label = new JLabel("I'm a JLabel");
    label.setBounds(0, 140, 200, 40);
    contentPane.add(label);

    frame.setVisible(true);
    TreePrinterUtils.printLayout(contentPane);
  }
}