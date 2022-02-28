/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListeningMainFrame7 extends ListeningMainFrame6 {

  protected void addListeners() {
    super.addListeners();
    saladList.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        chosenItemTextField.setText((String)saladList.getSelectedValue());
      }
    });
  }
  public static void main(String[] arg) {
    ListeningMainFrame7 frame = new ListeningMainFrame7();
  }
}