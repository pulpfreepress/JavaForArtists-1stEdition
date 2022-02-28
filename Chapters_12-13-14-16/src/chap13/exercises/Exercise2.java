/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13.exercises;

import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import chap13.ListeningMainFrame5;

public class Exercise2 extends ListeningMainFrame5 implements ChangeListener{

  protected void addListeners() {
    super.addListeners();
    fontSizeSlider.addChangeListener(this);
  }
	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider)e.getSource();
		int value = slider.getValue();
		sliderLabel.setText(String.valueOf(value));
		Font font = textArea.getFont();
		textArea.setFont(font.deriveFont((float)value));
	}
  public static void main(String[] arg) {
    Exercise2 frame = new Exercise2();
  }
}
