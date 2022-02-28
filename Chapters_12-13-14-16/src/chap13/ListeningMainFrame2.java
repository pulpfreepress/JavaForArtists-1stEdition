/*****************************************************************  Copyright 2006 Rick Miller, Raffi Kasparian - Pulp Free Press         This source code accompanies the text Java For Artists and is
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.*****************************************************************/

package chap13;

public class ListeningMainFrame2 extends ListeningMainFrame1 {

  protected void addListeners() {
    super.addListeners();
    MyMouseListener myMouseListener = new MyMouseListener(eventLabel);
    textArea.addMouseListener(myMouseListener);
    textArea.addMouseMotionListener(myMouseListener);
    textArea.addMouseWheelListener(myMouseListener);
  }
  public static void main(String[] arg) {
    ListeningMainFrame2 frame = new ListeningMainFrame2();
  }
}