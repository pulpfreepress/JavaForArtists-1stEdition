/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ListeningMainFrame6 extends ListeningMainFrame5 {

  protected void addListeners() {
    super.addListeners();
    ChangeListener myChangeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider)e.getSource();
        int value = slider.getValue();
        sliderLabel.setText(String.valueOf(value));
        Font font = textArea.getFont();
        textArea.setFont(font.deriveFont((float)value));
      }
    };

    fontSizeSlider.addChangeListener(myChangeListener);
  }
  public static void main(String[] arg) {
    ListeningMainFrame6 frame = new ListeningMainFrame6();
  }
}