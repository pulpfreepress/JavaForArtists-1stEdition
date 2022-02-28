/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class ListeningMainFrame4 extends ListeningMainFrame3 {

  protected void addListeners() {
    super.addListeners();

    class ColorButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == bgColorButton) {
          Color color = displayOptionsPanel.getBackground();
          color =
            JColorChooser.showDialog(
              bgColorButton,
              "Choose Background Color",
              color);
          if (color != null) {
            displayOptionsPanel.setBackground(color);
          }
        } else if (o == defaultColorButton) {
          displayOptionsPanel.setBackground(null);
        }
      }
    };

    ColorButtonListener colorButtonListener = new ColorButtonListener();
    bgColorButton.addActionListener(colorButtonListener);
    defaultColorButton.addActionListener(colorButtonListener);
  }
  public static void main(String[] arg) {
    ListeningMainFrame4 frame = new ListeningMainFrame4();
  }
}